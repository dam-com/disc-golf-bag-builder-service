package com.dam.persistence

import com.dam.model.Bag
import com.dam.model.Disc
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class BagRepository : PanacheRepository<Bag> {

    fun getUserBags(userId: Long): List<Bag> {
        return list("userId", userId)
    }
}