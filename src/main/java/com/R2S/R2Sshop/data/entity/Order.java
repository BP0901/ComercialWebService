package com.R2S.R2Sshop.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_price")
    private float totalPrice;

    @Column(name = "estimated_arrival_time")
    private Date estimatedArrivalTime;

    @Column(name = "is_arrived")
    private boolean isArrived;
}
