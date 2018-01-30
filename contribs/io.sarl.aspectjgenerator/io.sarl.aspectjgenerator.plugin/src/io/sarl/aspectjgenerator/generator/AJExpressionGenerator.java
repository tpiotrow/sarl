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

import java.text.MessageFormat;
import java.util.logging.Logger;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.compiler.IAppendable;

import io.sarl.aspectjgenerator.AJGeneratorPlugin;
import io.sarl.lang.compiler.extra.AbstractExpressionGenerator;
import io.sarl.lang.compiler.extra.IExtraLanguageGeneratorContext;

/** Generator of expression for AspectJ constraints.
 *
 * @author $Author: tpiotrow$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class AJExpressionGenerator extends AbstractExpressionGenerator {

	/** {@inheritDoc}
	 */
	@Override
	protected String getGeneratorPluginID() {
		return AJGeneratorPlugin.PLUGIN_ID;
	}

	/** Generate the given object.
	 * @param expr the xexpression we don't know how to handle it.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the operation.
	 */
	@SuppressWarnings("static-method")
	protected XExpression _generate(XExpression expr, IAppendable it, IExtraLanguageGeneratorContext context) {
		Logger.getLogger(AJExpressionGenerator.class.getSimpleName()).warning("unknown xExpression : " + expr.toString()); //$NON-NLS-1$
		return expr;
	}

	/** Generate the given object.
	 * @param operation the unary operation.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the operation.
	 */
	protected XExpression _generate(XUnaryOperation operation, IAppendable it, IExtraLanguageGeneratorContext context) {
		final String operator = getOperatorSymbol(operation);
		if (operator != null) {
			it.append(operator);
			generate(operation.getOperand(), it, context);
		}
		return operation;
	}

	/** Generate the given object.
	 *
	 * @param operation the binary operation.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the operation.
	 */
	@SuppressWarnings("checkstyle:cyclomaticcomplexity")
	protected XExpression _generate(XBinaryOperation operation, IAppendable it, IExtraLanguageGeneratorContext context) {
		final String operator = getOperatorSymbol(operation);

		if (operator != null) {
			switch (operator) {
			case "-": //$NON-NLS-1$
			case "+": //$NON-NLS-1$
			case "*": //$NON-NLS-1$
			case "/": //$NON-NLS-1$
			case "%": //$NON-NLS-1$
			case "-=": //$NON-NLS-1$
			case "+=": //$NON-NLS-1$
			case "*=": //$NON-NLS-1$
			case "/=": //$NON-NLS-1$
			case "%=": //$NON-NLS-1$
			case "<": //$NON-NLS-1$
			case ">": //$NON-NLS-1$
			case "<=": //$NON-NLS-1$
			case ">=": //$NON-NLS-1$
			case "==": //$NON-NLS-1$
			case "!=": //$NON-NLS-1$
			case "<<": //$NON-NLS-1$
			case ">>": //$NON-NLS-1$
			case "&&": //$NON-NLS-1$
			case "||": //$NON-NLS-1$
				generate(operation.getLeftOperand(), it, context);
				it.append(" ").append(operator).append(" "); //$NON-NLS-1$ //$NON-NLS-2$
				generate(operation.getRightOperand(), it, context);
				break;
			case "===": //$NON-NLS-1$
				generate(operation.getLeftOperand(), it, context);
				it.append(" == "); //$NON-NLS-1$
				generate(operation.getRightOperand(), it, context);
				break;
			case "!==": //$NON-NLS-1$
				generate(operation.getLeftOperand(), it, context);
				it.append(" != "); //$NON-NLS-1$
				generate(operation.getRightOperand(), it, context);
				break;
			case "..": //$NON-NLS-1$
				it.append("new IntegerRange(");
				generate(operation.getLeftOperand(), it, context);
				it.append(",");
				generate(operation.getRightOperand(), it, context);
				it.append(")");
				break;
			default:
				throw new IllegalArgumentException(MessageFormat.format(Messages.AJExpressionGenerator_0, operator));
			}
		}
		return operation;
	}

	/** Generate the given object.
	 *
	 * @param literal the boolean literal.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the literal.
	 */
	@SuppressWarnings("static-method")
	protected XExpression _generate(XBooleanLiteral literal, IAppendable it, IExtraLanguageGeneratorContext context) {
		it.append(literal.isIsTrue() ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
		return literal;
	}

	/** Generate the given object.
	 *
	 * @param castOperator the cast operator.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the expression.
	 */
	protected XExpression _generate(XCastedExpression castOperator, IAppendable it, IExtraLanguageGeneratorContext context) {
		return generate(castOperator.getTarget(), context.getExpectedExpressionType(), it, context);
	}

	/** Generate the given object.
	 *
	 * @param literal the literal.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the literal.
	 */
	@SuppressWarnings("static-method")
	protected XExpression _generate(XNumberLiteral literal, IAppendable it, IExtraLanguageGeneratorContext context) {
		it.append(literal.getValue());
		return literal;
	}

	/** Generate the given object.
	 *
	 * @param literal the literal.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the literal.
	 */
	@SuppressWarnings("static-method")
	protected XExpression _generate(XStringLiteral literal, IAppendable it, IExtraLanguageGeneratorContext context) {
		it.append("u\"").append(Strings.convertToJavaString(literal.getValue())).append("\""); //$NON-NLS-1$//$NON-NLS-2$
		return literal;
	}

	/** Generate the given object.
	 *
	 * @param operator the instance-of operator.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the expression.
	 */
	protected XExpression _generate(XInstanceOfExpression operator, IAppendable it, IExtraLanguageGeneratorContext context) {
		generate(operator.getExpression(), it, context);
		it.append(" instanceof "); //$NON-NLS-1$
		it.append(operator.getType().getType());
		return operator;
	}

	/** Generate the given object.
	 *
	 * @param literal the null literal.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the literal.
	 */
	@SuppressWarnings("static-method")
	protected XExpression _generate(XNullLiteral literal, IAppendable it, IExtraLanguageGeneratorContext context) {
		it.append("null"); //$NON-NLS-1$
		return literal;
	}

	/** Generate the given object.
	 *
	 * @param throwStatement the throw statement.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the statement.
	 */
	protected XExpression _generate(XThrowExpression throwStatement, IAppendable it, IExtraLanguageGeneratorContext context) {
		it.append("throw "); //$NON-NLS-1$
		generate(throwStatement.getExpression(), it, context);
		return throwStatement;
	}

	/** Generate the given object.
	 *
	 * @param tryStatement the try-catch-finally statement.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the statement.
	 */
	protected XExpression _generate(XTryCatchFinallyExpression tryStatement, IAppendable it, IExtraLanguageGeneratorContext context) {
		it.append("try {"); //$NON-NLS-1$
		it.increaseIndentation().newLine();
		generate(tryStatement.getExpression(), context.getExpectedExpressionType(), it, context);
		it.decreaseIndentation().newLine();
		it.append("}"); //$NON-NLS-1$
		for (final XCatchClause clause : tryStatement.getCatchClauses()) {
			it.append("catch ("); //$NON-NLS-1$
			it.append(clause.getDeclaredParam().getParameterType().getType());
			it.append(", "); //$NON-NLS-1$
			it.append(it.declareUniqueNameVariable(clause.getDeclaredParam(), clause.getDeclaredParam().getSimpleName()));
			it.append(") {"); //$NON-NLS-1$
			it.increaseIndentation().newLine();
			generate(clause.getExpression(), context.getExpectedExpressionType(), it, context);
			it.append("}"); //$NON-NLS-1$
			it.decreaseIndentation().newLine();
		}
		if (tryStatement.getFinallyExpression() != null) {
			it.append("finally {"); //$NON-NLS-1$
			it.increaseIndentation().newLine();
			generate(tryStatement.getFinallyExpression(), it, context);
			it.decreaseIndentation();
			it.append("}"); //$NON-NLS-1$
		}
		return tryStatement;
	}

	/** Generate the given object.
	 *
	 * @param literal the type literal.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the literal.
	 */
	@SuppressWarnings("static-method")
	protected XExpression _generate(XTypeLiteral literal, IAppendable it, IExtraLanguageGeneratorContext context) {
		it.append(literal.getType());
		return literal;
	}

	/** Generate the given object.
	 *
	 * @param featureCall the feature call.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the literal.
	 */
	@SuppressWarnings("static-method")
	protected XExpression _generate(XFeatureCall featureCall, IAppendable it, IExtraLanguageGeneratorContext context) {
		// The feature call in this context filters a variable or a field. Most
		// of the time, the filtered expression will refer to the invariant
		// variable which we want to control the value. That's why we generate
		// and refer to the new value assigned, represented by $$val$$.
		it.append("$$val$$");
		return featureCall;
	}

	/** Generate the given object.
	 *
	 * @param featureCall the feature call.
	 * @param it the target for the generated content.
	 * @param context the context.
	 * @return the literal.
	 */
	protected XExpression _generate(XMemberFeatureCall featureCall, IAppendable it, IExtraLanguageGeneratorContext context) {
		generate(featureCall.getMemberCallTarget(), it, context);
		it.append(featureCall.isExplicitStatic() ? "::" : "."); //$NON-NLS-1$ //$NON-NLS-2$
		it.append(featureCall.getConcreteSyntaxFeatureName());
		it.append("("); //$NON-NLS-1$
		for (int i = 0; i < featureCall.getMemberCallArguments().size(); i++) {
			generate(featureCall.getMemberCallArguments().get(i), it, context);
			if (i != featureCall.getMemberCallArguments().size() - 1) {
				it.append(", "); //$NON-NLS-1$
			}
		}
		it.append(")"); //$NON-NLS-1$
		return featureCall;
	}

}
