# Turtle Graphics

En skildpadde bevæger sig på en overflade sådan her:

```java
TurtleCanvas canvas = new TurtleCanvas(CANVAS_WIDTH, CANVAS_HEIGHT);
Turtle bob = new Turtle(canvas, Color.WHITE, bob_speed, bob_x, bob_y);

bob.forward(100);
bob.left(90);
bob.forward(100);
bob.right(45);
bob.back(50);
```

Altså med `.forward(distance)`, `.left(degrees)`, `.right(degrees)` og `.back(distance)`.

En skildpadde kan også:
- `.teleport(x, y, angle)` for pludseligt at stå et nyt sted
- `.color(Color.BLUE)` for at skifte farve undervejs
- `.stopDrawing()` og `.startDrawing()` for at bevæge sig uden at tegne

## Delopgave 1: Klon projektet til din computer

1. Brug git bash eller GitHub Desktop
2. Åbn projektet med IntelliJ efterfølgende

## Delopgave 2: Tjek at koden virker

1. Åbn [Main.java](src/main/java/dk/kea/turtles/Main.java) i IntelliJ og kør koden ▶️
2. Find en måde at skifte retningen pilen peger
3. Gør pilen længere ved at rette `.forward(100)`
4. Flyt koden ind i en hjælpefunktion:
   ```java6
   public static void drawArrow(Turtle bob) {
       ...
   }
   ```
5. Lav en `for`-løkke som kalder `drawArrow(bob)` 8 gange.

## Delopgave 3: Skriv din gruppes bogstav(er)

1. Sæt dig sammen med din gruppe (bestemt ud fra dit fornavn)
2. Løs opgaven hver især, men hjælp hinanden. I må gerne dele kode.
3. Læg koden til at tegne et bogstav i sin egen `static void` funktion.
4. Lav en `for`-løkke som kalder din bogstav-funktion og `bob.left(60)` 6 gange.

## Delopgave 4: Gem din løsning på en branch

Udfør følgende enten med git bash eller GitHub Desktop:

1. Lav en ny branch der hedder `uge35-løsning`
2. Tilføj dine ændringer og commit dem med en god commit-besked
3. Opret en pull request for din branch på GitHub