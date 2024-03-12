package com.dam.persistence

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Alternative
import javax.annotation.Priority

@Priority(1)
@Alternative
@ApplicationScoped
class TestPlasticRepository : PlasticRepository () {
}