package com.bruteforce.secondroundassign_shiva.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdOn;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Gtin> gtins;
}
