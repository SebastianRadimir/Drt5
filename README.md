# Basic Dart Spiel

This repository contains a student project created for an ongoing lecture on object-oriented programming with Java at HWR Berlin (summer term 2022).

> :warning: This code is for educational purpose only. Do not rely on it!

## Abstract

This project is a simple Dart game, it has a very good point determination system based on polar coordinates.

It has a dynamic range of players that can play (3 by default), a dynamic maximum point to start the game with (301 points by default) as well as a dynamic amount of throws per round (default 3). all of these can be changed in Main.java 

The biggest problem was efficiently mapping all the points correctly to the dartboard and testing it.

## Feature List

[TODO]: # (For each feature implemented, add a row to the table!)

| Number | Feature                                                                       | Tests |
|--------|-------------------------------------------------------------------------------|-------|
| 1      | Eine dynamische Anzahl an Spieler, die nach drei mal werfen, wechseln sollen. | 4     |
| 2      | Ein Punkt in Polarkoordinaten umwandeln.                                      | 10    |
| 3      | Wenn ein Spieler genau 0 punkte erreicht hat, endet das Spiel.                | 3     |
| 4      | Punkte vom Wurf ausrechnen         | 24    |
| 5      | Beim Spielbegin fängt jeder per default mit 501 Punkten an(wenn wir zeit haben, würden wir den Nutzer erlauben eine positive Punktzahl einzusetzen).        | 3     |
| 6      | Auf der Konsole ein Dartboard printen.       | 3     |
| 7      | Wenn einen Spieler fertig ist, bekommt man eine Zusammenfassung ausgegeben.     | 2     |


## Additional Dependencies

[TODO]: # (For each additional dependency your project requires- Add an additional row to the table!)

| Number | Dependency Name | Dependency Description                                                                                                                                                                                                                                                                                                 | Why is it necessary?                                                                                                                                 |
|--------|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1      | java.util.Random    | An instance of this class is used to generate a stream of pseudorandom numbers; its period is only 248. The class uses a 48-bit seed, which is modified using a linear congruential formula. (See Donald E. Knuth, The Art of Computer Programming, Volume 2, Third edition: Seminumerical Algorithms, Section 3.2.1.) | need it to get a random point on the board                                                                                                           |
| 2      | java.util.Arrays   |   This class contains various methods for manipulating arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be viewed as lists.                                                                                                                                                                                                                                                                                                 | used it to create a 2d char field that allowed me to easily fill a speciofic point, this was used to create the printed dartboard                    |
| 3      | java.lang.Math   | The class Math contains methods for performing basic numeric operations such as the elementary exponential, logarithm, square root, and trigonometric functions.                                                                                                                                                       | used for the cos(), sin() and toRadians() function in order to convet cartesian coordinates into polar coordinates and back to cartesian coordinates |
| 4      | java.util.ArrayList   | Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list.                    | used to keep a collection of darts that were thrown                                                                                                  |

