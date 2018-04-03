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

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.compiler.IAppendable;

import io.sarl.lang.compiler.extra.IExtraLanguageGeneratorContext;

/** This class generate feature calls in single field invariants.
 *
 * @author $Author: tpiotrow$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class AJInvariantExpressionGenerator extends AJExpressionGenerator {

	@Override
	protected XExpression _generate(XFeatureCall featureCall, IAppendable it, IExtraLanguageGeneratorContext context) {
		// In cases of single field invariants, the feature call always refer to the new value of the field
		// Hence, we only have to refer to the new value by $$val$$.
		it.append("$$val$$"); //$NON-NLS-1$
		return featureCall;
	}

}
