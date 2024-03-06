package com.dam.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "disc")
class Disc {
    @Id
    @GeneratedValue(generator = "disc_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null

    @Column(name = "user_id")
    var userId: Long? = null
    lateinit var name: String
    var manufacturer: String? = null
    var plastic: String? = null
    var weight: Double? = null
    var speed: Double? = null
    var glide: Double? = null
    var turn: Double? = null
    var fade: Double? = null
    var description: String? = null
    var condition: String? = null
    var color: String? = null
    var favorite: Boolean? = null

    @JsonIgnore
    @ManyToMany(mappedBy = "discs", targetEntity = Bag::class)
    var bags: List<Bag> = listOf()
}