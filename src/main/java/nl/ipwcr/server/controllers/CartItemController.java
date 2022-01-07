package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.CartItemDAO;
import nl.ipwcr.server.daos.ProductDAO;
import nl.ipwcr.server.models.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {

    @Autowired
    public final CartItemDAO cartItemDAO;

    public final ProductDAO productDAO;

    public CartItemController(CartItemDAO cartItemDAO, ProductDAO productDAO) {
        this.cartItemDAO = cartItemDAO;
        this.productDAO = productDAO;
    }

    @GetMapping(value = "/cartItem/all")
    public List<CartItem> getAllCartItems() {
        return cartItemDAO.getAll();
    }

    @GetMapping(value = "/cartItem/{id}")
    public CartItem getCartItem(@PathVariable final Long id) {
        return cartItemDAO.getById(id);
    }


    @PutMapping(value = "/cartItem/{id}")
    public CartItem editCartItem(@RequestBody CartItem editCartItem, @PathVariable Long id) throws Exception {

        return cartItemDAO.getByIdOptional(id)
                .map(cartItem -> {
                    cartItem.setAmount(editCartItem.getAmount());
                    cartItem.setProduct(editCartItem.getProduct());
                    cartItem.setCart(editCartItem.getCart());
                    return cartItemDAO.addCartItem(cartItem);
                })
                .orElseThrow(() -> new Exception(
                        "No cartItem found with id " + id + "\""));
    }

    @PutMapping(value = "/cartItem")
    public CartItem addCartItem(@RequestBody CartItem newCartItem) {
        return cartItemDAO.addCartItem(newCartItem);
    }

    @DeleteMapping("/cartItem/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemDAO.deleteByCartItemId(id);
    }

}
