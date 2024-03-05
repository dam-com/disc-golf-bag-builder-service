package com.dam.persistence

import com.dam.model.Disc
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiscRepository : PanacheRepository<Disc> {

    /**
     * Return list of discs belonging in a user's bag
     */
    fun getUserDiscBags(userId: Long, bagId: Long): List<Disc> {
        return find(
            "select d from Disc d left outer join d.bags b where d.userId = b.userId and b.id=?1 and b.userId =?2",
            bagId,
            userId
        ).list()
    }
}