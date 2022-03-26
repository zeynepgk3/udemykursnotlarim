# Tags
git geçmişine etiketler(tag) sayesinde notlar bırakılabilir. çalışma biçimi olarak branch referanslarına benzer.

lightweight tags: sadece etiket metni var
annotated tags: email, isim, tarih ve etiket metni gibi detaylar var


* Initial release: 1.0.0 : ana ürün, yeni özellikler içerir
* Patch release: 1.0.1 : yeni özellik içermez, hataları düzeltmek içindir.
* Minor release: 1.1.0 : bazı yeni özellikler ve yenilikler içerir ama ana yapıyı çok bozmaz
* Major release 2.0.0: Oyunbozan yeni bir özellik gelmişş :)


## tag listele
    git tag 
    git tag -l "*beta*" // içinde beta kelimesi geçen tüm tagleri listeler

git diff ile tagler arasındaki farklılıkları kontrol edebiliriz aynı commitlerde

## tag ekle, taşı, sil
    git tag <tagname> //HEADin olduğu yere ekler
    git tag -a <tagname> //annotated etiket oluşturmak için `-a` eki kullandık
    git tag <commit> //eski bir commiti etiketleme
    git tag -f <commit> //var olan etiketi başka commite zorla taşıdık
    git tag -d <commit> // etiketi siler

## tagleri pushlama
    git push komutu tagleri de remote repoya yollamaz. Özellikle istiyorsak aşağıdaki komutu kullanmalıyız;

        git push --tags

# Git dosyaları
* config: konfigürasyonlar için
* refs klasörü: HEAD, branchler ve tagleri tutar
* objects klasörü: git'in çekirdeği. yedekler, commitler vs burada saklanır. 4 farklı git objesi var: commit, blob, tree, annotated tag

# Git veritabanı ve Hashleme 
Git bir key-value veritabanıdır. Her türden veriyi tutar, tutarken de kullanıcıya bir anahtar verir, bu anahtar sha-1 ile üretilir.

    git hash-object <file> //o dosya için hash anahtarı oluşturur

    git cat-file -p <objecthash> //saklanılan dosyayı okumak için

(blobs)


