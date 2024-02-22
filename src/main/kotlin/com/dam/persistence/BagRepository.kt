package com.dam.persistence

import com.dam.model.Bag
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class BagRepository: PanacheRepository<Bag> {

}