package com.dam.model

import jakarta.persistence.*

@Entity
@Table (name = "main_disc")
class MainDisc {
    @Id
    @GeneratedValue(generator = "main_disc_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    lateinit var name: String
    lateinit var manufacturer: String
    var speed: Double? = null
    var glide: Double? = null
    var turn: Double? = null
    var fade: Double? = null
    lateinit var description: String
    var max_weight: Double? = null
    lateinit var diameter: String
    lateinit var height: String
    lateinit var rim_depth: String
    lateinit var inside_rim_diameter: String
    lateinit var rim_thickness: String
    lateinit var rim_depth_diameter_ratio: String
    lateinit var rim_configuration: String
    lateinit var flexibility: String
    lateinit var approved_date: String

}