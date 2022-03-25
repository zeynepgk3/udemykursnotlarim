# Bölüm 10
# checkout
## Detached HEAD
HEAD genelde bir brancin en son commitini gösterir demiştik. Eğer zamanda yolculuk yapıp belli bi commitin zamanına dönmek istersek;
    
    git checkout <commitID>
Output:
```
You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.
If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false
```
![detach](/assets/lab10-detach.png "HEAD is separated from main branch")

## HEAD'i geri bağla
    git switch <branchAdi>

### eski bir committen yeni bir branch oluşturabiliyoruz.
![newbranch](/assets/lab10-detached-newbranch.PNG "eski committen dallanan branch")

## commitlerin HEAD'e göre isimlendirmesi
![commitsasheads](/assets/switch_branches_001.png "eski committen dallanan branch")
Örneğin şu şekilde detached HEAD statüsüne girilebilir:
    
    git checkout HEAD~3

Ana konuma gelmek istersek:
    
    git switch -

## Değişiklikleri görmezden gelme
    git checkout HEAD <fileName>
    git checkout -- <fileName>
Bu şekilde o dosyadaki değişiklikler kaldırılır ve HEAD konumuna geri dönülür.

# Restore
checkout = switch + restore
checkout bir sürü iş yaptığı için ikiye ayırmaya karar vermişler

## Unmodifying 
    git restore <file-name>
    //eski yöntemle
    git checkout HEAD  <file-name>

committen daha önceki haline de dönmek mümkün
    
    git restore --source HEAD~1 <file-name> //bir önceki commit yapılmadanki haline döner    
bu işlemi yaptıktan sonra tekrar git restore yaparsak dosyanın en son haline (HEAD) tekrar ulaşırız.

## Unstaging 
    git restore --staged <file-name>

# Reset
Değişiklikleri working directorye geri alır, onları silmez
    
    git reset <commit-hash>

Değişikliklerle beraber commiti silmek istersen;

    git reset --hard <commit-hash> 
hangi commite kadar dönmek istiyorsan o commitin hashi koyulur. Sonra HEAD o commiti gösterir.
 
# Revert
Reset gibi commitleri geri alır ama farklı şekilde çalışır. Reset ile commitleri tamamen silersin ama revert ile yeni bir commit oluşturularak değişiklikler geri alınır.



    