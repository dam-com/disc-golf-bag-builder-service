package com.dam.persistence

import com.dam.model.Bag
import com.dam.persistence.BagRepository
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Alternative
import javax.annotation.Priority


@Priority(1)
@Alternative
@ApplicationScoped
class TestBagRepository : BagRepository() {
    @PostConstruct
    fun init() {
        persist(
            Bag(1,"test bag name", "grip")
        )
    }
}