package com.dam.controller

import com.dam.model.Disc
import com.dam.service.DiscService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/disc")
@ApplicationScoped
class DiscController {

    @Inject
    lateinit var discService: DiscService

    @POST
    @Path("/create")
    fun createDisc(disc: Disc): Long? {
        return discService.addDisc(disc)
    }

    @GET
    @Path("/user/{userID}/bag/{bagId}/disc/{discID}")
    fun getUserDiscs(userId: Long, bagId: Long, discId: Long): List<Disc> {
        return discService.getUserDiscs(userId)
        //todo: implement functionality
    }
}