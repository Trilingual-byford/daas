package com.example.daas.service.inu

import com.example.daas.domin.Inu
import com.example.daas.repository.InuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class InuServiceImpl @Autowired constructor(var inuRepository: InuRepository) : InuService {
    override fun addInu(inu: Inu): Inu {
        return inuRepository.save(inu)
    }

    override fun deleteInu(id: Long) {
        inuRepository.deleteById(id)
    }

    override fun updateInu(inu: Inu, id: Long): Inu {
        return inuRepository.findById(id).map {
            it.attribution = inu.attribution
            it.dir = inu.dir
            it.gender = inu.gender
            it.height = inu.height
            it.likes = inu.likes
            it.picSize = inu.picSize
            it.width = inu.width
            return@map inuRepository.save(it)
        }.orElseGet {
            inu.id = id
            return@orElseGet inuRepository.save(inu)
        }
    }

    override fun findInuById(id: Long): Optional<Inu> {
        return inuRepository.findById(id)
    }
    override fun findAllInu():List<Inu>{
        return inuRepository.findAll()
    }
}