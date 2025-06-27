package com.bruteforce.secondroundassign_shiva.model;

import jakarta.persistence.*;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "gtin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gtin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gtin_id")
    private Integer gtinId;

    @Column(name = "gtin", nullable = false, unique = true)
    private String gtin;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "gtin", cascade = CascadeType.ALL)
    private List<Batch> batches;
}

