package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import com.userpanel.userpanel.request.purchase.PurchaseRequest;
import com.userpanel.userpanel.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public void create(@RequestBody PurchaseRequest purchaseRequest, Authentication authentication) {
        purchaseService.create(purchaseRequest, authentication);
    }

}
