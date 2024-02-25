package com.dam.persistence

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import com.dam.model.User
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository: PanacheRepository<User>{

}