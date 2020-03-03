package com.example.daas.config

import com.example.daas.module.Jackson.JacksonEncryptionModule
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class JacksonConfig {
    @Bean
    fun objectMapper(): ObjectMapper{
        val objectMapper = ObjectMapper()
        objectMapper.registerModule(JacksonEncryptionModule())
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
        objectMapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        return objectMapper
    }
}