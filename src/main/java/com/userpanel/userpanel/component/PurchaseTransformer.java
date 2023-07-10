package com.userpanel.userpanel.component;

import com.userpanel.userpanel.dto.purchase.PurchaseDTO;
import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import com.userpanel.userpanel.model.purchase.Item;
import com.userpanel.userpanel.model.purchase.Purchase;
import com.userpanel.userpanel.projection.purchase.PurchaseProjection;
import com.userpanel.userpanel.request.purchase.ItemRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseTransformer {

    public Item convertItemRequestToItem(ItemRequest itemRequest, Purchase purchase) {
        return Item.builder()
                .withName(itemRequest.getName())
                .withPrice(getPriceForItemAmount(itemRequest.getAmount(), itemRequest.getPrice()))
                .withAmount(itemRequest.getAmount())
                .withPurchase(purchase)
                .build();
    }

    public PurchaseDTO convertPurchaseProjectionToDto(PurchaseProjection purchaseProjection) {
        return new PurchaseDTO(
                purchaseProjection.getId(),
                purchaseProjection.getName(),
                new ShopTypeDTO(purchaseProjection.getShop().getName()),
                purchaseProjection.getItemCount(),
                purchaseProjection.getDateTime(),
                List.of(),
                purchaseProjection.getItemsPrice()
        );
    }

    private double getPriceForItemAmount(int amount, double price) {
        return amount * price;
    }
}
