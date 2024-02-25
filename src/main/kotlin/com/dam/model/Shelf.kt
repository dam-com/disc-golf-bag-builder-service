package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "shelf")
class Shelf {
    @Id
    @GeneratedValue(generator = "shelf_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    @Column(name = "user_id")
    val userId: Long? = null
    @Column(name = "disc_id")
    var discId: Long? = null
}