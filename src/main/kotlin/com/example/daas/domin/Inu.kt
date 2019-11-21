package com.example.daas.domin
import jdk.jfr.Name
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
@Entity
data class Inu(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        var dir: String,
        val width: Int,
        val height: Int,
        val gender: Gender,
        val picSize: Long,
        var likes: Long,
        val attribution:String)

enum class Gender { Male, Female, Unknown }