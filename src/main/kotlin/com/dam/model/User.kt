package com.dam.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class User {
    @Id
    var id: Long? = null
    lateinit var name: String
}