package com.bruteforce.secondroundassign_shiva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Integer batchId;

    @Column(name = "mrp", nullable = false)
    private Integer mrp;

    @Column(name = "sp", nullable = false)
    private Integer sp;

    @Column(name = "purchase_price", nullable = false)
    private Integer purchasePrice;

    @Column(name = "available_quantity", nullable = false)
    private Integer availableQuantity;

    @Column(name = "inwarded_on", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date inwardedOn;

    @ManyToOne
    @JoinColumn(name = "gtin_id", nullable = false)
    private Gtin gtin;


}

