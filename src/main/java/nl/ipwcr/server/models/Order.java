package nl.ipwcr.server.models;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_nr")
    private Long id;
    @OneToOne
    @JoinColumn(name = "cart", referencedColumnName = "cart_nr")
    private Cart cart;
    @Column(name = "completed")
    private boolean isCompleted;

    public Order(Long orderNumber, Cart cart, boolean isCompleted) {
        id = orderNumber;
        this.cart = cart;
        this.isCompleted = isCompleted;
    }

    public Order(Cart cart, boolean isCompleted) {
        this.cart = cart;
        this.isCompleted = isCompleted;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
