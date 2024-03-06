package com.dam.service

import com.dam.model.Shelf
import com.dam.persistence.ShelfRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class ShelfService {

    @Inject
    lateinit var shelfRepository: ShelfRepository

    fun getAllShelves(): List<Shelf> {
        return shelfRepository.listAll()
    }

    fun addShelf(newShelf: Shelf): Long? {
        shelfRepository.persist(newShelf)
        return newShelf.id
    }

    fun getUserShelves(userId: Long): List<Shelf> {
        return shelfRepository.list("userId", userId)
    }
}