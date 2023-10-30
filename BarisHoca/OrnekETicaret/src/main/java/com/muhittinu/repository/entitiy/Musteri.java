package com.muhittinu.repository.entitiy;

import com.muhittinu.enums.ECinsiyet;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
 *Hibernate icinde bircok configuration @ anotasyonlarla yapildigi icin bunlar neler oldugu
 * ve ne ise yaradiklarini bilmek cok onemlidir.
 * @Entitiy: Bu sinifin varlik sinifi oldugunu belirtir. ORM araci buradan bir tablo olusturur
 * @Table: uzerine eklendigi sinifin DB'deki ozelliklerini duzenlemek icin kullanilir
 * Her tablo icin bir isim verilmesi onerilir. Eger name verilmezse tablo adi sinifin adi olarak belirlenir.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="tblmusteri")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "musteriAd",length = 30,nullable = false)
    String ad;

    String soyad;

    /*
    Bir kullanicinin birden cok telefon numarasini tutmak icin List turunu kullanabiliriz
    Ancak List gibi Collection turlerini @Entity ile isartetlenmis siniftra tutmak istersek hata aliriz
    Bu turun mutlaka @ElementCollection
     */


    @Temporal(TemporalType.DATE)
    Date dogumTarihi;

    @Temporal(TemporalType.DATE)
    Date iseGirisTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    Date kayitTarihi;

    /*
    VT'de kolon olarak tutulmasini istemediginiz alanlari @Transient ile isaretleriz
     */
    @Transient
    String adSoyad;

    /*
    Enum bilgiler 2 alandan olusur. Enum degeri inttir. Gorunen degeri Stringdir.
    Hangi degerin kaydedilecegi burada belirlenebilir.
     */
    @Enumerated(EnumType.ORDINAL)
    ECinsiyet cinsiyet;

    @Embedded
    BaseEntitiy baseEntitiy;

    @Embedded
    Iletisim iletisim;
}
