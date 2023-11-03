package com.muhittinu;

import com.muhittinu.repository.AddressRepository;
import com.muhittinu.repository.CarRepository;
import com.muhittinu.repository.DepartmentRepository;
import com.muhittinu.repository.PersonelRepository;
import com.muhittinu.repository.entitiy.Address;
import com.muhittinu.repository.entitiy.Car;
import com.muhittinu.repository.entitiy.Department;
import com.muhittinu.repository.entitiy.Personel;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DepartmentRepository departmentRepository = new DepartmentRepository();
        PersonelRepository personelRepositoy = new PersonelRepository();
        CarRepository carRepository = new CarRepository();
        AddressRepository addressRepository = new AddressRepository();

        Department departmentSatis = Department.builder().name("Satis Departmani").build();
        Department departmentMuhasebe = Department.builder().name("Muhasebe Departmani").build();

        Car carAudi = Car.builder().make("AUDI").model("A8").plate("34AUD001").build();
        Car carBmw = Car.builder().make("BMW").model("i8").plate("34BMW555").build();
        Car carMercedes = Car.builder().make("Mercedes").model("A180").plate("34M0123").build();

        Address addressEv = Address.builder().city("Istanbul").street("Galata Cd.").build();
        Address addressIs = Address.builder().city("Londra").street("Baker St.").build();
        Address addressYazlik = Address.builder().city("Antalya").street("Alanya Cd.").build();

        addressRepository.saveAll(List.of(addressEv,addressIs,addressYazlik));

        Personel personel1 = Personel.builder().name("Hakan").department(departmentSatis).addresses(List.of(addressEv,addressIs)).age(35).car(carAudi).build();
        Personel personel2 = Personel.builder().name("Can").department(departmentSatis).age(30).car(carBmw).addresses(List.of(addressEv,addressYazlik)).build();
        Personel personel3 = Personel.builder().name("Bilge").department(departmentMuhasebe).age(40).addresses(List.of(addressIs)).build();

        departmentSatis.setPersonelList(List.of(personel1,personel2));
        departmentMuhasebe.setPersonelList(List.of(personel3));

//        departmentRepository.save(departmentSatis);
//        departmentRepository.save(departmentMuhasebe);
        personelRepositoy.saveAll(List.of(personel1,personel2,personel3));
        //carRepository.save(carMercedes);
//        departmentRepository.deleteById(1L);
        //personelRepositoy.deleteById(1L);
        //departmentRepository.findAll().forEach(System.out::println);
        //personelRepositoy.findAll().forEach(System.out::println);
        //personelRepositoy.findById(2L).ifPresent(System.out::println);
        //carRepository.deleteById(3L);
        //carRepository.findAll().forEach(System.out::println);
        //addressRepository.findAll().forEach(System.out::println);

    }
}