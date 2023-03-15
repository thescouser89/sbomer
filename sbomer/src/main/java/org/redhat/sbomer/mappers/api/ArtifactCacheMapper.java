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
package org.redhat.sbomer.mappers.api;

import org.redhat.sbomer.model.ArtifactCache;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedSourcePolicy = ReportingPolicy.WARN,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        implementationPackage = "org.redhat.sbomer.mappers",
        componentModel = "cdi")
public interface ArtifactCacheMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purl", source = "purl")
    @Mapping(target = "info", source = "info")
    @BeanMapping(ignoreUnmappedSourceProperties = { "artifactInfo", "id" })
    ArtifactCache toEntity(org.redhat.sbomer.dto.ArtifactCache dtoEntity);

    @Mapping(target = "id", expression = "java( dbEntity.getId().toString() )")
    @Mapping(target = "purl", source = "purl")
    @Mapping(target = "info", source = "info")
    @BeanMapping(ignoreUnmappedSourceProperties = { "persistent", "id" })
    org.redhat.sbomer.dto.ArtifactCache toDTO(ArtifactCache dbEntity);

}