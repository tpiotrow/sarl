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

package io.sarl.aspectjgenerator.ui;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.graphics.Image;

import io.sarl.aspectjgenerator.AJGeneratorPlugin;
import io.sarl.lang.ui.compiler.extra.properties.AbstractGeneratorConfigurationBlock;

/** Configuration block for the AspectJ generator.
 *
 * @author $Author: tpiotrow$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class GeneratorConfigurationBlock extends AbstractGeneratorConfigurationBlock {

	private static final String PYTHON_ICON = "icons/python.png"; //$NON-NLS-1$

	/** Constructor.
	 */
	public GeneratorConfigurationBlock() {
		super(true);
	}

	@Override
	public IDialogSettings getDialogSettings() {
		return AJGeneratorPlugin.getDefault().getDialogSettings();
	}

	@Override
	public String getPluginID() {
		return AJGeneratorPlugin.PLUGIN_ID;
	}

	@Override
	protected String getActivationText() {
		return Messages.GeneratorConfigurationBlock_5;
	}

	@Override
	public Image getTargetLanguageImage() {
		return AJGeneratorPlugin.getDefault().getImage(PYTHON_ICON);
	}

}
