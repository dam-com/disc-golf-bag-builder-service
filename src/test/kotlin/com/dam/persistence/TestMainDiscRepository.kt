package com.dam.persistence
import com.dam.model.MainDisc
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Alternative
import javax.annotation.Priority

@Priority(1)
@Alternative
@ApplicationScoped
class TestMainDiscRepository : MainDiscRepository(){

    @PostConstruct
    fun init() {
        persist(
            MainDisc()
        )
    }
}