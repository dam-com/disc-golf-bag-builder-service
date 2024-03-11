package com.dam.persistence

import com.dam.model.Disc
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.quarkus.panache.common.Parameters
import jakarta.enterprise.context.ApplicationScoped
import jakarta.json.Json
import jakarta.persistence.criteria.CriteriaBuilder

@ApplicationScoped
class DiscRepository : PanacheRepository<Disc> {

    fun getDisc(discId: Long): Disc? {
        return findById(discId)
    }

    /**
     * Return list of discs belonging in a user's bag
     */
    fun getUserDiscBags(userId: Long, bagId: Long): List<Disc> {
        return list(
            "select d from Disc d left outer join d.bags b where d.userId = b.userId and b.id=?1 and b.userId =?2",
            bagId,
            userId
        )
    }
}