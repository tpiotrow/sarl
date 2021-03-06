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

package io.sarl.lang.compiler;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.compiler.XtendCompiler;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import io.sarl.lang.jvmmodel.Messages;
import io.sarl.lang.jvmmodel.SARLJvmModelInferrer;
import io.sarl.lang.sarl.SarlAssertExpression;
import io.sarl.lang.sarl.SarlBreakExpression;
import io.sarl.lang.sarl.SarlContinueExpression;
import io.sarl.lang.typesystem.SARLExpressionHelper;


/** The compiler from SARL to the target language.
 *
 * <p>This compiler provide a specific support for inline annotations. Indeed, the Xbase inline evaluation does
 * not support variadic parameters. This SARL compiler provides a support for variadic feature calls.
 *
 * <p>Additionally, this compiler supports the Inline annotation for non-static calls, by skipping the left
 * operand of a member feature call when the inline expression is constant.
 * See https://github.com/eclipse/xtext-extras/pull/62.
 *
 * <p>This compiler supports also the "$0" parameter in inline expression. This parameter represents the
 * current receiver, e.g. "this.".
 *
 * <p>The compiler supports the SARL keywords: break.
 *
 * <p>This compiler catches exceptions when generating statements for expressions in order to let the compiler
 * to generate as much as possible.
 *
 * <p>The roles of the different generation tools are:<ul>
 * <li>{@link SARLJvmModelInferrer}: Generating the expected Java Ecore model from the SARL Ecore model.</li>
 * <li>{@link ILinker}: Create links among the SARL Ecore models.<li>
 * <li>{@link SARLJvmGenerator}: Generate the Java code from the Java Ecore model.</li>
 * <li>{@link SarlCompiler}: Generate the Java code for the XExpression objects.</li>
 * </ul>
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.4
 */
@SuppressWarnings("checkstyle:classfanoutcomplexity")
public class SarlCompiler extends XtendCompiler {

	private static final String INLINE_VARIABLE_PREFIX = "$"; //$NON-NLS-1$

	private static final String INLINE_VALUE_NAME = "value"; //$NON-NLS-1$

	private static final String INLINE_IMPORTED_NAME = "imported"; //$NON-NLS-1$

	private static final Pattern INLINE_VARIABLE_PATTERN = Pattern.compile("\\" + INLINE_VARIABLE_PREFIX //$NON-NLS-1$
			+ "(\\" + INLINE_VARIABLE_PREFIX + "|[0-9]+)"); //$NON-NLS-1$ //$NON-NLS-2$

	@Inject
	private Logger log;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private IBatchTypeResolver batchTypeResolver;

	@Inject
	private IGeneratorConfigProvider generatorConfigProvider;

	@Inject
	private SARLExpressionHelper sarlExpressionHelper;

