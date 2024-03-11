package com.dam.controller

import com.dam.model.Shelf
import com.dam.service.ShelfService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response

@Path("/shelf")
@ApplicationScoped
class ShelfController {

    @Inject
    lateinit var shelfService: ShelfService

    @POST
    @Path("/create")
    fun createShelf(shelf: Shelf): Response {
        return shelfService.createShelf(shelf)
    }

    @GET
    @Path("/user/{userId}")
    fun getUserShelves(userId: Long): List<Shelf> {
        return shelfService.getUserShelves(userId)
    }
}