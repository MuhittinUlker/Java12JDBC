package com.muhittinu.repository.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BaseEntitiy {
    /*
    Epoch icin Long tutmak onerilir
     */
    Long olusturmaTarihi;
    Long guncellemeTarihi;
    Integer durum;
}
