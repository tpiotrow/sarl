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

import javax.inject.Singleton;

import com.google.inject.Injector;

import io.sarl.aspectjgenerator.AJGeneratorPlugin;
import io.sarl.lang.ui.compiler.extra.AbstractExtraLanguageGeneratorProvider;

/** Provider of the aspectj generator if it is enabled.
 *
 * @author $Author: tpiotrow$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
@Singleton
public class AJGeneratorProvider extends AbstractExtraLanguageGeneratorProvider<AJGenerator> {

	/** {@inheritDoc}
	 */
	@Override
	protected AJGenerator createGeneratorInstance(Injector injector) {
		return injector.getInstance(AJGenerator.class);
	}

	/** {@inheritDoc}
	 */
	@Override
	protected String getPluginID() {
		return AJGeneratorPlugin.PLUGIN_ID;
	}

}
