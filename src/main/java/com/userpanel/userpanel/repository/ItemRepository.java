package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.purchase.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
