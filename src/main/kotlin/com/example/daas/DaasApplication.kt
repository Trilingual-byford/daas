package com.example.daas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DaasApplication

fun main(args: Array<String>) {
	runApplication<DaasApplication>(*args)
}
