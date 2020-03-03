package com.example.daas.module.Jackson

import com.example.daas.module.Jackson.Modifier.JacksonEncryptionDeserializerModifier
import com.example.daas.module.Jackson.Modifier.JacksonEncryptionSerializerModifier
import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.Module

class JacksonEncryptionModule : Module() {
    val MODULE_NAME = "jackson-confusion-encryption"
    var version: Version = Version(1, 1, 1, MODULE_NAME)

    override fun getModuleName(): String {
        return MODULE_NAME
    }

    override fun version(): Version {
        return version
    }

    override fun setupModule(context: SetupContext?) {
        context!!.addBeanDeserializerModifier(JacksonEncryptionDeserializerModifier())
        context.addBeanSerializerModifier(JacksonEncryptionSerializerModifier())
    }
}