package com.example.daas.domin
import org.hibernate.validator.constraints.UniqueElements
import javax.persistence.*

@Entity
data class Inu(
        @Id
        @PrimaryKeyJoinColumn
        @UniqueElements
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?=null,
        var dir: String?=null,
        val width: Int?=null,
        val height: Int?=null,
        val gender: Gender?=null,
        val picSize: Long?=null,
        var likes: Long?=null,
        @ElementCollection
        val attribution:List<String>?=null)

enum class Gender { Male, Female, Unknown }