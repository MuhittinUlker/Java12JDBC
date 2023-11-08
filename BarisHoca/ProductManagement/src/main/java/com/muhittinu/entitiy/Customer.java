package com.muhittinu.entitiy;

import com.muhittinu.entitiy.enums.EAccountType;
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
@Table(name = "customers")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String identity;
    @Builder.Default
    private EAccountType accountType = EAccountType.NORMAL;
    @Embedded
    private Information information;
    @ManyToMany(mappedBy = "customers")
    private List<Product> products = new ArrayList<>();

}
