package com.learntesting.unittestyazmasanati.bolum2customer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Kural 5: Test edilen parça diğer parçalardan bağımsız olmalı (mock ve stub)
 *
 * STUB: Kullanılan bağımlı parçanın yerine basitleştirilmiş sınıf kullanılması demektir (Örn: Müşteri sınıfından extends eden
 * başka bir sınıf yazılır.). Dezavantajı ekstra kod yazılmasıdır.
 *
 * MOCK: Sahte nesnedir, orijinal nesne gibi davranır.
 *
 * Bu dosyada Mock örneği kullanıldı.
 * */
public class MusteriServiceTestWithMock {

    private MusteriService musteriService;
    private MusteriRepository musteriRepository;
    private BilgilendirmeService bilgilendirmeService;


    @Before // sınıf bazında testten önce yapılması gerekenleri bu metotta yaparız
    public void setUp() throws Exception{
         this.musteriService= new MusteriService();
         this.bilgilendirmeService = Mockito.mock(BilgilendirmeService.class);
         this.musteriRepository=Mockito.mock(MusteriRepository.class);
         musteriService.setMusteriRepository(this.musteriRepository);
         musteriService.setBilgilendirmeService(this.bilgilendirmeService);
    }
    @Test
    public void testMusteriKaydet(){
        Musteri musteri=new Musteri();
        musteriService.musteriKaydet(musteri);

        // musteriKaydet içerisindeki metotların çağrılıp çağrılmadığını test et
        // musteriKaydet metodunda yeniKayitMailGonder çağrılmazsa hata verecek.
        Mockito.verify(bilgilendirmeService).yeniKayitMailiGonder(musteri);
        Mockito.verify(musteriRepository).kaydet(musteri);
        
    }

}