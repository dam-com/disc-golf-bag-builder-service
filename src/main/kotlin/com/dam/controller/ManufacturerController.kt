package com.dam.controller

import com.dam.model.Manufacturer
import com.dam.service.ManufacturerService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path

@Path("/manufacturer")
@ApplicationScoped
class ManufacturerController {

    @Inject
    lateinit var manufacturerService: ManufacturerService

    @POST
    @Path("/create")
    fun createManufacturer(manufacturer: Manufacturer): Long? {
        //return manufacturerService.addManufacturer(manufacturer)
    }

    @GET
    @Path("/user/{userId}/bag/{bagId}/disc/{discID}/manufacturer/{manufacturer}")
    fun getDiscManufacturers(userId: Long, bagId: Long, discId: Long, manufacturerId: Long): List<Manufacturer> {
        //return manufacturerService.getDiscManufacturer(discId)
        //todo: implement functionality
    }
}