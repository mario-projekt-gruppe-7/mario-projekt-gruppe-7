# Velkommen til Gruppe 7s Mario Projekt

Dette repository indeholder gruppe 7's opgavebesvarelse til opgaven "Mario's model.Pizza" på EK's datamatikeruddannelse. I opgaven skulle vi udvikle et IT-system til et pizzaria. 
Se opgaven [her](src/main/resources/opgave.pdf)

Opgaven er afleveret 27. marts 2026

##### Udviklere:
Carl Emil Zeidler  
Salim Mustafa  
Victor Klemens Nørrekaas  
Mattie Høgsted  


Er du udvikler, se vores [wiki](https://github.com/mario-projekt-gruppe-7/mario-projekt-gruppe-7/wiki) for at finde arbejdsgange og yderligere dokumentation.

Følg guiden herunder for at bruge programmet.

## Clone projektet med SSH

1. Find den mappe på din computer, hvor du vil have projektet.
2. Højreklik og vælg **New Terminal** i folderen (eller tilsvarende i Windows).
3. Kør følgende kommando:

```bash
git clone git@github.com:mario-projekt-gruppe-7/mario-projekt-gruppe-7.git
```

## Krav for at køre

- **Java JDK version 21** 
- **Maven** 
- en terminal/console som understøtter **ANSI escape codes** for styling (det gør de fleste terminaler).

Check dine installationer:

```bash
java -version
javac -version
mvn -version
```

## Kør projekt med Maven

### compile projektet
```bash
mvn compile
```
### Kør programmet
```bash
mvn exec:java -Dexec.mainClass="Main"
```