	@SuppressWarnings({"checkstyle:returncount", "checkstyle:npathcomplexity", "checkstyle:cyclomaticcomplexity"})
	private static String getAnnotationStringValue(JvmAnnotationValue value) {
		if (value instanceof JvmAnnotationAnnotationValue) {
			return ((JvmAnnotationAnnotationValue) value).getValues().get(0).getAnnotation().getIdentifier();
		}
		if (value instanceof JvmBooleanAnnotationValue) {
			return ((JvmBooleanAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmByteAnnotationValue) {
			return ((JvmByteAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmCharAnnotationValue) {
			return ((JvmCharAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmCustomAnnotationValue) {
			final EObject evalue = ((JvmCustomAnnotationValue) value).getValues().get(0);
			if (evalue instanceof XStringLiteral) {
				return ((XStringLiteral) evalue).getValue();
			}
			if (evalue instanceof XNumberLiteral) {
				return ((XNumberLiteral) evalue).getValue();
			}
			if (evalue instanceof XBooleanLiteral) {
				return ((XNumberLiteral) evalue).getValue();
			}
			if (evalue instanceof XTypeLiteral) {
				return ((XTypeLiteral) evalue).getType().getIdentifier();
			}
		}
		if (value instanceof JvmDoubleAnnotationValue) {
			return ((JvmDoubleAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmEnumAnnotationValue) {
			return ((JvmEnumAnnotationValue) value).getValues().get(0).getSimpleName();
		}
		if (value instanceof JvmFloatAnnotationValue) {
			return ((JvmFloatAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmIntAnnotationValue) {
			return ((JvmIntAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmLongAnnotationValue) {
			return ((JvmLongAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmShortAnnotationValue) {
			return ((JvmShortAnnotationValue) value).getValues().get(0).toString();
		}
		if (value instanceof JvmStringAnnotationValue) {
			return ((JvmStringAnnotationValue) value).getValues().get(0);
		}
		if (value instanceof JvmTypeAnnotationValue) {
			return ((JvmTypeAnnotationValue) value).getValues().get(0).getIdentifier();
		}
		return null;
	}

	private static Collection<JvmTypeReference> getAnnotationTypeValue(JvmAnnotationValue value) {
		if (value instanceof JvmTypeAnnotationValue) {
			return ((JvmTypeAnnotationValue) value).getValues();
		}
		return Collections.emptyList();
	}

	@Override
	@SuppressWarnings({"checkstyle:cyclomaticcomplexity", "checkstyle:npathcomplexity"})
	protected synchronized void appendInlineFeatureCall(XAbstractFeatureCall call, ITreeAppendable target) {
		// Overridden for fixing the @Inline behavior
		final JvmAnnotationReference inlineAnnotation = this.expressionHelper.findInlineAnnotation(call);

		String formatString = null;
		final List<JvmTypeReference> importedTypes = Lists.newArrayListWithCapacity(2);
		for (final JvmAnnotationValue annotationValue: inlineAnnotation.getValues()) {
			final String valueName = annotationValue.getValueName();
			if (Strings.isEmpty(valueName)) {
				// Special case: the annotation value as no associated operation.
				// If it appends, we could assumes that the operation is "value()"
				if (!Strings.isEmpty(formatString)) {
					throw new IllegalStateException();
				}
				formatString = getAnnotationStringValue(annotationValue);
			} else if (INLINE_VALUE_NAME.equals(valueName)) {
				if (!Strings.isEmpty(formatString)) {
					throw new IllegalStateException();
				}
				formatString = getAnnotationStringValue(annotationValue);
			} else if (INLINE_IMPORTED_NAME.equals(valueName)) {
				importedTypes.addAll(getAnnotationTypeValue(annotationValue));
			}
		}

		if (formatString == null) {
			throw new IllegalStateException();
		}

		final IResolvedTypes resolvedTypes = this.batchTypeResolver.resolveTypes(call);

		final List<XExpression> arguments = getActualArguments(call);
		final JvmIdentifiableElement calledFeature = call.getFeature();
		int numberVariadicParameter = 0;
		final int numberFormalParameters;
		JvmFormalParameter formalVariadicParameter = null;
		if (calledFeature instanceof JvmExecutable) {
			final JvmExecutable jvmexec = (JvmExecutable) calledFeature;
			numberFormalParameters = jvmexec.getParameters().size();
			if (numberFormalParameters > 0) {
				formalVariadicParameter = jvmexec.getParameters().get(numberFormalParameters - 1);
				if (jvmexec.isVarArgs()) {
					numberVariadicParameter = 1;
				}
			}
		} else {
			numberFormalParameters = arguments.size();
		}
		final Matcher matcher = INLINE_VARIABLE_PATTERN.matcher(formatString);
		int prevEnd = 0;


		while (matcher.find()) {
			final int start = matcher.start();
			if (start != prevEnd) {
				target.append(formatString.substring(prevEnd, start));
			}
			final String indexOrDollar = matcher.group(1);
			if (INLINE_VARIABLE_PREFIX.equals(indexOrDollar)) {
				target.append(INLINE_VARIABLE_PREFIX);
			} else {
				final int index = Integer.parseInt(indexOrDollar) - 1;
				// Treat the $0 parameter in the inline expression
				if (index < 0) {
					final boolean hasReceiver = appendReceiver(call, target, true);
					if (hasReceiver) {
						target.append("."); //$NON-NLS-1$
					}
				} else {
					final int numberImports = importedTypes.size();
					final int numberFormalParametersImports = numberFormalParameters + numberImports;
					if (numberVariadicParameter != 0 && index < arguments.size() && index == (numberFormalParameters - 1)) {
						XExpression argument = arguments.get(index);
						appendArgument(argument, target, index > 0);
						for (int i = index + 1; i < arguments.size(); ++i) {
							target.append(", "); //$NON-NLS-1$
							argument = arguments.get(i);
							appendArgument(argument, target, true);
						}
					} else if (index > numberFormalParametersImports) {
						final List<LightweightTypeReference> typeArguments = resolvedTypes.getActualTypeArguments(call);
						final LightweightTypeReference typeArgument = typeArguments.get(index - numberFormalParametersImports - 1);
						serialize(typeArgument.getRawTypeReference().toTypeReference(), call, target);
					} else if (index >= numberFormalParameters && index < numberFormalParametersImports) {
						serialize(importedTypes.get(index - numberFormalParameters), call, target);
					} else if (index == numberFormalParametersImports) {
						appendTypeArguments(call, target);
					} else if (index < arguments.size()) {
						final XExpression argument = arguments.get(index);
						appendArgument(argument, target, index > 0);
					} else if (formalVariadicParameter != null) {
						appendNullValue(formalVariadicParameter.getParameterType(), calledFeature, target);
					} else {
						throw new IllegalStateException();
					}
				}
			}
			prevEnd = matcher.end();
		}
		if (prevEnd != formatString.length()) {
			target.append(formatString.substring(prevEnd));
		}
	}

	@Override
	public void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		// Overridden for enabling the expressions that are specific to SARL
		if (obj instanceof SarlBreakExpression) {
			_toJavaStatement((SarlBreakExpression) obj, appendable, isReferenced);
		} else if (obj instanceof SarlContinueExpression) {
			_toJavaStatement((SarlContinueExpression) obj, appendable, isReferenced);
		} else if (obj instanceof SarlAssertExpression) {
			_toJavaStatement((SarlAssertExpression) obj, appendable, isReferenced);
		} else {
			try {
				super.doInternalToJavaStatement(obj, appendable, isReferenced);
			} catch (IllegalStateException exception) {
				// Log the exception but do not fail the generation.
				logInternalError(exception);
			}
		}
	}

	@Override
	public void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		// Overridden for enabling the expressions that are specific to SARL
		if (obj instanceof SarlBreakExpression) {
			_toJavaExpression((SarlBreakExpression) obj, appendable);
		} else if (obj instanceof SarlContinueExpression) {
			_toJavaExpression((SarlContinueExpression) obj, appendable);
		} else if (obj instanceof SarlAssertExpression) {
			_toJavaExpression((SarlAssertExpression) obj, appendable);
		} else {
			try {
				super.internalToConvertedExpression(obj, appendable);
			} catch (IllegalStateException exception) {
				// Log the exception but do not fail the generation.
				logInternalError(exception);
			}
		}
	}

	/** Generate the Java code related to the preparation statements for the break keyword.
	 *
	 * @param breakExpression the expression.
	 * @param appendable the output.
	 * @param isReferenced indicates if the expression is referenced.
	 */
	@SuppressWarnings("static-method")
	protected void _toJavaStatement(SarlBreakExpression breakExpression, ITreeAppendable appendable, boolean isReferenced) {
		appendable.newLine().append("break;"); //$NON-NLS-1$
	}

	/** Generate the Java code related to the preparation statements for the break keyword.
	 *
	 * @param breakExpression the expression.
	 * @param appendable the output.
	 * @param isReferenced indicates if the expression is referenced.
	 * @since 0.7
	 */
	@SuppressWarnings("static-method")
	protected void _toJavaStatement(SarlContinueExpression breakExpression, ITreeAppendable appendable, boolean isReferenced) {
		appendable.newLine().append("continue;"); //$NON-NLS-1$
	}

	/** Generate the Java code to the preparation statements for the assert keyword.
	 *
	 * @param assertExpression the expression.
	 * @param appendable the output.
	 * @param isReferenced indicates if the expression is referenced.
	 */
	protected void _toJavaStatement(SarlAssertExpression assertExpression, ITreeAppendable appendable, boolean isReferenced) {
		if (!assertExpression.isIsStatic() && assertExpression.getCondition() != null && isAtLeastJava8(assertExpression)) {
			final XExpression condition = assertExpression.getCondition();
			final LightweightTypeReference actualType = getLightweightType(condition);
			if (actualType != null) {
				final Boolean booleanConstant = this.sarlExpressionHelper.toBooleanPrimitiveWrapperConstant(condition);
				if (booleanConstant != null) {
					appendable.newLine().append("assert "); //$NON-NLS-1$
					appendable.append(booleanConstant.toString());
				} else {
					// Get the local variables.
					final Map<XVariableDeclaration, XFeatureCall> localVariables = getReferencedLocalVariable(condition, true);

					final String className = appendable.declareUniqueNameVariable(assertExpression, "$AssertEvaluator$"); //$NON-NLS-1$

					appendable.openScope();
					try {
						reassignThisInClosure(appendable, findKnownTopLevelType(Object.class, assertExpression));

						appendable.newLine().append("class ").append(className).append(" {"); //$NON-NLS-1$ //$NON-NLS-2$
						appendable.increaseIndentation().newLine();
						appendable.append("final boolean $$result;").newLine(); //$NON-NLS-1$
						appendable.append(className).append("("); //$NON-NLS-1$
						boolean first = true;
						for (final Entry<XVariableDeclaration, XFeatureCall> localVariable : localVariables.entrySet()) {
							if (first) {
								first = false;
							} else {
								appendable.append(", "); //$NON-NLS-1$
							}
							final JvmTypeReference localVariableType = getType(localVariable.getValue());
							appendable.append("final ").append(toLightweight(localVariableType, assertExpression)); //$NON-NLS-1$
							appendable.append(" ").append(localVariable.getKey().getName()); //$NON-NLS-1$
						}
						appendable.append(") {"); //$NON-NLS-1$
						appendable.increaseIndentation();
						internalToJavaStatement(condition, appendable, true);
						appendable.newLine();
						appendable.append("this.$$result = "); //$NON-NLS-1$
						internalToConvertedExpression(condition, appendable, actualType);
						appendable.append(";"); //$NON-NLS-1$
						appendable.decreaseIndentation().newLine();
						appendable.append("}"); //$NON-NLS-1$
						appendable.decreaseIndentation().newLine();
						appendable.append("}"); //$NON-NLS-1$
						appendable.newLine();
						appendable.append("assert new ").append(className).append("("); //$NON-NLS-1$ //$NON-NLS-2$
						first = true;
						for (final XVariableDeclaration localVariable : localVariables.keySet()) {
							if (first) {
								first = false;
							} else {
								appendable.append(", "); //$NON-NLS-1$
							}
							appendable.append(localVariable.getName());
						}
						appendable.append(").$$result"); //$NON-NLS-1$
					} finally {
						appendable.closeScope();
					}
				}
				if (!Strings.isEmpty(assertExpression.getMessage())) {
					appendable.append(" : \""); //$NON-NLS-1$
					appendable.append(Strings.convertToJavaString(assertExpression.getMessage()));
					appendable.append("\""); //$NON-NLS-1$
				}
				appendable.append(";"); //$NON-NLS-1$
			}
		}
	}

	/** Replies all the variables that are referenced into the given expression.
	 *
	 * @param expression the expression.
	 * @param onlyWritable if {@code true} only the writable variables are replied. Otherwise, all variables are replied.
	 * @return the referenced variables.
	 */
	@SuppressWarnings("static-method")
	protected Map<XVariableDeclaration, XFeatureCall> getReferencedLocalVariable(XExpression expression, boolean onlyWritable) {
		final Map<XVariableDeclaration, XFeatureCall> localVariables = new TreeMap<>((k1, k2) -> {
			return k1.getIdentifier().compareTo(k2.getIdentifier());
		});
		for (final XFeatureCall featureCall : EcoreUtil2.getAllContentsOfType(expression, XFeatureCall.class)) {
			if (featureCall.getFeature() instanceof XVariableDeclaration) {
				final XVariableDeclaration localVariable = (XVariableDeclaration) featureCall.getFeature();
				if ((!onlyWritable || localVariable.isWriteable()) && !localVariables.containsKey(localVariable)) {
					localVariables.put(localVariable, featureCall);
				}
			}
		}
		return localVariables;
	}

	/** Replies if the generation is for Java version 8 at least.
	 *
	 * @param context the context.
	 * @return {@code true} if Java 8 or newer.
	 */
	protected boolean isAtLeastJava8(EObject context) {
		return this.generatorConfigProvider.get(EcoreUtil.getRootContainer(context)).getJavaSourceVersion().isAtLeast(JavaVersion.JAVA8);
	}

	/** Generate the Java code related to the expression for the break keyword.
	 *
	 * @param breakExpression the expression.
	 * @param appendable the output.
	 */
	@SuppressWarnings("static-method")
	protected void _toJavaExpression(SarlBreakExpression breakExpression, ITreeAppendable appendable) {
		appendable.append("/* error - couldn't compile nested break */"); //$NON-NLS-1$
	}

	/** Generate the Java code related to the expression for the continue keyword.
	 *
	 * @param breakExpression the expression.
	 * @param appendable the output.
	 * @since 0.7
	 */
	@SuppressWarnings("static-method")
	protected void _toJavaExpression(SarlContinueExpression breakExpression, ITreeAppendable appendable) {
		appendable.append("/* error - couldn't compile nested continue */"); //$NON-NLS-1$
	}

	/** Generate the Java code related to the expression for the assert keyword.
	 *
	 * @param assertExpression the expression.
	 * @param appendable the output.
	 */
	protected void _toJavaExpression(SarlAssertExpression assertExpression, ITreeAppendable appendable) {
		if (!assertExpression.isIsStatic() && isAtLeastJava8(assertExpression)) {
			appendable.append("/* error - couldn't compile nested assert */"); //$NON-NLS-1$
		}
	}

	@Override
	protected boolean internalCanCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		// Overridden for enabling the expressions that are specific to SARL
		if (expression instanceof SarlBreakExpression) {
			return true;
		}
		if (expression instanceof SarlContinueExpression) {
			return true;
		}
		if (expression instanceof SarlAssertExpression) {
			return true;
		}
		return super.internalCanCompileToJavaExpression(expression, appendable);
	}

	@Override
	protected boolean isVariableDeclarationRequired(XExpression expression, ITreeAppendable appendable, boolean recursive) {
		// Overridden for enabling the expressions that are specific to SARL
		final EObject container = expression.eContainer();
		if (expression instanceof SarlBreakExpression) {
			return false;
		}
		if (expression instanceof SarlContinueExpression) {
			return false;
		}
		if (container instanceof SarlAssertExpression) {
			return false;
		}
		return super.isVariableDeclarationRequired(expression, appendable, recursive);
	}

	/** Log an internal error but do not fail.
	 *
	 * @param exception the exception to log.
	 */
	protected void logInternalError(Throwable exception) {
		if (exception != null && this.log.isLoggable(Level.FINEST)) {
			this.log.log(Level.FINEST, Messages.SARLJvmModelInferrer_0, exception);
		}
	}

}
