package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import com.userpanel.userpanel.model.purchase.Purchase;
import com.userpanel.userpanel.request.purchase.PurchaseRequest;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {

    List<ShopTypeDTO> getShopNames();

    void removeItemFromPurchase(UUID purchaseId, UUID itemId);

    Purchase create(PurchaseRequest request, Authentication authentication);
}
