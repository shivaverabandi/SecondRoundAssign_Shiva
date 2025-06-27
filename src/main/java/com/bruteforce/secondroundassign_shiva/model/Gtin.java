package com.bruteforce.secondroundassign_shiva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "gtin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gtin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gtin_id")
    private Long gtinId;

    @Column(name = "gtin_name", nullable = false, unique = true)
    private String gtinName;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "gtin", cascade = CascadeType.ALL)
    private List<Batch> batches;
}

