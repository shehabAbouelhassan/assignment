package io.dewe.assignment.repository;

import io.dewe.assignment.model.PurchaseHistory;
import io.dewe.assignment.repository.projection.IpurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long>
{
    @Query("select " +
            "b.title as title, ph.price as price, ph.purchaseTime as purchaseTime  " +
            "from PurchaseHistory ph left join Book b on b.id = ph.bookId " +
            "where ph.userId = :userId")
    List<IpurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}