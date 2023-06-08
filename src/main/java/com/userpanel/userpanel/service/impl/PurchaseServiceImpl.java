package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.component.PurchaseTransformer;
import com.userpanel.userpanel.dto.purchase.ShopTypeDTO;
import com.userpanel.userpanel.model.Account;
import com.userpanel.userpanel.model.purchase.Item;
import com.userpanel.userpanel.model.purchase.Purchase;
import com.userpanel.userpanel.model.purchase.ShopType;
import com.userpanel.userpanel.repository.AccountRepository;
import com.userpanel.userpanel.repository.ItemRepository;
import com.userpanel.userpanel.repository.PurchaseRepository;
import com.userpanel.userpanel.request.purchase.PurchaseRequest;
import com.userpanel.userpanel.security.UserDetailsImpl;
import com.userpanel.userpanel.service.PurchaseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final PurchaseTransformer purchaseTransformer;

    @Override
    public List<ShopTypeDTO> getShopNames() {
        return ShopType.getShops();
    }

    @Transactional
    @Override
    public Purchase create(PurchaseRequest request, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Account account = accountRepository.findByUserId(userDetails.getId());
        Purchase purchase = Purchase.builder()
                .withName(request.getName())
                .withShop(request.getShop())
                .withDateTime(request.getDateTime())
                .withItemCount(request.getItems().size())
                .withAccount(account)
                .build();
        Purchase purchaseAfterSave = purchaseRepository.save(purchase);
        return purchaseAfterSave.setItems(createItems(request, purchaseAfterSave));
    }

    private List<Item> createItems(PurchaseRequest request, Purchase purchaseAfterSave) {
        List<Item> items = request.getItems().stream()
                .map(it -> purchaseTransformer.convertItemRequestToItem(it, purchaseAfterSave))
                .toList();
        return itemRepository.saveAll(items);
    }
}
