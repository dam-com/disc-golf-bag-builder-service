package com.dam.controller

import com.dam.model.Plastic
import com.dam.persistence.PlasticRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.Path

@Path("/plastic")
@ApplicationScoped
class PlasticController {
    @Inject
    lateinit var plasticRepository: PlasticRepository

    fun getAllPlastics(): List<Plastic> {
        return plasticRepository.listAll()
    }
}