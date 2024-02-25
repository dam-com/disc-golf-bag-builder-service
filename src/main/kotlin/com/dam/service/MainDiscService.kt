package com.dam.service

import com.dam.model.MainDisc
import com.dam.persistence.MainDiscRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class MainDiscService {
    @Inject
    lateinit var mainDiscRepository: MainDiscRepository

    fun getAllMainDiscs(): List<MainDisc> {
        return mainDiscRepository.listAll()
    }
}