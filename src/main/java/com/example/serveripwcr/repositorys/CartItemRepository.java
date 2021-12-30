package com.example.serveripwcr.repositorys;

import com.example.serveripwcr.models.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
