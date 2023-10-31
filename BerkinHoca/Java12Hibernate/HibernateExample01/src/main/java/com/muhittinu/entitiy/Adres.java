package com.muhittinu.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Adres {
    private String street;
    private String city;
    private String country;

}
