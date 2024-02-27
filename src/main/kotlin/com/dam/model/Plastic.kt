package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "plastic")
class Plastic {
    @Id
    @GeneratedValue(generator = "plastic_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    @Column(name = "manufacturer_id")
    var maunfacturerId: Long? = null
    var name: String? = null
    var description: String? = null
    var classification: String? = null
}