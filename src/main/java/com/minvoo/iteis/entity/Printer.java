package com.minvoo.iteis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="printers")
@Accessors(chain = true, fluent = false)
public class Printer {

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
