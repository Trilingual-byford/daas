package com.example.daas.controller

import com.example.daas.domin.Gender
import com.example.daas.domin.Inu
import com.example.daas.repository.InuRepository
import exception.StorageFileNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/")
class InuController {
    var inuRepository: InuRepository
    @Autowired
    constructor(inuRepository: InuRepository) {
        this.inuRepository = inuRepository
    }
    @ResponseBody
    @RequestMapping(value= arrayOf("/{id}"),method = arrayOf(RequestMethod.GET))
    fun findDogById(@PathVariable("id")id:Long, model:Model): ResponseEntity<Optional<Inu>> {
        val inuInstance = inuRepository.findById(id)
        return ResponseEntity(inuInstance,HttpStatus.CONFLICT);
    }
    @ResponseBody
    @RequestMapping(path= arrayOf("/allInu"),method = arrayOf(RequestMethod.GET))
    fun findAllDog(model:Model):List<Inu>{
        return inuRepository.findAll()
    }
    @ResponseBody
    @RequestMapping(value= arrayOf("/greetingInu"),method = arrayOf(RequestMethod.POST))
    fun greetingInus(@RequestBody model:Inu):Inu{
        inuRepository.save(model)
        return model
    }
    @ResponseBody
    @RequestMapping(value= arrayOf("/deleteInu"),method = arrayOf(RequestMethod.POST))
    fun deleteInu(@RequestBody id:Long):String{
        inuRepository.deleteById(id)
        return "Id:$id Inu is gone by now"
    }
}