package com.muhittinu;

import com.muhittinu.repository.DepartmentRepository;
import com.muhittinu.repository.PersonelRepository;
import com.muhittinu.repository.entitiy.Department;
import com.muhittinu.repository.entitiy.Personel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();

        Department departmentSatis = Department.builder().name("Satis Departmani").build();
        Department departmentMuhasebe = Department.builder().name("Muhasebe Departmani").build();

//        departmentRepository.save(departmentSatis);
//        departmentRepository.save(departmentMuhasebe);

        PersonelRepository personelRepositoy = new PersonelRepository();

        Personel personel1 = Personel.builder().name("Hakan").age(35).department(departmentSatis).build();
        Personel personel2 = Personel.builder().name("Can").age(30).department(departmentSatis).build();
        Personel personel3 = Personel.builder().name("Bilge").age(40).department(departmentMuhasebe).build();

        personelRepositoy.saveAll(List.of(personel1,personel2,personel3));

//        personelRepositoy.findById(2L).ifPresent(
//                personel -> {
//                    System.out.println(personel.getName());
//                    System.out.println(personel.getDepartment().getName());
//                }
//        );

        //personelRepositoy.findAll().forEach(System.out::println);
        //departmentRepository.findAll().forEach(System.out::println);
    }
}