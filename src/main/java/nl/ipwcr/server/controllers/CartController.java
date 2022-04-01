package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.CartDAO;
import nl.ipwcr.server.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200",
        "https://eeveecreations.github.io",
        "https://one-piece-shop-ipwcr-jpwbr.ondigitalocean.app/"})
@RestController
public class CartController {
    @Autowired
    public final CartDAO cartDAO;

    public CartController(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @GetMapping(value = "/cart/all")
    public List<Cart> getAllCategories() {
        return cartDAO.getAll();
    }

    @GetMapping(value = "/cart/{id}")
    public Cart getCart(@PathVariable final Long id) {
        return cartDAO.getById(id);
    }

    @PutMapping(value = "/cart/{id}")
    public Cart editCart(@RequestBody Cart editCart, @PathVariable Long id) throws Exception {

        return cartDAO.getByIdOptional(id)
                .map(cart -> {
                    cart.setAmountOfProducts(editCart.getAmountOfProducts());
                    cart.setTotalPrice(editCart.getTotalPrice());
                    cart.setIsOrdered(editCart.isIsOrdered());
                    cart.setProducts(editCart.getProducts());
                    return cartDAO.addCart(cart);
                })
                .orElseThrow(() -> new Exception(
                        "No cart found with id " + id + "\""));
    }

    @PutMapping(value = "/cart")
    public Cart addCart(@RequestBody Cart newCart) {
        return cartDAO.addCart(newCart);
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartDAO.deleteByCartId(id);
    }

}
