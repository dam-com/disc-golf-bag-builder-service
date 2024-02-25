package com.dam.service

import com.dam.model.Manufacturer
import com.dam.persistence.ManufacturerRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class ManufacturerService {
    @Inject
    lateinit var manufacturerRepository: ManufacturerRepository

    fun getAllManufacturers(): List<Manufacturer> {
        return manufacturerRepository.listAll()
    }
}