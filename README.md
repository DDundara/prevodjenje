## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
Projekt prevodnje je backend dio koji konimazumira api-e koji se izlozi za konzumiraje. prevodjenje napisan na springboot tehnologiji koristi java 8.

#### Analiza zadatka

```
Obrt koji ima nude usluge su individualne instrukcije, grupne instrukcije do 3 osobe, grupne instrukcije 4-6 osoba, lektoriranje teksta i prevođenje, a cijena je po satu ili po stranici ovisno o vrsti usluge. Kroz aplikaciju ćemo omogućiti unos računa gdje ćemo moći pratiti tko je koju uslugu kupio koja je cijena usluge, koliko smo PDV ( poreza) platili  državi. Uzeti ćemo u obzir da je PDV za navedene djelatnosti 25 posto. 
U aplikaciji ćemo omogućiti pregledavanje računa po osobi ili tvrtki također po tipu usluge i vremenskom razdoblju npr.
Npr. Pretražimo sve račune za Ivo Ivića , ili pretražimo sve račune što je obrt radio za Jamnicu u vremenskom razdoblju od 1.1.2022 do 1.3.20203 samo za usluge lektoriranja ili prevođenja teksta.
Omogućiti izdavanje računa – pdf download 

Kod unos racuna koristimo api:

 http://localhost:7777/racuni 

 body izgleda ovako za ovaj POST:

 {
    "brojRacuna": "123456",
    "datumIzdavanja": "2022-03-11",
    "ukupanIznos": 100,
    "jir": "JIR",
    "nacinPlacanja": "Nacin placanja",
    "ukupanIznosNaknadeIPoreza": 120,
    "kupac": {
        "imePrezime": "Ime i prezime",
        "adresa": "Adresa",
        "oib": "OIB",
        "email": "Email",
        "brojTelefona": "Broj telefona"
    },
    "stavkeRacuna": [
        {
        	"kolicina": 1,
            "uslugaId": 1,
            "racunId":4
        },
   {
         	"kolicina": 1,
            "uslugaId": 1,
            "racunId":4
        }
    ]
}

```
	
## Technogije i alati
Projekt je kreian s:
* sprngboot 2.7.0
* java 1.8
* Postgres baza (11.1)
* eclipse Version: 2019-12 (4.14.0)
* DBeaver
* Postman
* git
	
## Setup
Za pokrenuti ovaj projekt, treba imati instaliranu bazu postgres. Napraviti schema naziva pausni obrt.
Pokrenuti ddl scripttu modela podataka i na puniti je incijalnim podacima. Potrebno samo inforamcije o Obrtu i uslugama koje pruža.

```
$ preko DBeaver se spojiti na Postgres
$ napraviti novu schema pauslani obrt
$ ddl i ddm skripta:

CREATE TABLE Kupac (
  ID SERIAL PRIMARY KEY,
  ImePrezime VARCHAR(255) NOT NULL,
  Adresa VARCHAR(255) NOT NULL,
  OIB VARCHAR(11) NOT NULL,
  Email VARCHAR(255),
  BrojTelefona VARCHAR(20)
);


CREATE TABLE Obrt (
  ID SERIAL PRIMARY KEY,
  Naziv VARCHAR(255) NOT NULL,
  Adresa VARCHAR(255) NOT NULL,
  URL VARCHAR(255),
  KontaktBroj VARCHAR(20) NOT NULL,
  Vlasnik VARCHAR(255) NOT NULL
);

CREATE TABLE Usluga (
  ID SERIAL PRIMARY KEY,
  VrstaUsluge VARCHAR(255) NOT NULL,
  CijenaPoJedinici DECIMAL(10,2) NOT NULL,
  JedinicaMjere VARCHAR(20) NOT NULL,
  ObrtID INTEGER REFERENCES Obrt(ID)
);

CREATE TABLE Racun (
  ID SERIAL PRIMARY KEY,
  BrojRacuna VARCHAR(50) NOT NULL,
  DatumIzdavanja DATE NOT NULL,
  UkupanIznos DECIMAL(10,2) NOT NULL,
  JIR VARCHAR(50) NOT NULL,
  NacinPlacanja VARCHAR(50) NOT NULL,
  UkupanIznosNaknadeIPoreza DECIMAL(10,2) NOT NULL,
  KupacID INTEGER REFERENCES Kupac(ID)
);

CREATE TABLE StavkaRacuna (
  ID SERIAL PRIMARY KEY,
  Kolicina INTEGER NOT NULL,
  UslugaID INTEGER REFERENCES Usluga(ID),
  RacunID INTEGER REFERENCES Racun(ID)
);


INSERT INTO Kupac (ImePrezime, Adresa, OIB, Email, BrojTelefona)
VALUES ('Marko Marković', 'Ulica Marka Marulića 10', '12345678901', 'marko.markovic@gmail.com', '0911234567');

INSERT INTO Kupac (ImePrezime, Adresa, OIB, Email, BrojTelefona)
VALUES ('Ana Anić', 'Ulica Ivana Gorana Kovačića 25', '98765432101', 'ana.anic@yahoo.com', '0987654321');

INSERT INTO Obrt (Naziv, Adresa, URL, KontaktBroj, Vlasnik)
VALUES ('PD - prijevodi', 'Ulica Ante Starčevića 14', 'www.pd-prijevodi.hr', '021123456', 'Petar Petrović');

INSERT INTO Usluga (VrstaUsluge, CijenaPoJedinici, JedinicaMjere, ObrtID)
VALUES ('Grupne instrukcije do 3 osobe', 22.00, 'sat', 1),
       ('Grupne instrukcije 4-6 osoba', 23.00, 'sat', 1),
       ('Lektoriranje teksta', 20.00, 'stranica', 1),
       ('Prevođenje', 25.00, 'stranica', 1);
       
INSERT INTO Racun (BrojRacuna, DatumIzdavanja, UkupanIznos, JIR, NacinPlacanja, UkupanIznosNaknadeIPoreza, KupacID)
VALUES ('R0001', '2022-02-01', 450.00, '1234567890123456', 'gotovina', 563.00, 1);

INSERT INTO StavkaRacuna (Kolicina, UslugaID, RacunID)
VALUES (3, 1, 1);

INSERT INTO Racun (BrojRacuna, DatumIzdavanja, UkupanIznos, JIR, NacinPlacanja, UkupanIznosNaknadeIPoreza, KupacID)
VALUES ('R0002', '2022-02-15', 40.00, '9876543210987654', 'kartica', 49.60, 2);

INSERT INTO StavkaRacuna (Kolicina, UslugaID, RacunID)
VALUES (2, 2, 2);

aplikacija je dostupna na: http://localhost:7777/
```