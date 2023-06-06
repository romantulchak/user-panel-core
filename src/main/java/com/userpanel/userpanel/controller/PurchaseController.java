package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import com.userpanel.userpanel.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchase")
@CrossOrigin(value = "*", maxAge = 3600L)
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping("/shops")
    public List<ShopTypeDTO> getShops() {
       return purchaseService.getShopNames();
    }

}
