package com.learntesting.unittestyazmasanati.bolum2customer;

import java.util.HashMap;
import java.util.Map;

public class MusteriRepositoryStub extends MusteriRepository{
    private Map<Integer,Musteri> musteriListesi=new HashMap<Integer,Musteri>();

    @Override
    public void kaydet(Musteri musteri) {
        musteriListesi.put(musteri.getMusteriID(),musteri);
    }

    @Override
    public void sil(Integer musteriID) {
        musteriListesi.remove(musteriID);
    }

    @Override
    public Musteri bul(Integer musteriID) {
        return musteriListesi.get(musteriID);
    }

    public Map<Integer,Musteri> getMusteriListesi(){
        return musteriListesi;
    }
    public void herSeyiSil(){
        musteriListesi.clear();
    }

}
