# Fahrzeug-Simulation

Dieses Projekt implementiert eine Fahrzeugsimulation in JavaFX. Es besteht aus einer `Flotte`, die verschiedene `Fahrzeuge` (Autos und Fahrräder) verwaltet, einem `Controller` zur Steuerung und einer `Anzeige` (Canvas) zur Visualisierung.

## Level 1: Flotte

Dieser Abschnitt beschreibt die übergeordneten Anforderungen an die `Flotte` und die grundlegende Anwendungsstruktur.

### Anforderungen (aus Bild 2)

* **Konstruktor:** Im Konstruktor der `Flotte` werden **zwei Autos** (ein rotes, ein blaues) und **ein grünes Fahrrad** erstellt.
* **Positionierung:** Die Fahrzeuge sollen untereinander mit **100px Abstand** positioniert werden.
* **Hupen:** Die Methode `hupen()` soll implementiert werden. Autos hupen, Fahrräder klingeln.

### Klassenstruktur (UML aus Bild 2)

Die Anwendung folgt der gezeigten UML-Struktur:

* **Flotte:** Hält eine Liste von Fahrzeugen (`ArrayList<Fahrzeug>`).
* **Fahrzeug (abstract):** Die abstrakte Oberklasse für alle Fahrzeuge. Definiert gemeinsame Attribute (x, y, laenge, farbe, geschwindigkeit, etc.) und Methoden (`hupen()`, `fahren()`, `bremsen()`, `anzeigen(...)`).
* **Auto:** Konkrete Implementierung von `Fahrzeug`.
* **Fahrrad:** Konkrete Implementierung von `Fahrzeug`.

### Controller-Einbindung (aus Bild 1)

* **MVC-Pattern:** Die Anwendung nutzt ein Model-View-Controller-Muster.
* **Konstruktor:** Der `Controller` (erstellt im SceneBuilder) initialisiert das Model (`Flotte`) und die View (`Anzeige`) und verknüpft diese.
* **Game-Loop (`update()`):** Die `update()`-Methode im Controller dient als Haupt-Schleife. Sie wird vom Model aufgerufen, um die Anzeige zu aktualisieren.

```java
public void update() {
    // Canvas leeren
    graphicContext.clearRect(0, 0, graphicContext.getCanvas().getWidth(), graphicContext.getCanvas().getHeight());

    // Flotte bewegen und zeichnen
    flotte.bewegen(graphicContext.getCanvas().getWidth());
    flotte.zeichnen(graphicContext);

    // Ggf. Text anzeigen (z.B. Punktestand)
    graphicContext.setText(...);
    graphicContext.getCanvas()....;
}
```
![Part 1](/images/Part-1.jpg)


# Controller & Canvas-Methoden

## Controller

Im Controller werden alle Buttons mit Funktionen belegt. Außerdem wird das Canvas im SceneBuilder-Kontext als "aktiviert" (Methodennamen an Aktionen) angesehen.

### Tiefen

* Einträge im SceneBuilder für die Methodennamen in den onAction-Feldern der Buttons fest.
* Zuweisen der `.fxml`-Datei an den Controller.
* Starten des großen "update"-Aufrufs aus dem Controller aus dem SceneBuilder (siehe "Game/View/Sample-Controller-Strukturen").

### Konstruktor

* Die `Flotte` erstellen.
* Normalerweise verbindet man beim MVC Pattern das Model (die `Flotte`) bei einer Änderung der View mit dem Controller. Da hier eine Animation (GameLoop) stattfindet, wird die View (die `Anzeige`) dem Controller bekannt gemacht und der Controller startet die Animation. Im `update` holt er sich die "replace"-Methode.

### update()

* 60 mal pro Sekunde:
    * Fahrzeuge `fahren` lassen
    * Kollisionserkennung durchführen
    * Auf dem Canvas anzeigen
    * Geschwindigkeiten in der View aktualisieren

### public und update()

```java
graphicContext.clearRect(0,0, graphicContext.getCanvas().getWidth(), graphicContext.getCanvas().getHeight());
flotte.bewegen(graphicContext.getCanvas().getWidth());
flotte.zeichnen(graphicContext);
graphicContext.setText(...);
graphicContext.getCanvas()...;
```
![Part 2](/images/Part-2.jpg)
