package com.dam.controller

import com.dam.model.Disc
import com.dam.service.DiscService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/disc")
@ApplicationScoped
class DiscController {
    @Inject
    lateinit var discService: DiscService

    @GET
    fun getAllDiscInfo(): List<Disc> {
        return discService.getAllDiscInfo()
    }
}