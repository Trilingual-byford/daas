package com.example.daas

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.SpringBootTest
import java.nio.file.Path
import java.nio.file.Paths


@SpringBootTest
class DaasApplicationTests {
	@Autowired
	lateinit var daas:DaasApplication
	@Test
	fun contextLoads() {
		val runApplication = runApplication<DaasApplication>()
		val bean = runApplication.getBean("inu")
	}
	@Test
	fun fileLocation(){

	}


}
