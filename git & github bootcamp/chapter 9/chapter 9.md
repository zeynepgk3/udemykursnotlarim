# Bölüm 9

## neden stash'e ihtiyacımız var?
Bazen bir branch üzerinde çalışırken başka bir branche geçmen gerekebilir. Bu durumda yaptığın değişiklikleri commitlemeden geçiş yapamazsın çünkü conflict olur. Ama şu an commit yaratmak istemiyorsun çünkü hala yapmak istediklerin var. Bu durumda değişiklikleri stash'e alırız. Değişikliklerimiz branch değişiminden sanki onları commitlemişiz gibi etkilenmez.
    
    git stash
    git stash save //aynı işi yapıyo
    git stash pop //stashten çıkarmak için
## stashi birden fazla yerde kullanma
Stashteki değişiklikleri çıkarmadan birden fazla branche uygulamak mümkün. `pop` komutu sadece değişiklikleri stashten çıkarmaya yarar.

    git stash apply

## tüm stashleri listeleme
    git stash list
## belirli bir stashi çıkartma
eğer bir stash belirtmezsek `pop` ve `apply` komutları ilk stashlenen değişiklikleri geri getirir.

    git stash apply stash@{stashID}
# bir stash silme
    git stash drop stash@{stashID}
# tüm stashleri silme
    git stash clear

