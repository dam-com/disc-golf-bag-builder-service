package com.dam.model

import jakarta.persistence.*

@Entity
@Table (name = "main_disc")
class MainDisc {
    @Id
    @GeneratedValue(generator = "main_disc_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    lateinit var name: String
    var manufacturer: String? = null
    var speed: Double? = null
    var glide: Double? = null
    var turn: Double? = null
    var fade: Double? = null
    var description: String? = null
    @Column(name = "max_weight")
    var maxWeight: Double? = null
    var diameter: String? = null
    var height: String? = null
    @Column(name = "rim_depth")
    var rimDepth: String? = null
    @Column(name = "inside_rim_diameter")
    var insideRimDiameter: String? = null
    @Column(name = "rim_thickness")
    var rimThickness: String? = null
    @Column(name = "rim_depth_diameter_ratio")
    var rimDepthDiameterRatio: String? = null
    @Column(name = "rim_configuration")
    var rimConfiguration: String? = null
    var flexibility: String? = null
    @Column(name = "approved_date")
    var approvedDate: String? = null

}