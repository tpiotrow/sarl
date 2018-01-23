/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2017 the original authors or authors.
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

import io.sarl.aspectjgenerator.AJGeneratorPlugin;
import io.sarl.aspectjgenerator.configuration.AJOutputConfigurationProvider;
import io.sarl.lang.compiler.extra.AbstractExtraLanguageGenerator;
import io.sarl.lang.compiler.extra.IExpressionGenerator;
import io.sarl.lang.compiler.extra.IExtraLanguageGeneratorContext;
import io.sarl.lang.sarl.SarlAgent;
import io.sarl.lang.sarl.SarlField;

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
		it.append(" newValue) : set("); //$NON-NLS-1$
		it.append(member.getType().getSimpleName());
		it.append(" "); //$NON-NLS-1$
		it.append(agentName);
		it.append("."); //$NON-NLS-1$
		it.append(member.getName());
		it.append(") && args(newValue) {"); //$NON-NLS-1$
		it.increaseIndentation().newLine();

		// Before advice body
		it.append("if ( !("); //$NON-NLS-1$
		getExpressionGenerator().generate(member.getInvariant().getCondition(), it, context);
		it.append(") ) {"); //$NON-NLS-1$
		it.increaseIndentation().newLine();
		it.append("Logger.getLogger(" + agentName +  ").log(\"Invariant broken with value: \" + newValue);"); //$NON-NLS-1$ //$NON-NLS-2$
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
		final QualifiedName name = getQualifiedNameProvider().getFullyQualifiedName(agent);
		writeFile(name, appendable, context);
	}

}
