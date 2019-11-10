package com.example.daas.repository

import com.example.daas.domin.Inu
import org.springframework.data.jpa.repository.JpaRepository

interface InuRepository:JpaRepository<Inu,Long> {
    fun findInuById(id:Int):List<Inu>
}