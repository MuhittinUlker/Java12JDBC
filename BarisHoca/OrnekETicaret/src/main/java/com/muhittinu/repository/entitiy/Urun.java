package com.muhittinu.repository.entitiy;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblurun")
@NamedQuery(name = "Urun.findAll",query = "SELECT u FROM Urun u")
@NamedQuery(name = "Urun.findByName",query = "SELECT u FROM Urun u WHERE u.ad LIKE :urunad")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String barkod;
    String marka;
    String model;
    BigDecimal fiyat;
    Integer stok;
    @Embedded
    BaseEntitiy baseEntitiy;

}
