package com.dam.service

import com.dam.model.Bag
import com.dam.model.Disc
import com.dam.persistence.DiscRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class DiscService {
    @Inject
    lateinit var discRepository: DiscRepository

    fun getAllDiscInfo(): List<Disc>{
        return discRepository.listAll()
    }

    fun addDisc(newDisc: Disc): Long? {
        discRepository.persist(newDisc)
        return newDisc.id
    }
    fun getUserDiscs(userId: Long): List<Disc> {
        return discRepository.list("userId",userId)
    }
}