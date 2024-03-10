package com.dam.service

import com.dam.model.Disc
import com.dam.persistence.DiscRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response

@ApplicationScoped
@Transactional
class DiscService {

    @Inject
    lateinit var discRepository: DiscRepository

    fun createDisc(newDisc: Disc): Response {
        discRepository.persist(newDisc)
        return Response.status(201).entity("Disc created with ID: ${newDisc.id}").build()
    }

    fun getUserBagDiscs(userId: Long, bagId: Long): List<Disc> {
        return discRepository.getUserDiscBags(userId, bagId)
    }
}