package com.dam.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "bag")
class Bag {
    @Id
    @GeneratedValue(generator = "bag_id_seq", strategy = GenerationType.SEQUENCE)
    var id: Long? = null

    @Column(name = "user_id")
    var userId: Long? = null
    var name: String? = null
    var type: String? = null

    @JsonIgnore
    @ManyToMany(targetEntity = Disc::class)
    @JoinTable(
        name = "disc_bag",
        joinColumns = [JoinColumn(name = "bag_id")],
        inverseJoinColumns = [JoinColumn(name = "disc_id")]
    )
    var discs: List<Disc> = listOf()

    override fun toString(): String {
        return "Bag(id=$id, userId=$userId, name=$name, type=$type)"
    }
}