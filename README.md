# Projet TP3 - Tests unitaires

## Description
Ce projet implémente la classe `RomanNumber` permettant de convertir des nombres entiers entre 1 et 3999 en chiffres romains, et inversement. La classe étend `java.lang.Number` et implémente `Comparable<RomanNumber>`.

## Structure
- `src/main/java/com/example/romannumerals/RomanNumber.java` : implémentation de la conversion.
- `src/test/java/com/example/romannumerals/RomanNumberTest.java` : tests unitaires JUnit 5.
- `build.gradle`, `settings.gradle` : configuration Gradle.

## Prérequis
- Java 8 ou supérieur
- Gradle

## Compilation et tests
À la racine du projet :
```bash
./gradlew build
./gradlew test
```
