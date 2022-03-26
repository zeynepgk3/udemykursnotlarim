package com.learntesting.unittestyazmasanati.bolum2customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Kural 5: Test edilen parça diğer parçalardan bağımsız olmalı (mock ve stub)
 *
 * Bu dosyada Stub örneği kullanıldı. (Önce mocku inceleyiniz.)
 *
 * Kural 6: Bir test metodunda başka bir test metodu çağrılmamalı
 *
 * Kural 7: Testler tam otomatik şekilde çalışmalı. (Örn: jenkins ile)
 * Kural 8: Çok hızlı şekilde çalışmalı ve sonuç vermeli
 * Kural 9: Okunaklı anlaşılır olmalı
 * Kural 10: Her zaman aynı sonucu çıkarmalı
 * */

public class MusteriServiceTestWithStub {
    private MusteriService musteriService;
    private MusteriRepositoryStub musteriRepository = new MusteriRepositoryStub();
    private BilgilendirmeService bilgilendirmeService;

    @Before
    public void setUp() throws Exception{
        musteriService= new MusteriService();
        this.bilgilendirmeService = Mockito.mock(BilgilendirmeService.class);
        musteriService.setMusteriRepository(this.musteriRepository);
        musteriService.setBilgilendirmeService(this.bilgilendirmeService);

    }

    @After
    // her test metodundan sonra çalıştırılır.
    public void after(){
        musteriRepository.herSeyiSil();
    }
    // bunu yapmak yerine repositoryi setUp metodunda yapılandırabilirdik ama bu durumda her test için sürekli yapılandır
    // ma yapacağımız anlamına gelirdi. performans düşerdi. O yüzden after ile her şeyi silmek daha mantıklı.

    @Test
    public void testMusteriKaydet() throws Exception{
        Musteri musteri=new Musteri(1234);
        musteriService.musteriKaydet(musteri);

        Mockito.verify(bilgilendirmeService).yeniKayitMailiGonder(musteri);
        // bu sefer mock yerine stub kullanarak kontrol ettik.
        assertTrue(musteriRepository.getMusteriListesi().containsValue(musteri));
        // veya böyle daha düzgün yazılabilir:
        assertEquals(musteri,musteriRepository.bul(musteri.getMusteriID()));
    }

    @Test
    public void testMusteriSil() throws Exception{

        // 1234 nolu müşterinin var olup olmadığını bilmeden silmeye çalışmak mantıksız. Yine de testMusteriKaydet testi daha önce
        // çalışırsa bu test hata vermez. Ama bu şekilde iki testi birbirine bağımlı hale getiriyoruz. O yüzden önce 1234 nolu
        // müşterinin varlığı tespit edilmeli

        musteriService.musteriKaydet(new Musteri(1234));

        // testMusteriKaydet();// Yanlış 6.
        assertNotNull(musteriRepository.bul(1234));
        musteriService.musteriSil(1234);
    }


}
