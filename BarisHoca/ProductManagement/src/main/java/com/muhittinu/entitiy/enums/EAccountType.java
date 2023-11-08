package com.muhittinu.entitiy.enums;

import lombok.Getter;

@Getter
public enum EAccountType {
    NORMAL(10.0),
    GOLD(50.0),
    PREMIUM(100.0);
    private final double indirimMiktari;

    EAccountType(Double indirimMiktari){
        this.indirimMiktari=indirimMiktari;
    }
}
