package com.muhittinu.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int stock;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();
}
