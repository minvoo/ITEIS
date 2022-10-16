package com.minvoo.iteis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mobiles")
@Accessors(chain = true, fluent = false)
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model" )
    private String model;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="employee_id")
    private Employee employee;


}
