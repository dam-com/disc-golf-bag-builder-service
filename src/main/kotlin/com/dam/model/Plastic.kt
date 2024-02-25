package com.dam.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "plastic")
class Plastic {
    @Id
    var id: Long? = null
//    maybe needs this idk
//    @Column(name = "maunfacturer_id")
    var maunfacturer_id: Long? = null
    lateinit var name: String
    lateinit var type: String
}