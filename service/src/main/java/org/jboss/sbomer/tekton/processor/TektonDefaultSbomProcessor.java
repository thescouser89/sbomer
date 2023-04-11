/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2023 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.sbomer.tekton.processor;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;

import org.jboss.sbomer.core.enums.ProcessorImplementation;
import org.jboss.sbomer.processor.Processor;
import org.jboss.sbomer.processor.SbomProcessor;
import org.jboss.sbomer.tekton.AbstractTektonTaskRunner;

/**
 * Implementation responsible for running the default processor.
 */
@Processor(ProcessorImplementation.DEFAULT)
@ApplicationScoped
public class TektonDefaultSbomProcessor extends AbstractTektonTaskRunner implements SbomProcessor {

    @Override
    public void process(long sbomId) {
        var config = Json.createObjectBuilder().add("processor", "default").build();

        runTektonTask("sbomer-process", String.valueOf(sbomId), config);
    }
}