package com.dam.persistence

import com.dam.model.Disc
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Alternative
import javax.annotation.Priority

@Priority(1)
@Alternative
@ApplicationScoped
class TestDiscRepository : DiscRepository() {

    @PostConstruct
    fun init() {
        persist(
            Disc(1,"discname","manufacturer","plastic", 1.34,2.5,
                3.2,4.0,5.1,"good disc","good","blue",false)
        )
    }
}