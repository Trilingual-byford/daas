package com.example.daas.controller

import com.example.daas.domin.Inu
import com.example.daas.repository.InuRepository
import com.example.daas.service.inu.InuServiceImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/inu")
class InuController @Autowired constructor(val inuServiceImpl: InuServiceImpl) {
    var logger: Logger = LoggerFactory.getLogger(InuController::class.java)

    @ResponseBody
    @GetMapping(value = ["/{id}"])
    fun findDogById(@PathVariable("id") id: Long, model: Model): ResponseEntity<Optional<Inu>> {
        val inuInstance = inuServiceImpl.findInuById(id)
        logger.info("Find dog By id", inuInstance)
        return ResponseEntity(inuInstance, HttpStatus.OK)
    }

    @ResponseBody
    @GetMapping(path = ["/all"])
    fun findAllDog(model: Model): ResponseEntity<List<Inu>> {
        return ResponseEntity(inuServiceImpl.findAllInu(), HttpStatus.OK)

    }

    @ResponseBody
    @PostMapping(value = ["/add"])
    fun addInu(@RequestBody model: Inu): ResponseEntity<Inu> {
        val addInu = inuServiceImpl.addInu(model)
        logger.info("Add Inu {}", addInu)
        return ResponseEntity(addInu, HttpStatus.OK)
    }

    @ResponseBody
    @DeleteMapping(value = ["/{id}"])
    fun deleteInu(@PathVariable id: Long): String {
        inuServiceImpl.deleteInu(id)
        return "Id:$id Inu is gone by now"
    }

    @ResponseBody
    @PutMapping(value = ["/{id}"])
    fun updateInu(@PathVariable id: Long, @RequestBody model: Inu): Inu {
        val updatedInu = inuServiceImpl.updateInu(model, id)
        return updatedInu
    }

}