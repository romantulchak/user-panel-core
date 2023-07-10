package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.purchase.Purchase;
import com.userpanel.userpanel.projection.purchase.PurchaseProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

    @Query(value = "SELECT p.id as id, p.name as name, p.shop as shop, p.dateTime as dateTime, size(p.items) as itemCount, sum(pi.amount * pi.price) as itemsPrice " +
            "FROM Purchase p LEFT OUTER JOIN p.items as pi ON pi.purchase.id = p.id WHERE p.account.user.id = :userId GROUP BY p.id")
    Slice<PurchaseProjection> findAllByAccountUserId(@Param("userId") UUID userId, Pageable pageable);
}
