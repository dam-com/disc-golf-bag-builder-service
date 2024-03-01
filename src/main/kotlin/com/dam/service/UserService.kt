package com.dam.service

import com.dam.model.User
import com.dam.persistence.UserRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class UserService {

    @Inject
    lateinit var userRepository: UserRepository

    fun getAllUsers(): List<User> {
        return userRepository.listAll()
    }

}