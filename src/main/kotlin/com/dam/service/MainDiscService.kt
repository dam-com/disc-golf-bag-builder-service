package com.dam.service

import com.dam.model.MainDisc
import com.dam.persistence.MainDiscRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response

@ApplicationScoped
@Transactional
class MainDiscService {

    @Inject
    lateinit var mainDiscRepository: MainDiscRepository

    fun createMainDisc(newMainDisc: MainDisc): Response {
        mainDiscRepository.persist(newMainDisc)
        return Response.status(201).entity("Main Disc created with ID: ${newMainDisc.id}").build()
    }

    fun getAllMainDiscs(): List<MainDisc> {
        return mainDiscRepository.listAll()
    }
}