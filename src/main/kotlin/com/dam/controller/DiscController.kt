package com.dam.controller

import com.dam.model.Disc
import com.dam.service.DiscService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response

@Path("/disc")
@ApplicationScoped
class DiscController {

    @Inject
    lateinit var discService: DiscService

    @POST
    @Path("/create")
    fun createDisc(disc: Disc): Response {
        return discService.createDisc(disc)
    }

    @GET
    @Path("/user/{userId}/bag/{bagId}")
    fun getUserBagDiscs(userId: Long, bagId: Long): List<Disc> {
        return discService.getUserBagDiscs(userId, bagId)
    }
}