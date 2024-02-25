package com.dam.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "shelf")
class Shelf {
    @Id
    var id: Long? = null
    @Column(name = "user_id")
    val userId: Long? = null
    var disc_id: Long? = null
}