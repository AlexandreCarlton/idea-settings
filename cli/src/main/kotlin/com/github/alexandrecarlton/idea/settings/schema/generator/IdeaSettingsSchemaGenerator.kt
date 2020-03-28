package com.github.alexandrecarlton.idea.settings.schema.generator

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.alexandrecarlton.idea.settings.dialog.IdeaSettings
import com.github.victools.jsonschema.generator.Option
import com.github.victools.jsonschema.generator.OptionPreset
import com.github.victools.jsonschema.generator.SchemaGenerator
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder
import com.github.victools.jsonschema.generator.SchemaVersion
import com.github.victools.jsonschema.module.jackson.JacksonModule

class IdeaSettingsSchemaGenerator {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val mapper = ObjectMapper()
                .registerModule(KotlinModule())

            // Note: This currently does not generate the correct schema because:
            //  - The @JsonProperty annotations by default target the parameters, not the fields or getters
            //    (We can do a mass s/@JsonProperty/@get:JsonProperty/ as a workaround).
            //  - It does not handle inheritance with JsonTypeInfo correctly (can't workaround this)
            //    See http://github.com/victools/jsonschema-generator/pull/58 for progress on this.
            val config = SchemaGeneratorConfigBuilder(mapper, SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(JacksonModule())
                .with(Option.FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT)
                .build()
            val generator = SchemaGenerator(config)
            val jsonSchema = generator.generateSchema(IdeaSettings::class.java)

            println(mapper.writeValueAsString(jsonSchema))

            // See github.com/networknt/json-schema-validator to properly validate this.
            //
            // val toValidateJsonNode = YAMLMapper().readTree(File(".IDEA-settings.yml"))
            // val loadedJsonSchemaJsonNode = ObjectMapper().readTree(schemaFile)
            // val loadedSchema = JsonSchemaFactory.getInstance(VersionFlag.V201909).getSchema(loadedJsonSchemaJsonNode)
            // val errors = loadedSchema.validate(toValidateJsonNode)
            // if (errors.isEmpty()) {
            //     println("No errors found!")
            // }
            // for (error in errors) {
            //     println("Error: $error")
            // }
        }
    }
}
