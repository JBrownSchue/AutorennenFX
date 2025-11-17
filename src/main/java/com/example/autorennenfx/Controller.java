package com.example.autorennenfx;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controller {
    private Flotte flotte;
    private GraphicsContext graphicsContext;
    private AnimationTimer timer;

    @FXML
    private Canvas cvsFahrbahn;
    @FXML
    private Button btnBremse1;
    @FXML
    private Button btnGas1;
    @FXML
    private Button btnHupe1;
    @FXML
    private Label lblTacho1;
    @FXML
    private Button btnBremse2;
    @FXML
    private Button btnGas2;
    @FXML
    private Button btnHupe2;
    @FXML
    private Label lblTacho2;
    @FXML
    private Button btnBremse3;
    @FXML
    private Button btnTreten;
    @FXML
    private Button btnKlingeln;

    @FXML
    public void initialize() {
        flotte = new Flotte();
        graphicsContext = cvsFahrbahn.getGraphicsContext2D();

        btnGas1.setOnAction(this::handle);
        btnBremse1.setOnAction(this::handle);
        btnHupe1.setOnAction(this::handle);

        btnGas2.setOnAction(this::handle);
        btnBremse2.setOnAction(this::handle);
        btnHupe2.setOnAction(this::handle);

        btnTreten.setOnAction(this::handle);
        btnBremse3.setOnAction(this::handle);
        btnKlingeln.setOnAction(this::handle);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

    // Zentrale Update-Methode (Game-Loop)
    private void update() {
        flotte.fahrenAlle();
        flotte.kollisionenPruefen(cvsFahrbahn.getWidth());

        graphicsContext.clearRect(0, 0, cvsFahrbahn.getWidth(), cvsFahrbahn.getHeight());
        flotte.alleAnzeigen(graphicsContext);

        lblTacho1.setText(flotte.getFahrzeuge().get(0).getGeschwindigkeit());
        lblTacho2.setText(flotte.getFahrzeuge().get(1).getGeschwindigkeit());
    }

    private void handle(ActionEvent event) {
        Object source = event.getSource();

        if (source == btnGas1) {
            flotte.beschleunigen(0);
        } else if (source == btnBremse1) {
            flotte.bremsen(0);
        } else if (source == btnHupe1) {
            flotte.hupen(0);
        }

        else if (source == btnGas2) {
            flotte.beschleunigen(1);
        } else if (source == btnBremse2) {
            flotte.bremsen(1);
        } else if (source == btnHupe2) {
            flotte.hupen(1);
        }

        else if (source == btnTreten) {
            flotte.beschleunigen(2);
        } else if (source == btnBremse3) {
            flotte.bremsen(2);
        } else if (source == btnKlingeln) {
            flotte.hupen(2);
        }
    }

}
