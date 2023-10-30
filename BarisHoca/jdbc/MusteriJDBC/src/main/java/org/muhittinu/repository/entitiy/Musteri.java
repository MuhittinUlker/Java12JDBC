package org.muhittinu.repository.entitiy;

public class Musteri extends  BaseEntitiy{
    int id;
    String ad;
    String soyad;
    String telefon;
    String cinsiyet;
    Long dtarih;

    public Musteri() {
    }

    public Musteri(String ad, String soyad, String telefon, String cinsiyet, Long dtarih) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.dtarih = dtarih;
    }
    public Musteri(int id, String ad, String soyad, String telefon, String cinsiyet, Long dtarih) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.dtarih = dtarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Long getDtarih() {
        return dtarih;
    }

    public void setDtarih(Long dtarih) {
        this.dtarih = dtarih;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", telefon='" + telefon + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", dtarih=" + dtarih +
                '}';
    }
}
