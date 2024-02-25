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
    @Column(name = "max_weight")
    var maxWeight: Double? = null
    lateinit var diameter: String
    lateinit var height: String
    @Column(name = "rim_depth")
    lateinit var rimDepth: String
    @Column(name = "inside_rim_diameter")
    lateinit var insideRimDiameter: String
    @Column(name = "rim_thickness")
    lateinit var rimThickness: String
    @Column(name = "rim_depth_diameter_ratio")
    lateinit var rimDepthDiameterRatio: String
    @Column(name = "rim_configuration")
    lateinit var rimConfiguration: String
    lateinit var flexibility: String
    @Column(name = "approved_date")
    lateinit var approvedDate: String

}