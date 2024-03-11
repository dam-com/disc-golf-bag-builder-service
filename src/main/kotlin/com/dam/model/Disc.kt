package com.dam.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "disc")
class Disc () {
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

    constructor(userId: Long?, name: String, manufacturer: String?, plastic: String?, weight: Double?, speed: Double?,
                glide: Double?, turn: Double?, fade: Double?, description: String?, condition: String?, color: String?,
                favorite: Boolean?) : this() {
        this.userId = userId
        this.name = name
        this.manufacturer = manufacturer
        this.plastic = plastic
        this.weight = weight
        this.speed = speed
        this.glide = glide
        this.turn = turn
        this.fade = fade
        this.description = description
        this.condition = condition
        this.color = color
        this.favorite = favorite
    }

    override fun toString(): String {
        return "Disc(id=$id, userId=$userId, name=$name, manufacturer=$manufacturer, plastic=$plastic, weight=$weight," +
                "speed=$speed, glide=$glide, turn=$turn, fade=$fade, description=$description, condition=$condition" +
                "color=$color, favorite=$favorite)"
    }
}