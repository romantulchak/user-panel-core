package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import com.userpanel.userpanel.model.purchase.ShopType;
import com.userpanel.userpanel.service.PurchaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Override
    public List<ShopTypeDTO> getShopNames() {
        return ShopType.getShops();
    }
}
