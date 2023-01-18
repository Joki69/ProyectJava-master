package com.example.proyectjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ReenamePlayersController extends HelloApplication {
//No consigue cambiar el nombre de los jugadores
    @FXML
    private Button okName1;

    @FXML
    private Button okName2;

    @FXML
    private TextField player1;
    @FXML
    private TextField player2;

    @FXML
    private void changeName1(MouseEvent event){
        setNamePlayer1(player1.getText().toString());
        System.out.println(player1.getText().toString());
        System.out.println(getNamePlayer1());
    }

    @FXML
    private void changeName2(MouseEvent event){
        setNamePlayer2(player2.getText().toString());
        System.out.println(getNamePlayer2());
    }
}

