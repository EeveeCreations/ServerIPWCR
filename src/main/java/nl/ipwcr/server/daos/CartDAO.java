package nl.ipwcr.server.daos;

import nl.ipwcr.server.models.Cart;
import nl.ipwcr.server.repositorys.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class CartDAO {

    @Autowired
    private CartRepository cartRepository;

    public CartDAO(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAll() {
        ArrayList<Cart> carts = (ArrayList<Cart>) this.cartRepository.findAll();
        carts.sort(Comparator.comparingLong(Cart::getId));
        return carts;
    }

    public Cart getById(long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart with the id: " + id + "has not found");
        }
        return optionalCart.get();
    }

    public Optional<Cart> getByIdOptional(long id) {
        return cartRepository.findById(id);
    }

    public void deleteByCartId(long cartId) {
        cartRepository.deleteById(cartId);
    }

    public Cart addCart(Cart newCart) {
        return cartRepository.save(newCart);
    }
}
