package com.dam.controller

import com.dam.model.DiscBag
import com.dam.service.DiscBagService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
@Path("/discbag")
@ApplicationScoped
class DiscBagController {
    @Inject
    lateinit var discBagService: DiscBagService

    @GET
    fun getAllDiscBags(): List<DiscBag> {
        return discBagService.getAllDiscBags()
    }
}