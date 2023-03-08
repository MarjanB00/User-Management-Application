# User-Management-Application

User-Management-Application je jednostavan sistem za upravljanje korisnicima nekog proizvoljnog informacionog sistema. Sistem je realizovan kroz RESTFul arhitekturu i svi servisi su izloženi u
vidu REST API-ja.

Upustva za kloniranje repozitorijuma: 

1. Otvorite IntelliJ IDEA i izaberite „Checkout from Version Control“ na ekranu dobrodošlice, ili izaberite „File“ > „Nev“ > „Project from Version Control“ iz glavnog menija.
2. U dijalogu „Checkout from Version Control“ izaberite „Git“ sa liste sistema za kontrolu verzija.
3. U polje „URL Git repozitorija“ unesite URL GitHub(https://github.com/MarjanB00/User-Management-Application.git). URL spremišta možete pronaći na veb lokaciji GitHub, ispod dugmeta „Code“.
4. Izaberite direktorijum u koji želite da klonirate spremište. Podrazumevano, IntelliJ IDEA će predložiti direktorijum sa istim imenom kao i spremište.
5. Kliknite na dugme „Kloniraj“ da biste započeli kloniranje spremišta. IntelliJ IDEA će sada preuzeti spremište sa GitHub-a i uvesti ga kao novi projekat. Kada se uvoz završi, trebalo bi da vidite projekat u prozoru alata „Projekat“.
6. Sada možete da koristite IntelliJ IDEA Maven integraciju za izgradnju i pokretanje projekta. Ako je projekat već konfigurisan sa Maven datotekom za izgradnju, IntelliJ IDEA će ga automatski otkriti i uvesti zavisnosti projekta.

APIs:
--------------------------------------------------------------------------
(GET)http://localhost:8080/api/kompanija/svekompanije
Prikaze sve kompanije u bazi podataka

--------------------------------------------------------------------------
(GET)http://localhost:8080/api/user/get/{Heidenreich-Denesik}
Prikazuje sve korisnike iz kompanije {Heidenreich-Denesik}

--------------------------------------------------------------------------
(GET)http://localhost:8080/api/user/get/deactivated
Prikazuje sve deaktivirane korisnike 

--------------------------------------------------------------------------
(GET)http://localhost:8080/api/user/get/userbydate?date={2023-03-06}
Prikaze sve korisnike kreirane datuma {2023.03.06}.

--------------------------------------------------------------------------
(DELETE)http://localhost:8080/api/user/delete/{username1}
Brise korisnika sa korisnickim imenom {username1}. U koliko korisnik da tim korisnickim imenom ne postoji, vrati odgvarajucu gresku.

--------------------------------------------------------------------------
(POST)http://localhost:8080/api/user/register
Body(JSON):
{   
    "username":"testusername7",
    "ime": "Test Authwqeqwe ",
    "prezime": "Test Prezimeeqwe",
    "email": "hashpas@ww.ord",
    "password": "teWdsth4a%shdsad",
    "pol":"m",
    "gradRodjenja": "Kotor",
    "kompanija": "Heidenreich-Denesik"
}

Registracija Korisnika

--------------------------------------------------------------------------
(PUT)http://localhost:8080/api/user/update?username={username1}
Body(JSON):
{   
    "password": "teWdsth4a%shdsad",
    "pol":"m",
    "gradRodjenja": "Kotor",
    "kompanija": "Heidenreich-Denesik"
}

Azuriranje korisnickih informacija. U URL usernam={username1} se navodi kojeg korisnika azuriramo a u Body saljemo koje informacije ažuriramo. Mozemo vise ili jednu u isto vrijeme
