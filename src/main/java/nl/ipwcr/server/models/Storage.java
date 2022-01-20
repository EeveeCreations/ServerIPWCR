package nl.ipwcr.server.models;

import javax.persistence.*;

@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @OneToOne(mappedBy = "storage")
//    private Product product;
    private int amount;
    @Column(name = "sold_out")
    private boolean isSoldOut;

    public Storage(long id, Product product, int amount, boolean isSoldOut) {
        this.id = id;
////        this.product = product;
        this.amount = amount;
        this.isSoldOut = isSoldOut;
    }

    public Storage(Product product, int amount, boolean isSoldOut) {
//        this.product = product;
        this.amount = amount;
        this.isSoldOut = isSoldOut;
    }

    public Storage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Product getProduct() {
//        return product;
//    }

    public void setProduct(Product product) {
//        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
}
