package com.learntesting.unittestyazmasanati.bolum2customer;

public class MusteriService {

    private MusteriRepository musteriRepository;
    private BilgilendirmeService bilgilendirmeService;

    public void musteriKaydet(Musteri musteri){
        musteriRepository.kaydet(musteri);
        bilgilendirmeService.yeniKayitMailiGonder(musteri);
    }

    public void musteriSil(Integer musteriID){
        musteriRepository.sil(musteriID);
    }

    public void setMusteriRepository(MusteriRepository musteriRepository) {
        this.musteriRepository = musteriRepository;
    }

    public void setBilgilendirmeService(BilgilendirmeService bilgilendirmeService) {
        this.bilgilendirmeService = bilgilendirmeService;
    }
}
