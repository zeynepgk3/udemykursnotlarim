package com.learntesting.unittestyazmasanati.bolum2customer;

public class MusteriRepository {
    public void kaydet(Musteri musteri){
        System.out.println("Oracle DBde müşteri kaydedildi"+musteri.toString());
    }
    public void sil(Integer musteriID){
        System.out.println("Oracle DBde müşteri silindi"+musteriID);
    }

    public Musteri bul(Integer musteriID){
        System.out.println("Oracle DBde müşteri bulundu.");
        return null;
    }


}
