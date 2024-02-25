package com.dam.service

import com.dam.model.DiscBag
import com.dam.persistence.DiscBagRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class DiscBagService {
    @Inject
    lateinit var discBagRepository: DiscBagRepository

    fun getAllDiscBags(): List<DiscBag> {
        return discBagRepository.listAll()
    }
}