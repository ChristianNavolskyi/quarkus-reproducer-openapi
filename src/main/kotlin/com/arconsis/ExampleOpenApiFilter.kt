package com.arconsis

import io.quarkus.smallrye.openapi.OpenApiFilter
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.openapi.OASFilter
import org.eclipse.microprofile.openapi.models.OpenAPI

@OpenApiFilter(OpenApiFilter.RunStage.BOTH)
class ExampleOpenApiFilter(@ConfigProperty(name = "quarkus.application.version") private val version: String) : OASFilter {

    override fun filterOpenAPI(openAPI: OpenAPI?) {
        super.filterOpenAPI(openAPI)

        openAPI?.info?.version = version
    }
}