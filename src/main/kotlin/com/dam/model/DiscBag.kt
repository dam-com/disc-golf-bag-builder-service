package com.dam.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "disc_bag")
class DiscBag {
    @Id
    var id: Long? = null
    var bag_id: Long? = null
    var disc_id: Long? = null
    @Column(name = "user_id")
    var user_id: Long? = null
    var favorite: Boolean? = null
}