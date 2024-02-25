package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "plastic")
class Plastic {
    @Id
    @GeneratedValue(generator = "plastic_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    @Column(name = "maunfacturer_id")
    var maunfacturerId: Long? = null
    lateinit var name: String
    lateinit var type: String
}