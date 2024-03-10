package com.dam.service

import com.dam.model.Plastic
import com.dam.persistence.PlasticRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response

@ApplicationScoped
@Transactional
class PlasticService {

    @Inject
    lateinit var plasticRepository: PlasticRepository

    fun createPlastic(newPlastic: Plastic): Response {
        plasticRepository.persist(newPlastic)
        return Response.status(201).entity("Plastic created with ID: ${newPlastic.id}").build()
    }

    fun getAllPlastics(): List<Plastic> {
        return plasticRepository.listAll()
    }

    fun getDiscPlastics(discId: Long): List<Plastic> {
        return plasticRepository.list("discId", discId)
    }
}