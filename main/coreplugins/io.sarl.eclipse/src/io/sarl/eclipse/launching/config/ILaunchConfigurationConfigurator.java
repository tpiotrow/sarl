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

package io.sarl.eclipse.launching.config;

import com.google.inject.ImplementedBy;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

import io.sarl.eclipse.runtime.ISREInstall;

/**
 * Configurator for a SARL launch configuration.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
@ImplementedBy(LaunchConfigurationConfigurator.class)
public interface ILaunchConfigurationConfigurator {

	/**
	 * Returns the launch configuration type for SARL applications.
	 *
	 * @return the launch configuration type, never null.
	 */
	String getLaunchConfigurationType();

	/** Create a default launch configuration for SARL applications.
	 *
	 * <p>The launch configuration is attached to the given project.
	 *
	 * @param projectName the name of the project that containt the main class.
	 * @param fullyQualifiedNameOfAgent the fully qualified name of the agent to be launched.
	 * @return the launch configuration.
	 * @throws CoreException if something is going wrong.
	 */
	ILaunchConfiguration newConfiguration(String projectName, String fullyQualifiedNameOfAgent)
			throws CoreException;

	/** Change the runtime configuration of the given launch configuration.
	 *
	 * <p>Only one of {@code useSystemSre} and {@code useProjectSre} could be <code>true</code> at the same time.
	 * If both are <code>true</code>, {@code useSystemSre} will be unchanged and {@code useProjectSre} sets to
	 * <code>false</code>.
	 *
	 * @param configuration the configuration to change.
	 * @param sre the SRE to use; or <code>null</code> for removing the SRE configuration entries.
	 * @param useSystemSre indicates if the system-wide SRE must be used. If null, the default is used.
	 * @param useProjectSre indicates if the SRE in the project's classpath must be used. If null, the default is used.
	 */
	void setRuntimeConfiguration(ILaunchConfigurationWorkingCopy configuration, ISREInstall sre,
			Boolean useSystemSre, Boolean useProjectSre);

	/** Attach the given resources to the launch configuration.
	 *
	 * @param configuration the configuration to change.
	 * @param resources the resources to attach.
	 * @throws CoreException if something is going wrong.
	 */
	void attachResources(ILaunchConfigurationWorkingCopy configuration, IResource... resources)
			throws CoreException;

	/** Detach the given resources to the launch configuration.
	 *
	 * @param configuration the configuration to change.
	 * @param resources the resources to detach.
	 * @throws CoreException if something is going wrong.
	 */
	void detachResources(ILaunchConfigurationWorkingCopy configuration, IResource... resources)
			throws CoreException;

	/** Change the option flags for the SRE launching.
	 *
	 * @param configuration the configuration to change.
	 * @param showLogo indicates if the logo of the SRE could be shown. If null, the default is used.
	 * @param showLogInfo indicates if informations are logged or only errors. If null, the default is used.
	 * @param offline indicates if the SRE is supposed to be run offline. If null, the default is used.
	 */
	void setLaunchingFlags(ILaunchConfigurationWorkingCopy configuration, Boolean showLogo, Boolean showLogInfo,
			Boolean offline);

	/** Change the name of the project associated to the launch configuration.
	 *
	 * @param configuration the configuration to change.
	 * @param projectName the name of the project.
	 */
	void setProjectName(ILaunchConfigurationWorkingCopy configuration, String projectName);

	/** Change the name of the agent to be launched.
	 *
	 * @param configuration the configuration to change.
	 * @param agentFullyQualifiedName the fully qualified name of the agent to launch.
	 */
	void setAgent(ILaunchConfigurationWorkingCopy configuration, String agentFullyQualifiedName);

	/** Change the identifier of the default agent context.
	 *
	 * @param configuration the configuration to change.
	 * @param contextID the type of identifier to use for the default context.
	 */
	void setDefaultContextIdentifier(ILaunchConfigurationWorkingCopy configuration, RootContextIdentifierType contextID);

	/** Change the command-line arguments to give to the launched agents.
	 *
	 * @param configuration the configuration to change.
	 * @param arguments the arguments to give to the launched agent.
	 */
	void setAgentLaunchingArguments(ILaunchConfigurationWorkingCopy configuration, String arguments);

	/** Change the command-line arguments to give to the SRE.
	 *
	 * @param configuration the configuration to change.
	 * @param arguments the arguments to give to the SRE.
	 */
	void setSRELaunchingArguments(ILaunchConfigurationWorkingCopy configuration, String arguments);

	/** Change the command-line arguments to give to the JRE.
	 *
	 * @param configuration the configuration to change.
	 * @param arguments the arguments to give to the JRE.
	 */
	void setJRELaunchingArguments(ILaunchConfigurationWorkingCopy configuration, String arguments);

	/** Set if the agent should be launched in the current Eclipse VM.
	 *
	 * @param configuration the configuration to change.
	 * @param embedded <code>true</code> if the current Eclipse VM must be used for running the agent.
	 */
	void setEmbeddedSRE(ILaunchConfigurationWorkingCopy configuration, boolean embedded);

	/** Set if the assertions are automatically enabled in debug mode.
	 *
	 * <p>When assertions are enabled, the <code>-ea</code> command line option will be given to the virtual machine.
	 *
	 * @param configuration the configuration.
	 * @param enable <code>true</code> if the assertions are enabled.
	 * @since 0.5
	 */
	void setAssertionEnabledInDebugMode(ILaunchConfigurationWorkingCopy configuration, boolean enable);

	/** Set if the assertions are automatically enabled in run mode.
	 *
	 * <p>When assertions are enabled, the <code>-ea</code> command line option will be given to the virtual machine.
	 *
	 * @param configuration the configuration.
	 * @param enable <code>true</code> if the assertions are enabled.
	 * @since 0.5
	 */
	void setAssertionEnabledInRunMode(ILaunchConfigurationWorkingCopy configuration, boolean enable);

}
