package com.muhittinu.repository.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_personel")
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer age;

    @ManyToOne()
    @Cascade(CascadeType.SAVE_UPDATE)
    Department department;

    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    Car car;
    @ManyToMany()
    List<Address> addresses = new ArrayList<>();
    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department.getName() +
                ", car=" + car +
                ", adres="+ addresses +
                '}';
    }
}
