Muutamia huomioita/lukuohjeita henkilörekisterisovellukseen:

- Ainoa varsinainen bisneslogiikka, joka tehtävänannon laajuudessa oikeastaan tulee mieleen, on datan validointi. Datan integriteetti lienee tällaisen järjestelmän keskeinen hyve, varsinainen datan käyttö on sitten muiden järjestelmien heiniä.
- Domain-luokissa on toteutettu esimerkinomaisesti henkilötunnuksen ja syntymäpaikan validointi ja testejä näille. Näiden ulkopuolella suurin osa domain-luokkien sisällöstä on korkeintaan implementoimatonta luurankoa.
- REST-rajapinnan rooli tässä jäi hieman epäselväksi, kun tarkoituksena ei ollut edes tehdä käynnistyvää sovellusta. Kirjoitettu lähinnä hahmotelmaa REST-rajapinnan mahdollisesta rakenteesta, ei varsinaisesti toimi eivätkä palauta mitään (ei aikaa/jaksua lähteä tekemään backendin puolelle mitään mockia).
- Frontend tehty Reactilla. Sinne rakennettu pieni mock-backend ja sinne hyvin yksinkertainen simultoitu "validointi", mutta frontti ei tietenkään ole missään yhteydessä backiin, koska backia ei kokonaisena toimivana sovelluksena ole olemassakaan. 

Asiaa enempää miettimättä ja tutkimatta tehty useita oletuksia domainista, esim:
- Henkilö ei poistu rekisteristä ikinä, myöskään kuollessaan, vaan saa ainoastaan DeathDate-attribuutin. Rekisteristä muodostuu siis myös kuolleiden ihmisten rekisteri. (Ei hajuakaan toimiiko esim. Suomen oikea väestörekisteri näin.)
- Henkilötunnus on muuttumaton (todellisuudessa se kai joissain harvinaisissa tapauksissa voidaan muuttaa turvallisuusyistä).
- jne. jne.
