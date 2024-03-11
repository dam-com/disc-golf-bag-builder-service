package com.dam.model

import jakarta.persistence.*
import kotlin.math.max

@Entity
@Table (name = "main_disc")
class MainDisc (){
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

    constructor(name: String, manufacturer: String?, speed: Double?, glide: Double?, turn: Double?, fade: Double?, description: String?,
                maxWeight: Double?, diameter: String?, height: String?, rimDepth: String?, insideRimDiameter: String?, rimThickness: String?,
                rimDepthDiameterRatio: String?, rimConfiguration: String?, flexibility: String?, approvedDate: String?) : this() {
        this.name = name
        this.manufacturer = manufacturer
        this.speed = speed
        this.glide = glide
        this.turn = turn
        this.fade = fade
        this.description = description
        this.maxWeight = maxWeight
        this.diameter = diameter
        this.height = height
        this.rimDepth = rimDepth
        this.insideRimDiameter = insideRimDiameter
        this.rimThickness = rimThickness
        this.rimDepthDiameterRatio = rimDepthDiameterRatio
        this.rimConfiguration = rimConfiguration
        this.flexibility = flexibility
        this.approvedDate = approvedDate
    }

    override fun toString(): String {
        return "MainDisc(id=$id,name=$name, manufacturer=$manufacturer, speed=$speed, glide=$glide, turn=$turn, fade+$fade," +
                "description=$description, maxWeight=$maxWeight, diameter=$diameter, height=$height, rimDepth=$rimDepth" +
                "insideRimDiameter=$insideRimDiameter, rimThickness=$rimThickness, rimDepthDiameterRatio=$rimDepthDiameterRatio," +
                "rimConfiguation=$rimConfiguration, flexibility=$flexibility, approvedDate=$approvedDate)"
    }

}