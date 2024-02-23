package com.dam.persistence

import com.dam.model.Disc
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiscRepository: PanacheRepository<Disc> {

}