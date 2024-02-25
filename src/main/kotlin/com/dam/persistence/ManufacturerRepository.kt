package com.dam.persistence

import com.dam.model.Manufacturer
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ManufacturerRepository: PanacheRepository<Manufacturer> {

}