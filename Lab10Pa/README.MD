# Lab 10 Programare Avansata
#### Programul e un guessing game; e ce am facut anul trecut.
## Client
#### Clientul se conecteaza la server printr-un socket.
#### Primeste date de la server si trimite inapoi raspuns.
## Server
#### In clasa ClientThread se creaza un socket si contine functiile necesare pentru manageriarea playerului conectat cu ajutorul socketului respectiv.
#### In clasa Game avem un joc de tip guessing in care playerul trebuie sa ghiceasca numarul.
#### In clasa GameServer se instantiaza serverul, se deschide sockets pentru playeri si se face handlingul la clienti pentru a nu exista conflicte. Acesta mai are si metoda stop, care inchide socketul.