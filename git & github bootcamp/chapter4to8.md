# Bölüm 4 - 7 Arası

### tüm konfigürasyonları listele

```
git config --list
git config user.name <username>
git config user.email <my@email.com>
```

### commit geçmişini göster/ tek satırda göster

```
git log
git log --oneline
```

## commit isimlendirme
takımın kuralı neyse ona uyulur ama çoğunlukla geniş zaman ve geçmiş zaman kullanılarak commit mesajı oluşturulur.

## vscode'u ana git editörü yapma
```
git config --global core.editor "code --wait"
```
Bu ayar sayesinde Sadece `git commit` kullanınca vscodeda yeni bir sayfa açılır ve uzun git mesajlarını oraya rahatlıkla yazabiliriz. Normalde vim editörü kullanılırdı ama onun kullanımı zor.

## son commite unuttuğun bir değişikliği ekleme
istenilen değişiklik stage'e alındıktan sonra
```
git commit --amend
```
daha sonra editörde git mesajını değiştirmemiz için dosya açılacak, aynı bırakıp kapatabiliriz.

## .gitignore
[gitignore.io](https://gitignore.io) başlatacağın proje için örnek bir gitignore dosyası sunar.
[Sonradan gitignore içine eklenen dosyaları silmek](https://medium.com/i%CC%87yi-programlama/sonradan-gitignore-i%CC%87%C3%A7ine-eklenen-dosyalar%C4%B1-gitten-silmek-b038ee37f547)

## HEAD
O anki bulunan konumu tutar. Hangi branchteyse onun en son commitini gösterir

## branchleri listeleme / branch değiştirme
```
git branch
git switch <brancadi>
```
## branch silme / yeniden adlandırma
Eğer bir branch ile merge edilmiş ise;
```
git branch -d <brancadi>
```
Ama tüm değişikliklerle birlikte silmek istersek `-D` kullanmamız gerekir.<br> 
`-D = -d --force`

## Uncommitting last commit
```
git reset --soft HEAD^
```
Eğer son commitin değişikliklerini de silmek istiyorsak `--soft` yerine `--hard` kullanılır.

## Recursive Merge vs Fast Forward Merge
### Fast Forward
Bu merge tipinde bir branch dallandıktan sonra mainde hiç yeni commit olmaz ve merge işlemi yapılır.
### Recursive
Recursivede ise branch dallandıktan sonra main branchinde değişiklikler olmuş
![tree](/assets/lab7-merge.png "git tree after merge")
```
sözde main branch is lab7-main
git checkout -b lab7-branch
git add .
//doing some changes
git commit -m "fix bug"

//go back to main
git checkout lab7-main
git add .
//doing some changes
git commit -m "main branch changed again"

git merge lab7-branch
```
Output:
```
Merge made by the 'recursive' strategy.
 git & github bootcamp/lab-7/file1.txt | 4 +++-
 1 file changed, 3 insertions(+), 1 deletion(-)
```











