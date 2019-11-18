package com.example.daas

import com.example.daas.service.StorageProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties::class)
class DaasApplication

fun  main(args: Array<String>) {
	runApplication<DaasApplication>(*args)
}

