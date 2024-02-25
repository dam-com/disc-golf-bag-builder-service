package com.dam.controller

import com.dam.service.UserService
import com.dam.model.User
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/user")
@ApplicationScoped
class UserController {
    @Inject
    lateinit var userService: UserService

    @GET
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }
}