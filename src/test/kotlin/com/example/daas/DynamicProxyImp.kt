package com.example.daas

import org.springframework.cglib.proxy.InvocationHandler
import org.springframework.cglib.proxy.Proxy
import java.lang.reflect.Method

class DynamicProxyImp : InvocationHandler {
    lateinit var delegate: Any
    fun bind(obj: Any): Any {
        delegate = obj
//        return Proxy.newProxyInstance(this.delegateObj.javaClass.classLoader, delegateObj.javaClass.interfaces, this)
        return Proxy.newProxyInstance(
                this.delegate.javaClass.getClassLoader(), this.delegate
                .javaClass.getInterfaces(), this)
    }

    override fun invoke(p0: Any?, p1: Method, p2: Array<out Any>): Any? {
        var result: Any? = null
        try {
            println("问候之前的日志记录...")
            println("p2:$p2")
//            println("*p2:"+)println
            // JVM通过这条语句执行原来的方法(反射机制)
            result = p1.invoke(delegate, *p2)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result!!
    }

//    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any {
//        var result: Any? = null
//        try {
//            println("问候之前的日志记录...")
//            // JVM通过这条语句执行原来的方法(反射机制)
//            result = method.invoke(delegate, *args)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return result!!
//    }

//    @Throws(Throwable::class)
//    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any {
//        var result: Any? = null
//        try {
//            println("问候之前的日志记录...")
//            // JVM通过这条语句执行原来的方法(反射机制)
//            result = method.invoke(delegate, *args)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return result!!
//    }


}

