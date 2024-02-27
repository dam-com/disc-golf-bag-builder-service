package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "manufacturer")
class Manufacturer {
    @Id
    @GeneratedValue(generator = "manufacturer_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    var name: String? = null
}