In main rulam programul: se creeaza playerii, board-ul si se incepe jocul cu metoda 'start'. La finalizarea jocului, programul va afisa in consola mesajul 'Game Over!'.
In Token se genereaza tokenii.
In Board este construit board-ul si contine tokenii.
In Player este creat playerul si este implementata interfata Runnable, iar in functia run fiecare player va extrage cate un token, pe rand.
In Game este controlat jocul, separand playerii prin thread-uri si finalizandu-l cand acesta ajunge la final.