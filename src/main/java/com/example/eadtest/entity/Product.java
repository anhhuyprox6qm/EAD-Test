package com.example.eadtest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String ProdName;
    private String description;
    @CreatedDate
    private LocalDateTime dateOfManf;
    private double price;
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;
}
