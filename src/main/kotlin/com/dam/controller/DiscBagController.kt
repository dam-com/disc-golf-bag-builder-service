package com.dam.controller

import com.dam.model.DiscBag
import com.dam.service.DiscBagService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
@Path("/discbag")
@ApplicationScoped
class DiscBagController {

    @Inject
    lateinit var discBagService: DiscBagService

    @GET
    @Path("/user/{userId}/bag/{bagId}")
    fun getUserBagDiscs(userId: Long, bagId: Long): List<Long> {
        //return bagService.getUserBags(userId)
        //todo: implement functionality
    }

    @POST
    @Path("/create")
    fun createDiscBag(discBag: DiscBag): Long? {
//        return bagService.addBag(bag)
    }

}