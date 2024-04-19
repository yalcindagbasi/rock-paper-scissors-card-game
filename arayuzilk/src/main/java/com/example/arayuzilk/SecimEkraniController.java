package com.example.arayuzilk;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SecimEkraniController {
    @FXML
    private static int sayac=0;
    public Pane tasPanel;
    public Pane makasPanel;
    public Pane kagitPanel;

    Oyun.Oyuncu oyuncu= new Oyun.Oyuncu();
    public static void setSayac(int sayac) {
        SecimEkraniController.sayac = sayac;
    }

    public Button tasButonu;
    public Button kagitButonu;
    public Button makasButonu;
    public void initialize()
    {

        Image tasimg= new Image(getClass().getResource("/Tasorta.png").toExternalForm());
        Image kagitimg= new Image(getClass().getResource("/Kagitorta.png").toExternalForm());
        Image makasimg= new Image(getClass().getResource("/Makasorta.png").toExternalForm());
        tasPanel.setEffect(new ImageInput(tasimg));
        kagitPanel.setEffect(new ImageInput(kagitimg));
        makasPanel.setEffect((new ImageInput(makasimg)));

        if(sayac==5)
        {
            Stage stage = (Stage) tasButonu.getScene().getWindow();
            stage.close();
            System.out.println("Seçim tamamlandı.");
        }
        sayac++;
    }
    public void TasSecimi()
    {
        Oyun.oyuncu.NesneListeOlustur(false,1);
        System.out.println("Oyuncu Taş Seçti");
        System.out.println(Oyun.oyuncu.nesneList.size());
        initialize();
    }
    public void KagitSecimi()
    {
        Oyun.oyuncu.NesneListeOlustur(false,2);
        System.out.println("Oyuncu Kağıt Seçti");
        System.out.println(Oyun.oyuncu.nesneList.size());
        initialize();
    }
    public void MakasSecimi()
    {
        Oyun.oyuncu.NesneListeOlustur(false,3);
        System.out.println("Oyuncu Makas Seçti");
        System.out.println(Oyun.oyuncu.nesneList.size());
        initialize();
    }
}
