package com.dam.service

import com.dam.model.Plastic
import com.dam.persistence.PlasticRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class PlasticService {
    @Inject
    lateinit var plasticRepository: PlasticRepository

    fun getAllPlastics(): List<Plastic> {
        return plasticRepository.listAll()
    }
}