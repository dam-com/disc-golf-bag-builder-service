package com.dam.service
import com.dam.model.Disc
import com.dam.persistence.DiscRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class DiscService {
    @Inject
    lateinit var discRepository: DiscRepository

    fun getAllDiscInfo(): List<Disc>{
        return discRepository.listAll()
    }
}