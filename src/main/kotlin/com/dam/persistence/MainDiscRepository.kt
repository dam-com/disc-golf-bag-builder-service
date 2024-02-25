package com.dam.persistence

import com.dam.model.MainDisc
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class MainDiscRepository:PanacheRepository<MainDisc> {

}