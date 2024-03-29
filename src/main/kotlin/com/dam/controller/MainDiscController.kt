package com.dam.controller

import com.dam.model.MainDisc
import com.dam.service.MainDiscService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response

@Path("/maindisc")
@ApplicationScoped
class MainDiscController {

    @Inject
    lateinit var mainDiscService: MainDiscService

    @POST
    @Path("/create")
    fun createMainDisc(mainDisc: MainDisc): Response {
        return mainDiscService.createMainDisc(mainDisc)
    }

    @GET
    fun getAllMainDiscs(): List<MainDisc> {
        return mainDiscService.getAllMainDiscs()
    }
}