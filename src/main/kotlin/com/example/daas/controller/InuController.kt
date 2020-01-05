package com.example.daas.controller

import com.example.daas.domin.Inu
import com.example.daas.repository.InuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/")
class InuController @Autowired constructor(var inuRepository: InuRepository) {
    @ResponseBody
    @RequestMapping(value= arrayOf("/{id}"),method = arrayOf(RequestMethod.GET))
    fun findDogById(@PathVariable("id")id:Long, model:Model): ResponseEntity<Optional<Inu>> {
        val inuInstance = inuRepository.findById(id)
        return ResponseEntity(inuInstance,HttpStatus.OK)
    }
    @ResponseBody
    @RequestMapping(path= arrayOf("/allInu"),method = arrayOf(RequestMethod.GET))
    fun findAllDog(model:Model):ResponseEntity<List<Inu>>{
        return ResponseEntity(inuRepository.findAll(),HttpStatus.OK)

    }
    @ResponseBody
    @RequestMapping(value= arrayOf("/greetingInu"),method = arrayOf(RequestMethod.POST))
    fun greetingInus(@RequestBody model:Inu):ResponseEntity<Inu>{
        inuRepository.save(model)
        return ResponseEntity(model,HttpStatus.OK)
    }
    @ResponseBody
    @RequestMapping(value= arrayOf("/deleteInu"),method = arrayOf(RequestMethod.POST))
    fun deleteInu(@RequestBody id:Long):String{
        inuRepository.deleteById(id)
        return "Id:$id Inu is gone by now"
    }
}