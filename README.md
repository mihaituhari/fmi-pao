# fmi-pao
Proiect la disciplina "Programare avansată pe obiecte" – an II ID @ FMI

## Continut
1. [Condiții obligatorii de evaluare a proiectelor](#condiții-obligatorii-de-evaluare-a-proiectelor)
2. [Arhitectura aplicației](#arhitectura-aplicației)
3. [Tema aleasa](#tema-aleasa)
4. [Implementarea aplicației în Java](#implementarea-aplicației-în-java)
5. [Video demo](#video-demo)
6. [Notite & comenzi](#notite--comenzi)

----

### Condiții obligatorii de evaluare a proiectelor
- să nu prezinte erori de compilare
- să respecte cerințele precizate mai jos

### Arhitectura aplicației:
- să fie definite cel puțin 6 acțiuni pe care să efectueze aplicația
- să fie utilizate cel puțin 6 clase

### Tema aleasa
Catalog (Student, Disciplină, Profesor, Facultate)

### Implementarea aplicației în Java
<details open>
  <summary>1. Clasele vor avea date membre private / protected și metode publice de acces</summary>

✅ Implementat in toate clasele. Exemplu [`ModelPersoana`](./src/Modele/ModelPersoana.java)
</details>

<details open>
  <summary>2. Cel puțin într-o clasă se vor rescrie metode din clasa `Object`</summary>

✅ Metoda `toString` din [`ModelPersoana`](./src/Modele/ModelPersoana.java)
</details>

<details open>
  <summary>3. Se vor utiliza cel puțin două colecții diferite capabile să gestioneze
   obiectele definite anterior, iar cel puțin una trebuie să fie sortată</summary>

✅ Implementat:
- `List<>` folosit in mai multe clase
- `TreeSet` folosit in [`ServiciuCatalog`](./src/Servicii/ServiciuCatalog.java) pentru [`Disciplina`](./src/Modele/Disciplina.java) ce implementeaza `Comparable` 
</details>


<details open>
    <summary>4. Se va utiliza moștenirea pentru crearea de clase specializate</summary>

✅ Implementat:
- [`ModelBaza`](./src/Modele/ModelBaza.java) este parintele tuturor claselor (management id)
- [`ModelPersoana`](./src/Modele/ModelPersoana.java) extins the [`Student`](./src/Modele/Student.java) si [`Profesor`](./src/Modele/Profesor.java) (management nume, prenume)
</details>

<details open>
    <summary>5. Cel puțin într-o clasă se va utiliza agregarea sau compoziția</summary>

✅ In clasa [`Facultate`](./src/Modele/Facultate.java) se foloseste agregarea pentru a avea o lista de discipline si studenti
</details>

<details open>
    <summary>6. Se va implementa un serviciu de autentificare</summary>

✅ Implementat [`ServiciuAutentificare`](./src/Servicii/ServiciuAutentificare.java) pentru login.
Verifica email & parola din baza de date.

![Autentificare](docs/autentificare.png)
</details>

<details open>
    <summary>7. Se va implementa cel puțin o clasă serviciu care sa expună acțiunile care
   pot fi efectuate de aplicație</summary>

✅ Clasa [`ServiciuCatalog`](./src/Servicii/ServiciuCatalog.java) expune actiuni ce pot fi efectuate de aplicație
</details>

<details open>
    <summary>8. Se va implementa o clasă Test care să permită rularea aplicației prin intermediul
   unui meniu de tip text (se poate utiliza și o interfață grafică)</summary>

✅ Implementat prin intermediul [`TestAplicatie`](./src/TestAplicatie.java).
![Meniu aplicatie](./docs/meniu-aplicatie.png)

</details>

<details open>
    <summary>9. Se va asigura persistența datelor utilizând o bază de date relațională și JDBC</summary>

✅ Implementat persistenta pentru Studenti in MySQL, via [`StudentDAO`](./src/DAO/StudentDAO.java)

![Baza de date MySQL](docs/db-preview.png)
</details>

<details open>
    <summary>10. Se vor realiza servicii care sa expună operații de tip CRUD (Create, Read, Update și Delete)
    pentru cel puțin una dintre clasele utilizate</summary>

✅ Clasa [`ServiciuCatalog`](./src/Servicii/ServiciuCatalog.java) expune operatii de tip CRUD pentru modele
</details>

<details open>
    <summary>11. Se va implementa un serviciu care să înregistreze într-un fișier de tip CSV fiecare
    executare a uneia dintre acțiunile aplicației, sub forma denumire_acțiune, data_și_ora</summary>

✅ Clasa [`ServiciuLogging`](./src/Servicii/ServiciuLogging.java) inregistreaza in fisierul `log.csv` fiecare actiune efectuata in aplicatie

![Fisier CSV](docs/loguri.png)
</details>

### Video demo
https://github.com/mihaituhari/fmi-pao/assets/12177811/21d022bb-8536-45d3-aba4-3a368526efec

### Notite & comenzi
```
javac TestAplicatie.java
java -cp .:/Volumes/mihai/dev/fmi/pao/drivers/mysql-connector-j-8.3.0.jar TestAplicatie
```
