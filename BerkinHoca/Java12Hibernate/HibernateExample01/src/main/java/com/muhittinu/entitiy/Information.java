package com.muhittinu.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class Information {
    private String name;
    private String middleName;
    private String surname;
}
