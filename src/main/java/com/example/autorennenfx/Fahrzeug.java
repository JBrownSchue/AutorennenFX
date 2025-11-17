package com.example.autorennenfx;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Fahrzeug {
    private double x;
    private double y;
    private int laenge;
    private Color farbe;
    protected double geschwindigkeit;
    private double maxGeschwindigkeit;
    private double beschleunigung;
    private double bremskraft;

    public Fahrzeug(int y, Color farbe, int laenge, double maxGeschwindigkeit, double beschleunigung,  double bremskraft) {
        this.x = 0;
        this.y = y;
        this.farbe = farbe;
        this.laenge = laenge;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.beschleunigung = beschleunigung;
        this.bremskraft = bremskraft;
        this.geschwindigkeit = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point2D getPoint() {
        return new Point2D(x, y);
    }

    public Color getFarbe() {
        return farbe;
    }

    public String getGeschwindigkeit() {
        return String.format("%03.0f", this.geschwindigkeit);
    }

    public void beschleunigen() {
        if (geschwindigkeit < maxGeschwindigkeit) {
            this.geschwindigkeit += this.beschleunigung;
            if (this.geschwindigkeit > this.maxGeschwindigkeit) {
                this.geschwindigkeit = this.maxGeschwindigkeit;
            }
        }
    }

    public void bremsen() {
        if (geschwindigkeit > 0) {
            this.geschwindigkeit -= this.bremskraft;
            if (this.geschwindigkeit < 0) {
                this.geschwindigkeit = 0;
            }
        }
    }

    public void fahren() {
        this.x += this.geschwindigkeit / 60.0;
    }

    public void kollisionserkennung(double fensterbreite) {
        if (this.x > fensterbreite) {
            this.x = -this.laenge;
        }
    }

    public abstract void anzeigen(GraphicsContext graphicsContext);


}
