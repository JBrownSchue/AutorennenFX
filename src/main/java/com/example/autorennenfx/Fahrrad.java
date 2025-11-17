package com.example.autorennenfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.Objects;

public class Fahrrad extends Fahrzeug {

    public Fahrrad(int y, Color farbe) {
        super(y, farbe, 35, 7.0, 0.3, 0.7);
    }

    public void klingeln() {
        Media media = new Media(new File(Objects.requireNonNull(getClass().getResource("klingel.wav")).getPath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @Override
    public void anzeigen(GraphicsContext graphicsContext) {

        double x = getX();
        double y = getY();
        double laenge = 35;
        double radRadius = 10; // Radius der Räder
        double sattelHoehe = 15;
        double lenkerBreite = 15;

        graphicsContext.setStroke(getFarbe()); // Rahmenfarbe
        graphicsContext.setLineWidth(2);

        // 1. Räder (Kreise)
        graphicsContext.strokeOval(x + 5, y + sattelHoehe + 5, radRadius * 2, radRadius * 2); // Hinterrad
        graphicsContext.strokeOval(x + laenge - radRadius - 5, y + sattelHoehe + 5, radRadius * 2, radRadius * 2); // Vorderrad

        // 2. Rahmen (Dreiecke und Linien)
        // Haupt-Dreieck
        graphicsContext.strokeLine(x + 5 + radRadius, y + sattelHoehe + 5 + radRadius, // Mitte Hinterrad
                x + laenge - 5 - radRadius, y + sattelHoehe + 5 + radRadius); // Mitte Vorderrad (untere Stange)

        graphicsContext.strokeLine(x + 5 + radRadius, y + sattelHoehe + 5 + radRadius, // Mitte Hinterrad
                x + laenge / 2, y); // Sattelstange

        graphicsContext.strokeLine(x + laenge - 5 - radRadius, y + sattelHoehe + 5 + radRadius, // Mitte Vorderrad
                x + laenge / 2, y); // Oberrohr zum Sattel

        // 3. Lenker
        graphicsContext.strokeLine(x + laenge - 5, y + sattelHoehe + 5 + radRadius - 5, // Lenkerstange
                x + laenge - 5 + 5, y); // Lenkergriff

        graphicsContext.strokeLine(x + laenge - 5 + 5, y, // Lenkergriff
                x + laenge - 5 + 5 - lenkerBreite, y + 5); // Lenker horizontal

        // 4. Sattel
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillOval(x + laenge / 2 - 5, y - 5, 15, 8); // Sattel

        // 5. Pedale
        graphicsContext.setFill(Color.DARKGRAY);
        graphicsContext.strokeLine(x + (laenge / 2) + 2, y + sattelHoehe + 5 + radRadius, // Kurbelachse
                x + (laenge / 2) + 10, y + sattelHoehe + 5 + radRadius + 5); // Pedal
        graphicsContext.fillOval(x + (laenge / 2) + 10, y + sattelHoehe + 5 + radRadius + 5, 4, 4); // Pedalpunkt

        // Kette (als Linie)
        graphicsContext.setStroke(Color.DARKGRAY);
        graphicsContext.setLineWidth(1);
        graphicsContext.strokeLine(x + 5 + radRadius, y + sattelHoehe + 5 + radRadius + 5,
                x + laenge / 2, y + sattelHoehe + 5 + radRadius + 5);
    }
}
