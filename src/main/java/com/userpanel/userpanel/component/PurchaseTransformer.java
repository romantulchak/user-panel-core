package com.userpanel.userpanel.component;

import com.userpanel.userpanel.model.purchase.Item;
import com.userpanel.userpanel.model.purchase.Purchase;
import com.userpanel.userpanel.request.purchase.ItemRequest;
import org.springframework.stereotype.Component;

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

    private double getPriceForItemAmount(int amount, double price) {
        return amount * price;
    }
}
