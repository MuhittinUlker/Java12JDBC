package com.muhittinu.repository.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblsatis")
public class Satis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long tarih;
    BigDecimal toplamtutar;
    @Embedded
    BaseEntitiy baseEntitiy;

}
