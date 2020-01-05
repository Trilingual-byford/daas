package com.example.daas.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.stereotype.Component

@Component
@Aspect
@EnableAspectJAutoProxy
class InuRequestTimerAspect {
    @Pointcut("within(com.example.daas.controller..*)")
    fun controllerLayerCaculator() {}
    @Around(value = "com.example.daas.aop.InuRequestTimerAspect.controllerLayerCaculator()")
    fun controllerProcessTimeRecorder(pjp: ProceedingJoinPoint): Any? {
        val beforeJoinPoint = System.currentTimeMillis()
        val serviceName = pjp.signature.name
        val args: Array<Any> = pjp.args
        val proceed = pjp.proceed(args)
        val afterJoinPoint = System.currentTimeMillis()
        val serviceInterval = afterJoinPoint - beforeJoinPoint
        println("$serviceName takes: ($serviceInterval)")
        return proceed
    }

}