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
    var name: String? = null
    var type: String? = null
}