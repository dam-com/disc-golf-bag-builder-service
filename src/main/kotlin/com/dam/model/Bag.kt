package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "bag")
class Bag {
    @Id
    @GeneratedValue(generator = "bag_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    @Column(name = "user_id")
    var userId: Long? = null
    lateinit var name: String
    lateinit var type: String
}