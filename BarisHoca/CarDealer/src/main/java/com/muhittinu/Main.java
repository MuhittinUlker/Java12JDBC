package com.muhittinu;

import com.muhittinu.entitiy.Car;
import com.muhittinu.repository.CarRepository;
import com.muhittinu.repository.DealershipRespitory;
import com.muhittinu.util.Constant;
import com.muhittinu.util.FileUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        1- DB olusturalim
        2- Entityleri olusturmak
        3- Dosya okuma islemi icin gerekli yapi
        4- Singleton bir connection olusturalim
        5- Verileri database'e yazalim
        6- Interface olusturalim
         */
        CarRepository carRepository = new CarRepository();
        DealershipRespitory dealershipRespitory = new DealershipRespitory();
        carRepository.saveAll(FileUtils.getCarList(FileUtils.readFile(Constant.CAR_FILE)));
        dealershipRespitory.saveAll(FileUtils.getDealershipList(FileUtils.readFile(Constant.DEALER_FILE)));
        dealershipRespitory.hangiTedarikciHangiArabayiSatiyor();
    }
}