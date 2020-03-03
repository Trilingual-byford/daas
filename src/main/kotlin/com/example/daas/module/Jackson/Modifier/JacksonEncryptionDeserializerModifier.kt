package com.example.daas.module.Jackson.Modifier

import com.fasterxml.jackson.databind.BeanDescription
import com.fasterxml.jackson.databind.DeserializationConfig
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier

class JacksonEncryptionDeserializerModifier: BeanDeserializerModifier() {

    override fun updateBuilder(config: DeserializationConfig?, beanDesc: BeanDescription?, builder: BeanDeserializerBuilder?): BeanDeserializerBuilder {
        return super.updateBuilder(config, beanDesc, builder)
    }
}