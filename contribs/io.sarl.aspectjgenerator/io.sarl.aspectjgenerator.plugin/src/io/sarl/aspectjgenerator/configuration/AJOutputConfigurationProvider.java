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

package io.sarl.aspectjgenerator.configuration;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import com.google.inject.Singleton;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

import io.sarl.aspectjgenerator.AJGeneratorPlugin;
import io.sarl.aspectjgenerator.generator.Messages;
import io.sarl.lang.compiler.extra.ExtraLanguageOutputConfigurations;

/** Provide the output configuration from the SARL code and the extra languages.
 *
 * @author $Author: tpiotrow$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
@Singleton
public class AJOutputConfigurationProvider implements IOutputConfigurationProvider {

	/** Name of the output configuration for AspectJ generator.
	 */
	public static final String OUTPUT_CONFIGURATION_NAME =
			ExtraLanguageOutputConfigurations.createOutputConfigurationName(AJGeneratorPlugin.PLUGIN_ID);

	/** Name of the output folder in which the AspectJ files are generated.
	 */
	public static final String OUTPUT_FOLDER = "src/main/generated-sources/aspectj"; //$NON-NLS-1$

	@Override
	public Set<OutputConfiguration> getOutputConfigurations() {
		final OutputConfiguration sclOutput = new OutputConfiguration(OUTPUT_CONFIGURATION_NAME);
		sclOutput.setDescription(Messages.AJOutputConfigurationProvider_0);
		sclOutput.setOutputDirectory(OUTPUT_FOLDER);
		sclOutput.setOverrideExistingResources(true);
		sclOutput.setCreateOutputDirectory(true);
		sclOutput.setCanClearOutputDirectory(true);
		sclOutput.setCleanUpDerivedResources(true);
		sclOutput.setSetDerivedProperty(true);
		sclOutput.setKeepLocalHistory(false);
		return newHashSet(sclOutput);
	}

}
