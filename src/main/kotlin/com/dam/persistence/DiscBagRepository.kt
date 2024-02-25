package com.dam.persistence

import com.dam.model.DiscBag
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiscBagRepository: PanacheRepository<DiscBag> {

}