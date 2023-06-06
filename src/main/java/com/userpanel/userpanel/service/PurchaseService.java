package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;

import java.util.List;

public interface PurchaseService {

    List<ShopTypeDTO> getShopNames();
}
