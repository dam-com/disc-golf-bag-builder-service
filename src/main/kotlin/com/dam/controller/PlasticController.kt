package com.dam.controller

import com.dam.model.Bag
import com.dam.model.Manufacturer
import com.dam.model.Plastic
import com.dam.persistence.PlasticRepository
import com.dam.service.PlasticService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/plastic")
@ApplicationScoped
class PlasticController {

    @Inject
    lateinit var plasticService: PlasticService

    @POST
    @Path("/create")
    fun createPlastic(plastic: Plastic): Long? {
        return plasticService.addPlastic(plastic)
    }

    @GET
    @Path("/user/{userId}/bag/{bagId}/disc/{discID}/plastic/{plasticId}")
    fun getDiscPlastics(userId: Long, bagId: Long, discId: Long, plasticId: Long): List<Plastic> {
        return plasticService.getDiscPlastics(discId)
    }

    @GET
    fun getAllPlastics(): List<Plastic> {
        return plasticService.getAllPlastics()
    }
}