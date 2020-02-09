package com.example.daas.domin
import org.hibernate.validator.constraints.UniqueElements
import javax.persistence.*

@Entity
data class Inu(
        @Id
        @PrimaryKeyJoinColumn
        @UniqueElements
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?=null,
        var dir: String?=null,
        var width: Int?=null,
        var height: Int?=null,
        var gender: Gender?=null,
        var picSize: Long?=null,
        var likes: Long?=null,
        @ElementCollection
        var attribution:List<String>?=null)

enum class Gender { Male, Female, Unknown }