package com.dam.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "bag")
class Bag {
    @Id
    var id: Long? = null
    @Column(name = "user_id")
    val userId: Long? = null
    lateinit var name: String
    lateinit var type: String
}