package com.dam.controller

import com.dam.model.Bag
import com.dam.model.Disc
import com.dam.service.BagService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/bag")
@ApplicationScoped
class BagController {

    @Inject
    lateinit var bagService: BagService

    @POST
    @Path("/create")
    fun createBag(bag: Bag): Long? {
        return bagService.addBag(bag)
    }

    @GET
    @Path("/user/{userId}")
    fun getUserBags(userId: Long): List<Bag> {
        return bagService.getUserBags(userId)
    }
}