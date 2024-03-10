package com.dam.service

import com.dam.model.Bag
import com.dam.persistence.BagRepository
import com.dam.persistence.DiscRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response

@ApplicationScoped
@Transactional
class BagService {

    @Inject
    lateinit var bagRepository: BagRepository

    @Inject
    lateinit var discRepository: DiscRepository

    fun addDiscToBag(bagId: Long, discId: Long): Response {
        val bag = bagRepository.getBag(bagId)
        val disc = discRepository.getDisc(discId)

        if (bag == null) return Response.status(200).entity("Bag with ID: $bagId not found").build()
        if (disc == null) return Response.status(200).entity("Disc with ID: $discId not found").build()

        val successfulResponse = Response.status(201).entity("Disc $discId added to Bag $bagId").build()

        // If the disc_bag relationship already exists, call it good quit processing early to prevent duplicates
        if (bag.discs.contains(disc)) return successfulResponse

        bag.discs.addLast(disc)
        bagRepository.persist(bag)

        return successfulResponse
    }

    fun createBag(newBag: Bag): Response {
        bagRepository.persist(newBag)
        return Response.status(201).entity("Bag created with ID: ${newBag.id}").build()
    }

    fun getUserBags(userId: Long): List<Bag> {
        return bagRepository.getUserBags(userId)
    }
}