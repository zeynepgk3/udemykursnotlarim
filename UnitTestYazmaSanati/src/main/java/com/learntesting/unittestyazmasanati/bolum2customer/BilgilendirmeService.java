package com.learntesting.unittestyazmasanati.bolum2customer;

import com.learntesting.unittestyazmasanati.bolum3junit.MailServerUnavailableException;

public class BilgilendirmeService {

    public void yeniKayitMailiGonder(Musteri musteri){
        System.out.println("Mail Gönderildi");
    }

    public void haftalikMailGonder(){
        throw new MailServerUnavailableException("Mail server hata veriyor");
    }
}
