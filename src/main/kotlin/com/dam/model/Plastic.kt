package com.dam.model

import jakarta.persistence.*

@Entity
@Table(name = "plastic")
class Plastic () {
    @Id
    @GeneratedValue(generator = "plastic_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    @Column(name = "manufacturer_id")
    var maunfacturerId: Long? = null
    var name: String? = null
    var description: String? = null
    var classification: String? = null

    constructor(maunfacturerId: Long?, name: String?, description: String?, classification: String?) : this() {
        this.maunfacturerId = maunfacturerId
        this.name = name
        this.description = description
        this.classification = classification
    }

    override fun toString(): String {
        return "Plastic(id=$id, maunfacturerId=$maunfacturerId, name=$name, description=$description, classification=$classification)"
    }

}