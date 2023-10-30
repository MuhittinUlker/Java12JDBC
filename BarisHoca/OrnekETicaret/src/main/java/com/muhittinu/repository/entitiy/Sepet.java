package com.muhittinu.repository.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="tblsepet")
public class Sepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ElementCollection
    Map<Long,Integer> urunids;

    Long musteriid;

    @Embedded
    BaseEntitiy baseEntitiy;
}
