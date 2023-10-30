package com.muhittinu.util;

import com.muhittinu.entitiy.Car;
import com.muhittinu.entitiy.Dealership;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    /*
        readFile(String path) diye bir metod
        bu metod dosya okuma islemi yapacak
        okudugu verileri liste seklinde geri donecek

        getCarList(String readedFile) metodu yazalim
        okudugumuz dosyadan car nesneleri iceren bir liste donecek
     */

    public static List<String> readFile(String path){
        List<String> readedFile= new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String okunanSatir ;
            while((okunanSatir=reader.readLine())!=null) {
                    readedFile.add(okunanSatir);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return readedFile;
    }
    public static List<Car> getCarList(List<String> readedFile){
        List<Car> carList=new ArrayList<>();
        readedFile.forEach(l->{
            Car car=new Car();
            String[] split = l.split(",");
            car.setId(Integer.parseInt(split[0]));
            car.setBrand(split[1]);
            car.setCarModel(split[2]);
            car.setModelYear(split[3]);
            car.setDealershipId(Integer.parseInt(split[4]));
            carList.add(car);
        });
        return carList;
    }
    public static List<Dealership> getDealershipList(List<String> readedFile){
        List<Dealership> dealerList=new ArrayList<>();
        readedFile.forEach(l->{
            Dealership dealership = new Dealership();
            String[] split = l.split(",");
            dealership.setId(Integer.parseInt(split[0]));
            dealership.setName(split[1]);
            dealership.setCountry(split[2]);
            dealership.setCity(split[3]);
            dealerList.add(dealership);
        });
        return dealerList;
    }
}
