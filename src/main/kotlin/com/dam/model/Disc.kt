package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "disc")
class Disc {
    @Id
    @GeneratedValue(generator = "disc_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    @Column(name = "user_id")
    val userId: Long? = null
    lateinit var name: String
    lateinit var manufacturer: String
    lateinit var plastic: String
    var weight: Double? = null
    var speed: Double? = null
    var glide: Double? = null
    var turn: Double? = null
    var fade: Double? = null
    lateinit var description: String
    lateinit var condition: String
    lateinit var color: String
    var favorite: Boolean? = null
}