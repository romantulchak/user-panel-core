package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import com.userpanel.userpanel.model.purchase.Purchase;
import com.userpanel.userpanel.request.purchase.PurchaseRequest;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PurchaseService {

    List<ShopTypeDTO> getShopNames();

    Purchase create(PurchaseRequest request, Authentication authentication);
}
