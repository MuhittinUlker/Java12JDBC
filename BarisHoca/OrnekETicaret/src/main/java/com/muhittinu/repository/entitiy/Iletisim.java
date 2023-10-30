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
public class Iletisim {
   String cepTelefonu;
   String isTelefonu;
   String evTelefonu;
   String adres;
   String email;
   String webSitesi;
}
