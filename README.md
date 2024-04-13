# fmi-pao
Proiect la disciplina "Programare avansată pe obiecte" – an II ID @ FMI

### Condiții obligatorii de evaluare a proiectelor
- să nu prezinte erori de compilare
- să respecte cerințele precizate mai jos

### Arhitectura aplicației:
- să fie definite cel puțin 6 acțiuni pe care să efectueze aplicația
- să fie utilizate cel puțin 6 clase

### Tema aleasa
Catalog (Student, Disciplină, Profesor, Facultate)

### Implementarea aplicației în Java
1. Clasele vor avea date membre private / protected și metode publice de acces.

2. Cel puțin într-o clasă se vor rescrie metode din clasa Object
- ModelPersoana.toString()

3. Se vor utiliza cel puțin două colecții diferite capabile să gestioneze
   obiectele definite anterior, iar cel puțin una trebuie să fie sortată
- `Disciplina` implementeaza `Comparable` si folosim `TreeSet` in `ServiciuCatalog`

4. Se va utiliza moștenirea pentru crearea de clase specializate
- `ModelBaza` & `ModelPersoana` sunt extinse

5. Cel puțin într-o clasă se va utiliza agregarea sau compoziția
- In clasa `Facultate` se foloseste agregarea pentru a avea o lista de discipline si studenti

6. Se va implementa un serviciu de autentificare

7. Se va implementa cel puțin o clasă serviciu care sa expună acțiunile care
   pot fi efectuate de aplicație
- Clasa `ServiciuCatalog` expune actiuni ce pot fi efectuate de aplicatie

8. Se va implementa o clasă Test care să permită rularea aplicației prin intermediul
   unui meniu de tip text (se poate utiliza și o interfață grafică)
- [`TestAplicatie`](./src/TestAplicatie.java)

9. Se va asigura persistența datelor utilizând o bază de date relațională și JDBC
- StudentDAO pentru CRUD

10. Se vor realiza servicii care sa expună operații de tip CRUD (Create, Read, Update și Delete)
    pentru cel puțin una dintre clasele utilizate
- Clasa `ServiciuCatalog` expune operatii de tip CRUD pentru modele

11. Se va implementa un serviciu care să înregistreze într-un fișier de tip CSV fiecare
    executare a uneia dintre acțiunile aplicației, sub forma denumire_acțiune, data_și_ora
- `ServiciuLogging`
