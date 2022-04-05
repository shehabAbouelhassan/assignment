package io.dewe.assignment.service;


import io.dewe.assignment.model.PurchaseHistory;
import io.dewe.assignment.repository.IPurchaseHistoryRepository;
import io.dewe.assignment.repository.projection.IpurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{

    private final IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }


    @Override
    public List<IpurchaseItem> findPurchasedItemsOfUser(Long userId)
    {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }

}
