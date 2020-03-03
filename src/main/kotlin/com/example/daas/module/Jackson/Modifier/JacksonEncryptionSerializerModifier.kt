package com.example.daas.module.Jackson.Modifier

import com.example.daas.module.Jackson.DataSerializer
import com.fasterxml.jackson.databind.BeanDescription
import com.fasterxml.jackson.databind.SerializationConfig
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier

class JacksonEncryptionSerializerModifier: BeanSerializerModifier() {
    override fun changeProperties(config: SerializationConfig?, beanDesc: BeanDescription?, beanProperties: MutableList<BeanPropertyWriter>?): MutableList<BeanPropertyWriter> {
        val mutableList = mutableListOf<BeanPropertyWriter>()
        beanProperties?.forEach {serializeAnalyze(it,mutableList)}
        return super.changeProperties(config, beanDesc, beanProperties)
    }

    private fun serializeAnalyze(it: BeanPropertyWriter, newPropertyWriter: MutableList<BeanPropertyWriter>) {
        val typeName = it.type.typeName
        if (typeName.contains("Date")) {
            it.assignSerializer(DataSerializer())
            newPropertyWriter.add(it)
        }else{
            newPropertyWriter.add(it)
        }
    }
}