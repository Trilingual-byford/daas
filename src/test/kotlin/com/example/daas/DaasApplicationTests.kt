package com.example.daas

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cglib.proxy.Proxy
import kotlin.collections.mutableListOf as mutableListOf1

//internal class InvocationalEx(private val `object`: Any) : InvocationHandler {
//	@Throws(Throwable::class)
//	override fun invoke(o: Any, method: Method, objects: Array<Any>): Any {
//		return null
//	}
//
//}
@SpringBootTest
class DaasApplicationTests {
	@Autowired
	lateinit var daas:DaasApplication
	@Test
	fun contextLoads() {
//		val runApplication = runApplication<DaasApplication>()
//		val bean = runApplication.getBean("inu")
	}
	@Test
	fun fileLocation(){

	}
	@Test
	fun dynamicProxyTest(){
//		val arrayListOf = arrayListOf<String>()
//		val dynamicProxy = DynamicProxy (arrayListOf)
//		val strings = newProxyInstance(arrayListOf.javaClass.getClassLoader(), arrayListOf.javaClass.getInterfaces(), DynamicProxy(ArrayList<Any?>())) as List<String>

//		val newProxyInstance = newProxyInstance(DynamicProxy::class.java.classLoader, arrayOf<Class<*>>(MutableList::class.java), dynamicProxy)
//		newProxyInstance.add("gogo")
//		val o = Proxy.newProxyInstance(arrayListOf.javaClass.classLoader, arrayListOf.javaClass.interfaces, dynamicProxy) as MutableList<*>
//		println(o)

//		val proxyInstance = Proxy.newProxyInstance(
//////				DaasApplicationTests::class.java.getClassLoader(), arrayOf<Class<*>>(MutableMap::class.java),
//////				DynamicInvocationHandler()) as MutableMap<String, String>
//////		proxyInstance.put("yahoo","world")
//////		proxyInstance.put("yahoo2","world")
//////		proxyInstance.put("yahoo3","world")
//////		println(proxyInstance)
//		newProxyInstance
		val dynamicProxyImp = DynamicProxyImp()
		val s = "ggo"
		val arrayListOf = arrayListOf<String>()
		val value = dynamicProxyImp.bind(arrayListOf) as MutableList<String>
		value.add("hahaha")
		println(value)
	}


}
//internal class human: