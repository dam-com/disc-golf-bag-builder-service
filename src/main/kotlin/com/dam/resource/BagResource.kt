package com.dam.resource

import com.dam.model.Bag
import com.dam.service.BagService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/bag")
@ApplicationScoped
class BagResource {
    @Inject
    lateinit var bagService: BagService

    @GET
    fun getAllBags(): List<Bag> {
        return bagService.getAllBags()
    }
}