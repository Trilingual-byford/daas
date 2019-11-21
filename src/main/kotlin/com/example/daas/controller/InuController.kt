package com.example.daas.controller

import com.example.daas.domin.Gender
import com.example.daas.domin.Inu
import com.example.daas.repository.InuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class InuController {
    var inuRepository: InuRepository
    @Autowired
    constructor(inuRepository: InuRepository) {
        this.inuRepository = inuRepository
    }
    @ResponseBody
    @RequestMapping(value= arrayOf("/{id}"),method = arrayOf(RequestMethod.GET))
    fun findDogById(@PathVariable("id")id:String, model:Model):Inu{
        return Inu(1000,"haa",66,11,Gender.Female,100,10,"NO")
    }
    @ResponseBody
    @RequestMapping(path= arrayOf("/all"),method = arrayOf(RequestMethod.GET))
    fun findAllDog(model:Model):List<Inu>{
        return inuRepository.findAll()
    }
    @ResponseBody
    @RequestMapping(value= arrayOf("/greetinginu"),method = arrayOf(RequestMethod.POST))
    fun greetingInus(@RequestBody model:Inu):Inu{
//        val likes = model.likes
        inuRepository.save(model)
        return model
    }
}