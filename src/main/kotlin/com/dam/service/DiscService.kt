package com.dam.service

import com.dam.model.Bag
import com.dam.model.Disc
import com.dam.persistence.BagRepository
import com.dam.persistence.DiscRepository
import io.quarkus.logging.Log
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class DiscService {

    @Inject
    lateinit var discRepository: DiscRepository

    @Inject
    lateinit var bagRepository: BagRepository

    fun getAllDiscInfo(): List<Disc> {
        return discRepository.listAll()
    }

    fun addDisc(newDisc: Disc): Long? {
        discRepository.persist(newDisc)
        return newDisc.id
    }

    fun getUserBagDiscs(userId: Long, bagId: Long): List<Disc> {
        val userBags = bagRepository.getUserBags(userId).filter { bag: Bag -> bag.id == bagId }

        println("pls")
        Log.debug("User $userId bags: ${userBags.toString()}")

        return if (userBags.isNotEmpty()) userBags.first().discs
        else listOf()
    }
}