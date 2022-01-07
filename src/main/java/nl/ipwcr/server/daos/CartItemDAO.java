package nl.ipwcr.server.daos;

import nl.ipwcr.server.models.CartItem;
import nl.ipwcr.server.repositorys.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class CartItemDAO {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItemDAO(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAll() {
        ArrayList<CartItem> cartItems = (ArrayList<CartItem>) this.cartItemRepository.findAll();
        cartItems.sort(Comparator.comparingLong(CartItem::getId));
        return cartItems;
    }

    public CartItem getById(long id) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(id);
        if (optionalCartItem.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This CartItem id: " + id + "has not found");
        }
        return optionalCartItem.get();
    }

    public Optional<CartItem> getByIdOptional(long id) {
        return cartItemRepository.findById(id);
    }

    public void deleteByCartItemId(long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public CartItem addCartItem(CartItem newCartItem) {
        return cartItemRepository.save(newCartItem);
    }
}
