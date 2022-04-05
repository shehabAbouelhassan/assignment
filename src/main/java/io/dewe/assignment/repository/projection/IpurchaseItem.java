package io.dewe.assignment.repository.projection;

import java.time.LocalDateTime;

public interface IpurchaseItem {
    String getItem();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
