package io.dewe.assignment.service;

import io.dewe.assignment.model.PurchaseHistory;
import io.dewe.assignment.repository.projection.IpurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);


    List<IpurchaseItem> findPurchasedItemsOfUser(Long id);
}
