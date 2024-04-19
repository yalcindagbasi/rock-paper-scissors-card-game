package com.example.arayuzilk;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private Button btnGiris;

    @FXML
    private Button btnHazirlayanlar;

    @FXML
    private Button btnSilahSec;

    @FXML
    private Button btnnasilOynanir;

    @FXML
    private Pane panelDegisim;
@FXML
    private Label üstYazi;


    public void adds (ActionEvent event){
        if (event.getSource() == btnGiris){

        }
        else  if (event.getSource() == btnnasilOynanir){
        }
        else  if (event.getSource() == btnHazirlayanlar){


        }
        else  if (event.getSource() == btnSilahSec){
        }
    }
    @FXML
    private Circle geriDon;
private Stage stage;
private Scene scene;
private Parent root;

    @FXML
    private Button menuyeDon;


public void GirisEkranınaGir(ActionEvent event) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("girisYeni.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
@FXML
    public void menuyeDon (ActionEvent event) throws IOException{
        if (event.getSource() == menuyeDon) {
            Parent root = FXMLLoader.load(getClass().getResource("arayuz.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
    @FXML
    void silahSec(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("oyun.fxml"));
        Stage stage=new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void nasilOynanirMenusu(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("nasilOynanir.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void cikisYap(ActionEvent event)throws IOException{
        Platform.exit();
        System.exit(0);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
