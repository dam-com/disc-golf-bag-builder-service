package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "disc_bag")
class DiscBag {
    @Id
    @GeneratedValue(generator = "disc_bag_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    @Column(name = "bag_id")
    var bagId: Long? = null
    @Column(name = "disc_id")
    var discId: Long? = null
    @Column(name = "user_id")
    var userId: Long? = null
    var favorite: Boolean? = null
}