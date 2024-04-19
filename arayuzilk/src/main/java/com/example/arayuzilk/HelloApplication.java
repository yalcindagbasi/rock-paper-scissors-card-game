package com.example.arayuzilk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private ComboBox<String> comboBox;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("arayuz.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200 , 900);
        stage.setTitle("Tas-Kagit-Makas Oyunu");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public static void secimEkrani() throws IOException{
        Stage stage1= new Stage();
        FXMLLoader secimekrani = new FXMLLoader(HelloApplication.class.getResource("secimekrani.fxml"));
        Scene secimscene = new Scene(secimekrani.load(), 600, 300);
        stage1.setTitle("Seçim");
        stage1.setResizable(false);
        stage1.setScene(secimscene);
        stage1.showAndWait();
        SecimEkraniController.setSayac(0);
    }

    public void oyunuBaslat(Stage stage) throws IOException {
        System.out.println("start() çalışmaya başladı");
        FXMLLoader oyunekrani = new FXMLLoader(HelloApplication.class.getResource("oyun.fxml"));
        Scene oyunscene = new Scene(oyunekrani.load(), 800, 600);
        stage.setTitle("Taş,Kağıt&Makas");
        stage.setResizable(false);
        stage.setScene(oyunscene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}