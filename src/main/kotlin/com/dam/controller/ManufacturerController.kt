package com.dam.controller

import com.dam.model.Manufacturer
import com.dam.service.ManufacturerService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/manufacturer")
@ApplicationScoped
class ManufacturerController {
    @Inject
    lateinit var manufacturerService: ManufacturerService

    @GET
    fun getAllManufacturers(): List<Manufacturer> {
        return manufacturerService.getAllManufacturers()
    }
}