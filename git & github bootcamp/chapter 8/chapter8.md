# Bölüm 8

## değişiklikleri görme
    git diff

## diff'in çeşitli kullanımları
### only unstaged changes
    git diff
### staged and unstaged changes on HEAD
    git diff HEAD
### only staged changes
    git diff --staged
    git diff --cached
### diffing spesific files
    git diff HEAD [filename]
    git diff --staged [filename]
### comparing changes across branches
    git diff branch1..branch2
### comparing changes across commits
    git diff commit1..commit2