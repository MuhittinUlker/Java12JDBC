package com.muhittinu.entitiy;

import com.muhittinu.entitiy.enums.EAdresType;
import com.muhittinu.entitiy.enums.ECinsiyet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Information information;
    @Column(nullable = false,length = 32)
    private String password;
    @Column(nullable = false,unique = true,name = "user_name")
    private String username;
    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ECinsiyet eCinsiyet= ECinsiyet.BELIRTMEK_ISTEMIYORUM;
    @ElementCollection
    private List<String> interests;
    @ElementCollection
    private Map<String,Adres> adresler;

}
