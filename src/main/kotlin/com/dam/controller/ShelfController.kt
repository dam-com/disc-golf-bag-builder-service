package com.dam.controller

import com.dam.model.Shelf
import com.dam.service.ShelfService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/shelf")
@ApplicationScoped
class ShelfController {
    @Inject
    lateinit var shelfService: ShelfService

    @GET
    fun getAllShelves(): List<Shelf> {
        return shelfService.getAllShelves()
    }
}