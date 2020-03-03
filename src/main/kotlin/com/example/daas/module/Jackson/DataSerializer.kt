package com.example.daas.module.Jackson

import com.example.daas.utils.DateUtils
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.lang.Exception
import java.util.*

class DataSerializer: JsonSerializer<Any>() {
    override fun serialize(value: Any?, jsonGenerator: JsonGenerator?, serializerProvider: SerializerProvider?) {
        try {
            val date = value as Date
            jsonGenerator?.writeString(DateUtils.DateToString(date))
            return
        }catch (e:Exception){
            e.printStackTrace()
        }
        serializerProvider?.defaultSerializeValue(value,jsonGenerator)
    }
}