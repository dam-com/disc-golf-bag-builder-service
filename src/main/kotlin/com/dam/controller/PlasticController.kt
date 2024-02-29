package com.dam.controller

import com.dam.model.Manufacturer
import com.dam.model.Plastic
import com.dam.persistence.PlasticRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/plastic")
@ApplicationScoped
class PlasticController {

    @Inject
    lateinit var plasticRepository: PlasticRepository

    @POST
    @Path("/create")
    fun createPlastic(plastic: Plastic): Long? {
        //return plasticService.addPlastic(plastic)
    }

    @GET
    @Path("/user/{userId}/bag/{bagId}/disc/{discID}/plastic/{plasticId}")
    fun getDiscPlastics(userId: Long, bagId: Long, discId: Long, plasticId: Long): List<Plastic> {
        //return plasticService.getDiscPlastic(discId)
        //todo: implement functionality
    }
}