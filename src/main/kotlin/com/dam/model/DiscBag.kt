package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "disc_bag")
class DiscBag {
    @Id
    @GeneratedValue(generator = "disc_bag_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    var bag_id: Long? = null
    var disc_id: Long? = null
    @Column(name = "user_id")
    var user_id: Long? = null
    var favorite: Boolean? = null
}