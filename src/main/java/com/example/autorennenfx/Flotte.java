package com.example.autorennenfx;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Flotte {
    private ArrayList<Fahrzeug> fahrzeuge;

    public Flotte() {
        this.fahrzeuge = new ArrayList<>();

        Auto auto1 = new Auto(100, Color.RED);
        Auto auto2 = new Auto(200, Color.BLUE);
        Fahrrad fahrrad = new Fahrrad(300, Color.GREEN);

        this.fahrzeuge.add(auto1);
        this.fahrzeuge.add(auto2);
        this.fahrzeuge.add(fahrrad);
    }

    public ArrayList<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }

    public int getAnzahl() {
        if (fahrzeuge != null) {
            return fahrzeuge.size();
        }
        return 0;
    }

    public Point2D getPoint(int i) {
        return fahrzeuge.get(i).getPoint();
    }

    public void beschleunigen(int i) {
        fahrzeuge.get(i).beschleunigen();
    }

    public void bremsen(int i) {
        fahrzeuge.get(i).bremsen();
    }

    public void hupen(int i) {
        Fahrzeug fahrzeug = fahrzeuge.get(i);

        if (fahrzeug instanceof Auto) {
            ((Auto) fahrzeug).hupen();
        } else if (fahrzeug instanceof Fahrrad) {
            ((Fahrrad) fahrzeug).klingeln();
        }
    }

    public void fahrenAlle() {
        for (Fahrzeug fahrzeug : fahrzeuge) {
            fahrzeug.fahren();
        }
    }

    public void kollisionenPruefen(double fensterbreite) {
        for (Fahrzeug fahrzeug : fahrzeuge) {
            fahrzeug.kollisionserkennung(fensterbreite);
        }
    }

    public void alleAnzeigen(GraphicsContext graphicsContext) {
        for (Fahrzeug fahrzeug : fahrzeuge) {
            fahrzeug.anzeigen(graphicsContext);
        }
    }
}
