package com.dam.controller

import com.dam.model.MainDisc
import com.dam.service.MainDiscService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/maindisc")
@ApplicationScoped
class MainDiscController {

    @Inject
    lateinit var mainDiscService: MainDiscService

    @POST
    @Path("/create")
    fun createMainDisc(disc: MainDisc): Long? {
        //return mainDiscService.addMainDisc(mainDisc)
    }

    @GET
    @Path("/user/{userID}/bag/{bagId}/maindisc/{mainDiscID}")
    fun getAllMainDiscs(userId: Long, bagId: Long, mainDiscId: Long): List<MainDisc> {
        //return mainDiscService.getAllMainDiscs(mainDiscId)
        //todo: implement functionality
    }
}