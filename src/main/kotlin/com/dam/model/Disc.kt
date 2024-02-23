package com.dam.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "disc")
class Disc {
    @Id
    var id: Long? = null
    @Column(name = "user_id")
    val userId: Long? = null
    lateinit var name: String
    lateinit var manufacturer: String
    lateinit var plastic: String
    var weight: Long? = null
    var speed: Long? = null
    var glide: Long? = null
    var turn: Long? = null
    var fade: Long? = null
    lateinit var description: String
    lateinit var condition: String
    lateinit var color: String
    var favorite: Boolean? = null
}