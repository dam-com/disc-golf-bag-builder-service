package com.dam.service

import com.dam.model.Shelf
import com.dam.persistence.ShelfRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response

@ApplicationScoped
@Transactional
class ShelfService {

    @Inject
    lateinit var shelfRepository: ShelfRepository

    fun createShelf(newShelf: Shelf): Response {
        shelfRepository.persist(newShelf)
        return Response.status(201).entity("Shelf created with ID: ${newShelf.id}").build()
    }

    fun getAllShelves(): List<Shelf> {
        return shelfRepository.listAll()
    }

    fun getUserShelves(userId: Long): List<Shelf> {
        return shelfRepository.list("userId", userId)
    }
}