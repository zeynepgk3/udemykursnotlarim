package com.learntesting.unittestyazmasanati.bolum1test;

import com.learntesting.unittestyazmasanati.bolum1.HesapMakinesi;
import org.junit.Assert;
import org.junit.Test;
/**
 * Kural 1: En küçük parçacık test edilmeli
 * Kural 2: Her seferinde bir senaryo test edilmeli
 * Kural 3: Kullanılan adımlar: Given - When - Then şeklinde sıralanmalı
 * Kural 4: Test metot ismi test edilen senaryoyu yansıtabilmeli
 *          test[Özellikİsmi]: testPozitifSayilariToplayincaPozitifCikar
 *          [Özellikİsmi]:pozitifSayilariToplayincaPozitifCikar
 *          Should_[BeklenenDavranış]_When_[Koşul]: Should_PozitifSayiCikartir_When_PozitifSayiVerilirse
 *          When_[Koşul]_Expect_[BeklenenDavranış]: When_PozitifSayiVerilirse_Expect_PozitifSayiCikartir
 *          Given_[ÖnHazırlık]_When_[Koşul]_Then_[BeklenenDavranış]: given_HesapMakinesi_When_PozitifSayiVerilirse_Then_PozitifSayiCikartir
 *          [Metot]_[Senaryo]_[Sonuç]: topla_PozitifSayilar_Pozitif
 *          [Metot]_[Sonuç]_[Senaryo]: topla_Pozitif_PozitifSayilar
 *
 *
 * */
public class HesapMakinesiTest {
    @Test
    public void testTopla(){

        // ön hazırlık: Given
        HesapMakinesi hesapMakinesi=new HesapMakinesi();
        int sayi1=5;
        int sayi2=19;

        // metodu çalıştır: When
        int toplam= hesapMakinesi.topla(sayi1,sayi2);

        int fark=hesapMakinesi.cikart(sayi1,sayi2); // Yanlış 1: çıkartma işlemi testi farklı bi test metodunda olmalıydı

        // sonuç kontrol edilir: Then
        Assert.assertEquals(24,toplam);
        Assert.assertEquals(-14,fark); // 1
    }

    @Test
    public void testCikart() throws Exception{ // Yanlış 2: Bir tane senaryo hata verirse hangisinin olduğunu bulmak zorlaşır
        HesapMakinesi hesapMakinesi = new HesapMakinesi();
        Assert.assertEquals(15,hesapMakinesi.cikart(15,0)); // 2
        Assert.assertEquals(-15,hesapMakinesi.cikart(0,15));
        Assert.assertEquals(20,hesapMakinesi.cikart(50,30));

    }


}
