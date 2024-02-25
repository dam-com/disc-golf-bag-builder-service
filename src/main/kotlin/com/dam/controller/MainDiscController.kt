package com.dam.controller

import com.dam.model.MainDisc
import com.dam.service.MainDiscService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/maindisc")
@ApplicationScoped
class MainDiscController {
    @Inject
    lateinit var mainDiscService: MainDiscService

    @GET
    fun getAllMainDiscs(): List<MainDisc> {
        return mainDiscService.getAllMainDiscs()
    }
}