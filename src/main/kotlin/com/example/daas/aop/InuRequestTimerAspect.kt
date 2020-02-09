package com.example.daas.aop

import com.example.daas.controller.InuController
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.stereotype.Component

@Component
@Aspect
@EnableAspectJAutoProxy
class InuRequestTimerAspect {
    var logger: Logger = LoggerFactory.getLogger(InuRequestTimerAspect::class.java)
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
        logger.info("$serviceName takes: ($serviceInterval) mills")
        return proceed
    }

}