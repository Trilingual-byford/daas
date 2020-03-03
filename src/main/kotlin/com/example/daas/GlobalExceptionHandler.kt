package com.example.daas

import exception.StorageException
import exception.StorageFileNotFoundException
import org.springframework.cglib.proxy.InvocationHandler
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.http.ResponseEntity
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import java.lang.reflect.Method
import java.nio.Buffer

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [StorageException::class])
    fun handleStoreException(se:StorageException):ResponseEntity<*>{
        return ResponseEntity(se.message,HttpStatus.BAD_GATEWAY)
    }


}

