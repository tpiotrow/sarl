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
package io.sarl.core.tests;

import java.util.UUID;

import io.sarl.core.SREBootstrap;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;

/**
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class SREBootstrapMock implements SREBootstrap {

	@Override
	public UUID startAgent(Class<? extends Agent> agentCls, Object... params) throws Exception {
		throw new IllegalStateException();
	}

	@Override
	public Iterable<UUID> startAgent(int nbAgents, Class<? extends Agent> agentCls, Object... params) throws Exception {
		throw new IllegalStateException();
	}

	@Override
	public UUID getBootAgentIdentifier() {
		throw new IllegalStateException();
	}

	@Override
	public AgentContext startWithoutAgent() {
		throw new IllegalStateException();
	}

}
