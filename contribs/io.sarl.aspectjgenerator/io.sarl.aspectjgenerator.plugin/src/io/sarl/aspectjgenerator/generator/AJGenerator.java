/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2018 the original authors or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sarl.aspectjgenerator.generator;

import com.google.inject.Inject;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xtype.XImportDeclaration;

import io.sarl.aspectjgenerator.AJGeneratorPlugin;
import io.sarl.aspectjgenerator.configuration.AJOutputConfigurationProvider;
import io.sarl.lang.compiler.extra.AbstractExtraLanguageGenerator;
import io.sarl.lang.compiler.extra.ExtraLanguageAppendable;
import io.sarl.lang.compiler.extra.IExpressionGenerator;
import io.sarl.lang.compiler.extra.IExtraLanguageGeneratorContext;
import io.sarl.lang.sarl.SarlAgent;
import io.sarl.lang.sarl.SarlField;
import io.sarl.lang.sarl.SarlScript;

/** The generator from SARL to AspectJ language.
 *
 * <p>Note: we only translate constraints so
 * we ignore irrelevant SARL constructs.</p>
 *
 * @author $Author: tpiotrow$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class AJGenerator extends AbstractExtraLanguageGenerator {

	private static final String ASPECTJ_FILENAME_EXTENSION = ".aj"; //$NON-NLS-1$

	//private static final Logger ASPECTJ_GENERATOR_LOGGER = Logger.getLogger(AJGenerator.class.getSimpleName());

	private AJExpressionGenerator expressionGenerator;

	@Override
	public IExpressionGenerator getExpressionGenerator() {
		return this.expressionGenerator;
	}

	/** Sets the expression generator.
	 * @param generator the expression generator to set
	 */
	@Inject
	public void setExpressionGenerator(AJExpressionGenerator generator) {
		this.expressionGenerator = generator;
	}

	@Override
	protected String getFilenameExtension() {
		return ASPECTJ_FILENAME_EXTENSION;
	}

	@Override
	protected String getOutputConfigurationName() {
		return AJOutputConfigurationProvider.OUTPUT_CONFIGURATION_NAME;
	}

	@Override
	public String getPluginID() {
		return AJGeneratorPlugin.PLUGIN_ID;
	}

	@Override
	protected AJAppendable createAppendable(IExtraLanguageGeneratorContext context) {
		return new AJAppendable(getTypeConverter(context));
	}

	@Override
	protected void generateImportStatement(QualifiedName importedQualifiedName, ExtraLanguageAppendable appendable,
			IExtraLanguageGeneratorContext context) {
		super.generateImportStatement(importedQualifiedName, appendable, context);
		appendable.append("import ");
		appendable.append(importedQualifiedName.toString());
		appendable.append(";");
		appendable.newLine();
	}

	/** Create an aspect for the given agent.
	 *
	 * @param member the field from which the aspect is generated.
	 * @param agentName the agent's name from whom the aspect is generated.
	 * @param it the output
	 * @param context the generation context.
	 */
	protected void generateBeforeAdvice(SarlField member, String agentName, AJAppendable it, IExtraLanguageGeneratorContext context) {

		// Before advice header
		it.append("before ("); //$NON-NLS-1$
		it.append(member.getType().getSimpleName());
		it.append(" $$val$$) : set("); //$NON-NLS-1$
		it.append(member.getType().getSimpleName());
		it.append(" "); //$NON-NLS-1$
		it.append(agentName);
		it.append("."); //$NON-NLS-1$
		it.append(member.getName());
		it.append(") && args($$val$$) {"); //$NON-NLS-1$
		it.increaseIndentation().newLine();

		// Before advice body
		it.append("if ( !("); //$NON-NLS-1$
		getExpressionGenerator().generate(member.getInvariant().getCondition(), it, context);
		it.append(") ) {"); //$NON-NLS-1$
		it.increaseIndentation().newLine();

		// TODO : get generated expression from generator and add it to debug message
		it.append("Logger.getLogger(" + agentName +  ".class.getSimpleName())"
				+ ".severe(\"Invariant broken with value: \" + $$val$$);");
		it.decreaseIndentation().newLine();
		it.append("}"); //$NON-NLS-1$ // If statement closed

		it.decreaseIndentation().newLine();
		it.append("}"); //$NON-NLS-1$ // Advice closed
	}

	/** Generate the given object.
	 *
	 * @param agent the agent.
	 * @param context the context.
	 */
	protected void _generate(SarlAgent agent, IExtraLanguageGeneratorContext context) {
		final AJAppendable appendable = createAppendable(context);
		final QualifiedName agentName = getQualifiedNameProvider().getFullyQualifiedName(agent);

		if (!(agent.eContainer() instanceof SarlScript)) {
			throw new IllegalStateException("Agent not contained in script");
		}

		final SarlScript script = (SarlScript) agent.eContainer();

		// Imports section
		appendable.append("package ");
		appendable.append(agentName.skipLast(1).toString());
		appendable.append(";");

		appendable.newLine().newLine();

		// Logger is always needed by the advices bodies.
		appendable.append("import java.util.logging.Logger;").newLine(); //$NON-NLS-1$
		// Maybe there is a way to detect if the aspect _need_ to use IntegerRange
		// dynamically, but in the mean time, include it by default.
		appendable.append("import org.eclipse.xtext.xbase.lib.IntegerRange;").newLine(); //$NON-NLS-1$

		// We have to include the java import used by agent, otherwise aspect won't compile
		for (final XImportDeclaration inport : script.getImportSection().getImportDeclarations()) {
			if (inport.getImportedTypeName().startsWith("java.")
					&& !inport.getImportedTypeName().equals("java.util.logging.Logger")) {
				appendable.append("import " + inport.getImportedTypeName());
				appendable.append(";");
				appendable.newLine();
			}
		}

		appendable.newLine();

		// Aspect section
		appendable.append("public privileged aspect "); //$NON-NLS-1$
		appendable.append(agent.getName());
		appendable.append("Aspect {"); //$NON-NLS-1$
		appendable.increaseIndentation().newLine();

		for (final XtendMember member : agent.getMembers()) {
			if (member instanceof SarlField) {
				final SarlField field = (SarlField) member;
				if (field.getInvariant() != null) {
					appendable.newLine();
					generateBeforeAdvice(field, agent.getName(), appendable, context);
					appendable.newLine();
				}
			}
		}
		appendable.decreaseIndentation().newLine().append("}"); //$NON-NLS-1$

		/*
		 * Initially, the QN contains the correct agent name. However, appending
		 * the string "Aspect" would create a new segement, which we don't want.
		 * That's why we have to skip the last segment and recreate it to form
		 * the correct QN.
		 */
		writeFile(agentName.skipLast(1).append(agent.getName() + "Aspect"), appendable, context);
	}

}
