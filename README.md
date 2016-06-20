# sommerprosjekt-backend-oppgaver

## Oppgave 1 - Lag et REST-endepunkt som returnerer alle tv seriene registrert i databasen

Finn klassen ShowsRestService som er lokalisert i TVDBEndpoint under **no.mesan.tvdb.shows.ShowsRestService**. Denne har en metode kalt *fetchShows()* som allerede er satt opp. Både *ShowsRestService* og *ShowsDelegate* er allerede implementert, men service og dao laget inneholder bare tomme metoder. Implementer disse metodene slik at alle tvseriene som er registrert i databasen returneres.

Endepunktet kan trigges ved å gjøre et GET kall mot http://localhost:9000/TVDBEndpoint/api/shows

1. Du skal implementere *ShowDao.readShows()* og *ShowRowMapper.mapRow(...)*
2. *ShowService.fetchShows()* må gjøre et kall mot *ShowDao.readShows()*

### Tips:
1. Tabell-definisjonen for Shows finnes i *src/main/resources/db/migration/V1__shows.sql*. Bruk denne for å lage select-spørringen for å hente alle tv seriene.
2. Det er allerede opprettet et domeneobjekt for Show. Dette er lokalisert under *no.mesan.tvdb.domain* i TVDBService. ShowRowMapper skal returnere en instans av Show.
3. Kall mot databasen gjøres ved å bruke *tvdbNamedTemplate*. Bruk tvdbNamedTemplate.query(select-query, params, rowmapper);

Resultatet skal se slik ut:
```json
[
  {
    "id": 100,
    "name": "Game of Thrones",
    "description": "Game of Thrones is an HBO adaptation of American author George R.R. Martin's epic fantasy novel series published by HarperCollins, A Song of Ice and Fire. The show explores a medieval-like fantasy world with its plethora of characters all struggling in the only game that matters--the game of thrones. And in this game you either win or you die, there is no middle ground.",
    "seasons": null
  }
]
```

## Oppgave 2 - Lag endepunkter for å legge til og fjerne en tv-serie.

#### Det skal kunne legges til en tvserie ved **POST** til http://localhost:9000/TVDBEndpoint/api/shows

Body-delen av meldingen skal se slik ut:

```json
{
    "name": "Banshee",
    "description": "After serving 15 years in prison, a convicted diamond thief turns up in Banshee, Pennsylvania to collect what he's owed and ends up assuming the identity of the small Amish town's new sheriff.  With exceptional martial arts skills and a more direct form of justice, the new sheriff is more than a match for existing crime boss, Kai Proctor."
}
```

Hvis opprettelsen av tvserien var vellykket returneres statuskoden **201 CREATED**. Resultatet skal også inneholde **LOCATION** i HEADER-delen av meldingen. Verdien av denne skal være full url til den opprettede ressursen (http://localhost:9000/TVDBEndpoint/api/shows/{showId}).

**Response.created(uri).build();** Brukes for å returnere statuskode 201 med LOCATION header.

#### **DELETE** på http://localhost:9000/TVDBEndpoint/api/shows/{showId} skal slette den aktuelle tvserien. 
Kast en **400 BAD REQUEST** hvis tvserien med angitt id ikke finnes i databasen.

#### Tips:
1. Opprett ny metode i *ShowsRestService* kalt *.createShow(show)* for å legge til en ny tvserie. Bruk *@POST* for å markere metoden som et POST-kall.
2. Legg til ny metode kalt *.deleteShow(showId)* i *ShowsRestService* som sletter en aktuell tvserie. Bruk @DELETE og @Path("{showId}").

## Oppgave 3 - Registrere ny sesong på en tv serie

Lag endepunkt for å legge til en sesong på en tvserie. Dette gjøres ved kall mot:

**POST** http://localhost:9000/TVDBEndpoint/api/shows/{showId}/seasons/

Body-delen av meldingen skal se slik ut:
```json
{
    "seasonNumber": 1
}
```

#### Tips:
1. Opprett ny tabell for sesonger i databasen. Dette gjøres ved å legge til en ny fil i *src/main/resources/db/migration*. Kall denne for V1_1__seasons.sql
3. Bruk tvdbNamedTemplate.update(sql-query, params) for å lagre sesongen i databasen. Husk å returnere id etter opprettelse for å kunne bygge LOCATION delen av returmeldingen.

## Oppgave 4 - Registrere episode på en sesong

Lag endepunkt for å legge til en episode ved kall mot: 

**POST** http://localhost:9000/TVDBEndpoint/api/shows/{showId}/seasons/{seasonNumber}/episodes

Body-delen av meldingen skal se slik ut:
```json
{
    "episodeNumber": 1,
    "name": "Winter Is Coming",
    "description": "After the death of his Hand, Jon Arryn, King Robert Baratheon journeys North to ask an old friend to fill the position. Across the Narrow Sea, the disgraced Viserys Targaryen has plans for his younger sister, Daenerys.",
    "aired": "17.04.2011"
}
```

#### Tips:
1. Opprett ny tabell for episoder i databasen. Dette gjøres ved å legge til en ny fil i *src/main/resources/db/migration*. Kall denne for V1_2__episodes.sql
2. Gjør ferdig domeneklassen *Episode* lokalisert i TVDBService *no.mesan.tvdb.domain*.
3. Bruk tvdbNamedTemplate.update(sql-query, params) for å legge episoden til i databasen. Husk å returnere id etter opprettelse for å kunne bygge LOCATION delen av returmeldingen.

## Oppgave 5 - Endepunkt for å returnere en tvserie med alle sesonger og episoder

Her skal du gjøre ferdig endepunktet *ShowsRestService.fetchShowById(showId)*. Resulatet skal se slik ut:

```json
  {
    "id": 100,
    "name": "Game of Thrones",
    "description": "Game of Thrones is an HBO adaptation of American author George R.R. Martin's epic fantasy novel series published by HarperCollins, A Song of Ice and Fire. The show explores a medieval-like fantasy world with its plethora of characters all struggling in the only game that matters--the game of thrones. And in this game you either win or you die, there is no middle ground.",
    "seasons": [
        {
            "seasonNumber": 1,
            "episodes": [
                {
                    "episodeNumber": 1,
                    "name": "Winter Is Coming",
                    "description": "After the death of his Hand, Jon Arryn, King Robert Baratheon journeys North to ask an old friend to fill the position. Across the Narrow Sea, the disgraced Viserys Targaryen has plans for his younger sister, Daenerys.",
                    "aired": "17.04.2011"
                }
            ]
        }
    ]
  }
```

## Oppgave 6 - Utvide sletting av tvserie til å inkludere alle sesonger og episoder
Du skal her utvide slettelogikken laget i oppgave 2 til å fjerne alle sesonger og episoder registrert på den aktuelle tvserien.