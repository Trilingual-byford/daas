package com.example.daas

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cglib.proxy.InvocationHandler
import java.lang.reflect.Method

class DynamicInvocationHandler :InvocationHandler{
    private val LOGGER: Logger = LoggerFactory.getLogger(
            DynamicInvocationHandler::class.java)
    override fun invoke(p0: Any?, p1: Method?, p2: Array<out Any>?): Any {
//        LOGGER.info("Invoked method: {}", p1?.getName())
        println("Method:"+p1)
        return invoke(p0,p1,p2)
    }

}