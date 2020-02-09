package com.example.daas.service.inu

import com.example.daas.domin.Inu
import java.util.*

interface InuService {
    fun addInu(inu: Inu):Inu
    fun deleteInu(id: Long)
    fun updateInu(inu: Inu,id: Long):Inu
    fun findInuById(id: Long): Optional<Inu>
    fun findAllInu():List<Inu>
}