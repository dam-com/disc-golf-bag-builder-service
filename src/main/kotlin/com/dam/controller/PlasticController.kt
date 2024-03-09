package com.dam.controller

import com.dam.model.Plastic
import com.dam.service.PlasticService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response

@Path("/plastic")
@ApplicationScoped
class PlasticController {

    @Inject
    lateinit var plasticService: PlasticService

    @POST
    @Path("/create")
    fun createPlastic(plastic: Plastic): Response {
        return plasticService.createPlastic(plastic)
    }

    @GET
    fun getAllPlastics(): List<Plastic> {
        return plasticService.getAllPlastics()
    }

    @GET
    @Path("/user/{userId}/bag/{bagId}/disc/{discID}/plastic/{plasticId}")
    fun getDiscPlastics(userId: Long, bagId: Long, discId: Long, plasticId: Long): List<Plastic> {
        return plasticService.getDiscPlastics(discId)
    }
}