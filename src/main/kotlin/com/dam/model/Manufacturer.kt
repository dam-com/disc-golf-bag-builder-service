package com.dam.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "manufacturer")
class Manufacturer {
    @Id
    var id: Long? = null
    lateinit var name: String
}