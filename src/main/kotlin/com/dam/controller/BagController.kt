package com.dam.controller

import com.dam.model.Bag
import com.dam.service.BagService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response

@Path("/bag")
@ApplicationScoped
class BagController {

    @Inject
    lateinit var bagService: BagService

    @POST
    @Path("/{bagId}/addDisc/{discId}")
    fun addDiscToBag(bagId: Long, discId: Long): Response {
        return bagService.addDiscToBag(bagId, discId)
    }

    @POST
    @Path("/create")
    fun createBag(bag: Bag): Response {
        return bagService.createBag(bag)
    }

    @GET
    @Path("/user/{userId}")
    fun getUserBags(userId: Long): List<Bag> {
        return bagService.getUserBags(userId)
    }
}