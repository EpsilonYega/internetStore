package org.internetStore.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.internetStore.models.entities.productEntities.Product;

import java.util.List;

@Entity
@Data
@Table(name = "basket", schema = "public", catalog = "internet_store_db")
public class Basket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "userid")
    private User user;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "productid")
    private Product product;
    private String productName = "";
    @Column
    @JsonIgnore
    private double price;

    public Basket() {}

    public Basket(User user, Product product, String productName, double price) {
        this.user = user;
        this.product = product;
        this.productName = productName;
        this.price = price;
    }
}
