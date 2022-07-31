package com.example.eadtest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    private String id;
    private String ProdName;
    private String description;
    private LocalDateTime dateOfManf;
    private double price;
}
