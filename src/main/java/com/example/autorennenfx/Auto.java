package com.example.autorennenfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.io.File;
import java.util.Objects;

public class Auto extends Fahrzeug {

    public Auto(int y, Color farbe) {
        super(y, farbe, 55, 30.0, 0.5, 1.5);
    }

    public void hupen() {
        Media media = new Media(new File(Objects.requireNonNull(getClass().getResource("hupe.wav")).getPath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @Override
    public void anzeigen(GraphicsContext graphicsContext) {

        double x = getX();
        double y = getY();
        double laenge = 55;
        double breite = 30;
        double radRadius = 8;

        // 1. Hauptkarosserie (Farbe des Autos)
        graphicsContext.setFill(getFarbe());
        graphicsContext.fillRect(x, y + 5, laenge, breite); // Hauptkörper
        graphicsContext.fillArc(x, y + 5, radRadius * 2, breite, 90, 180, ArcType.OPEN); // Vorderer Radkasten-Effekt
        graphicsContext.fillArc(x + laenge - radRadius * 2, y + 5, radRadius * 2, breite, 270, 180, ArcType.OPEN); // Hinterer Radkasten-Effekt

        // 2. Dach (leicht abgesetzt, Farbe des Autos)
        graphicsContext.fillRect(x + 10, y, laenge - 20, breite);

        // 3. Fenster (dunkler)
        graphicsContext.setFill(Color.web("#87CEEB")); // Himmelblau für Fenster
        graphicsContext.fillRect(x + 12, y + 2, 15, breite - 5); // Vorderes Fenster
        graphicsContext.fillRect(x + laenge - 27, y + 2, 15, breite - 5); // Hinteres Fenster

        // 4. Räder (Schwarz mit grauer Felge)
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillOval(x + 5 - radRadius, y + breite + 5 - radRadius, radRadius * 2, radRadius * 2); // Hinterrad
        graphicsContext.fillOval(x + laenge - 5 - radRadius, y + breite + 5 - radRadius, radRadius * 2, radRadius * 2); // Vorderrad

        graphicsContext.setFill(Color.DARKGRAY); // Felgen
        graphicsContext.fillOval(x + 5 - radRadius + 2, y + breite + 5 - radRadius + 2, radRadius * 2 - 4, radRadius * 2 - 4);
        graphicsContext.fillOval(x + laenge - 5 - radRadius + 2, y + breite + 5 - radRadius + 2, radRadius * 2 - 4, radRadius * 2 - 4);

        // 5. Scheinwerfer (Gelb)
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.fillOval(x + laenge - 5, y + 10, 5, 5); // Vorderer Scheinwerfer

        // 6. Rücklicht (Rot)
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillOval(x + 2, y + 10, 5, 5); // Rücklicht
    }
}
