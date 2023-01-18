package com.example.proyectjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class GameController {

    private boolean gameEnded=false;
    private int turnNumber=0;




    @FXML
    private Label welcomeText;

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button reset;
    private int playerTurnNumber = 0;
    @FXML
    private Text playerTurnText;

    @FXML
    void showWinDialog(String winner){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner!");
        alert.setContentText("Player " + winner + " won!");
        Optional<ButtonType> result = alert.showAndWait();
    }
    @FXML
    void showTieDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tie!");
        alert.setContentText("Reset and try again!");
        Optional<ButtonType> result = alert.showAndWait();
    }


    @FXML
    private RadioButton CompVsComp;
    @FXML
    private RadioButton PlayerVsComp;

    @FXML
    private RadioButton PlayerVsPlayer;
    @FXML
    private Button dark;
    @FXML
    private Button light;

    @FXML
    protected void scoresGameScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scores.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage statsStage = new Stage();
        statsStage.setTitle("Scores");
        statsStage.setScene(scene);
        statsStage.initModality(Modality.NONE);
        statsStage.show();
    }
    @FXML
    protected void playerName() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ReenamePlayersView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage statsStage = new Stage();
        statsStage.setTitle("Choose a new name");
        statsStage.setScene(scene);
        statsStage.initModality(Modality.NONE);
        statsStage.show();
    }
    @FXML
    protected void aboutRules() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AboutView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage statsStage = new Stage();
        statsStage.setTitle("RULES!");
        statsStage.setScene(scene);
        statsStage.initModality(Modality.NONE);
        statsStage.show();
    }
    ArrayList<Button> buttons;

    public void initialize(){
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));


        if(PlayerVsPlayer.isSelected()){
            buttons.forEach(button -> {
                setupButton(button);
                button.setFocusTraversable(false);

            });

        }
        else if(CompVsComp.isSelected()){
            buttons.forEach(button -> {
                compSelctTurn();
                button.setFocusTraversable(false);
            });
        }
        else if(PlayerVsComp.isSelected()) {
            buttons.forEach(button -> {
                playerVSCompSetButtom(button);
                button.setFocusTraversable(false);
            });
        }
    }
    //Reseteara el juego
    @FXML
    void restartGame(){
        buttons.forEach(this::resetButton);
        gameEnded=false;
        playerTurnNumber=0;
        turnNumber=0;
    }

//volver el boton al valor inicial
    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");

    }

//Identificar los clicks en PlayervsPlayer
    public void setupButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();


        });
    }
    //Decidir los turnos en PlayervsPlayer
    public void setPlayerSymbol(Button button){

        if(playerTurnNumber % 2==0){
            button.setText("X");
            playerTurnNumber=1;
            turnNumber++;
            playerTurnText.setText("Playing: Player 2");
        }
        else {
            button.setText("O");
            playerTurnNumber=0;
            turnNumber++;
            playerTurnText.setText("Playing: Player 1");
        }
    }
//La IA o el random que pintara cada casilla de la maquina,
    public void compSetButton(String resultado) {
        boolean posiblePintarCasilla = false;
        if (!gameEnded) {
            while (!posiblePintarCasilla) {
                int resultadoComp = (int) Math.floor(Math.random() * 9);
                switch (resultadoComp) {
                    case 0:
                        if (button1.isDisabled()) {
                            break;
                        } else {
                            button1.setText(resultado);
                            button1.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 1:
                        if (button2.isDisabled()) {
                            break;
                        } else {
                            button2.setText(resultado);
                            button2.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 2:
                        if (button3.isDisabled()) {
                            break;
                        } else {
                            button3.setText(resultado);
                            button3.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 3:
                        if (button4.isDisabled()) {
                            break;
                        } else {
                            button4.setText(resultado);
                            button4.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 4:
                        if (button5.isDisabled()) {
                            break;
                        } else {
                            button5.setText(resultado);
                            button5.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 5:
                        if (button6.isDisabled()) {
                            break;
                        } else {
                            button6.setText(resultado);
                            button6.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 6:
                        if (button7.isDisabled()) {
                            break;
                        } else {
                            button7.setText(resultado);
                            button7.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 7:
                        if (button8.isDisabled()) {
                            break;
                        } else {
                            button8.setText(resultado);
                            button8.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                    case 8:
                        if (button9.isDisabled()) {

                            break;
                        } else {
                            button9.setText(resultado);
                            button9.setDisable(true);
                            checkIfGameIsOver();
                            posiblePintarCasilla = true;
                            break;
                        }
                }
            }
        }
    }
    public void compSelctTurn() {
        if(playerTurnNumber % 2==0){
            String resultado="X";
            compSetButton(resultado);
            playerTurnNumber=1;
            turnNumber++;
            playerTurnText.setText("Playing: Player 2");
        }
        else {
            String resultado="O";
            compSetButton(resultado);
            playerTurnNumber=0;
            turnNumber++;
            playerTurnText.setText("Playing: Player 1");
        }
    }

    public void playerVSCompSetButtom(Button button){
        if(playerTurnNumber==8){
              button.setOnMouseClicked(mouseEvent -> {
                  setPlayerSymbol(button);
                  button.setDisable(true);
                  checkIfGameIsOver();
              });
          }
          else {
              button.setOnMouseClicked(mouseEvent -> {
                  setPlayerSymbol(button);
                  button.setDisable(true);
                  checkIfGameIsOver();
                  playerTurnNumber=1;
                  playerTurnText.setText("Playing: Player 2");
                  compSetButton("O");
                  turnNumber++;
                  playerTurnNumber=0;
                  playerTurnText.setText("Playing: Player 1");
              });
          }


    }
//Comprueba si alguien ha ganado
    public boolean checkIfGameIsOver() {
        for (int i = 0; i < 8; i++) {
            String line = switch (i) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                showWinDialog("Player 1");
                gameEnded=true;
                buttons.forEach(button -> {
                    button.setDisable(true);
                });


            }
            //O winner
            else if (line.equals("OOO")) {
                gameEnded=true;
                showWinDialog("Player 2");
                buttons.forEach(button -> {
                    button.setDisable(true);
                });

                return true;


            }


        }
        if (turnNumber==9 && !gameEnded) {
            showTieDialog();
            buttons.forEach(button -> {
                button.setDisable(true);
            });
        }

        return false;
    }


    //Cierra el juego
    @FXML
    protected void closeGame() {
        System.exit(0);
    }
}