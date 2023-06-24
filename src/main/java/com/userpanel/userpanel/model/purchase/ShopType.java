package com.userpanel.userpanel.model.purchase;

import com.fasterxml.jackson.annotation.JsonValue;
import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum ShopType {

    AUCHAN("Auchan"), BIEDRONKA("Biedronka"), LIDL("Lidl"), CARREFOUR("Carrefour"), ZABKA("Żabka");


    private final String name;

    ShopType(String name) {
        this.name = name;
    }

    public static List<ShopTypeDTO> getShops() {
        return Arrays.stream(ShopType.values())
                .map(ShopType::getName)
                .map(ShopTypeDTO::new)
                .toList();
    }

    public String getName() {
        return name;
    }

    @JsonValue
    public String toLowerCase() {
        return StringUtils.capitalize(toString().toLowerCase());
    }
}
