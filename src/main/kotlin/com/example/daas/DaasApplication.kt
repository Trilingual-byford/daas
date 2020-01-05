package com.example.daas

import com.example.daas.service.StorageProperties
import com.example.daas.service.StorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties::class)
class DaasApplication
    fun main(args: Array<String>) {
      runApplication<DaasApplication>(*args)
    }

    @Bean
    fun init(storageService: StorageService): CommandLineRunner {
        return CommandLineRunner { lo ->
            println(lo)
            storageService.init()
        }
	}


