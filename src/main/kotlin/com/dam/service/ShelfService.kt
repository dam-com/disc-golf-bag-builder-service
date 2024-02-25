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
}