package com.dam.persistence

import com.dam.model.Shelf
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ShelfRepository: PanacheRepository<Shelf> {

}