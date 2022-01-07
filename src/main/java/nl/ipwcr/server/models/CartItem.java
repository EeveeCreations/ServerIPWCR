package nl.ipwcr.server.models;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @ManyToOne(targetEntity = Cart.class , fetch = FetchType.EAGER)
    private Cart cart;
    private int amount;

    public CartItem(long id, Product product, Cart cart, int amount) {
        this.id = id;
        this.product = product;
        this.cart = cart;
        this.amount = amount;
    }

    public CartItem(Product product, Cart cart, int amount) {
        this.product = product;
        this.cart = cart;
        this.amount = amount;
    }

    public CartItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productNr) {
        this.product = productNr;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
