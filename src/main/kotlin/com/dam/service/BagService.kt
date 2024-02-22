package com.dam.service

import com.dam.model.Bag
import com.dam.persistence.BagRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class BagService {

    @Inject
    lateinit var bagRepository: BagRepository

    fun getAllBags(): List<Bag> {
        return bagRepository.listAll()
    }
}