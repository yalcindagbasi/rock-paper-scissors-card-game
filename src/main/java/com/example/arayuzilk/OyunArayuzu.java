package com.example.arayuzilk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class OyunArayuzu {
    static int oyuncu1kalan=5;
    static int oyuncu2kalan=5;
    public Label suAnkiHamle;
    public Label labelSkorOyuncu2;
    public Label labelSkorOyuncu1;
    int hamle;
    boolean oyunbitti=false;
    public Pane sagPanel0ikon;
    public Label sagPanel0Nesne;
    public Button sagPanel0Butonu;
    public Pane sagPanel1ikon;
    public Label sagPanel1Nesne;
    public Button sagPanel1Butonu;
    public Pane sagPanel2ikon;
    public Label sagPanel2Nesne;
    public Button sagPanel2Butonu;
    public Pane sagPanel3ikon;
    public Label sagPanel3Nesne;
    public Button sagPanel3Butonu;
    public Pane sagPanel4ikon;
    public Label sagPanel4Nesne;
    public Button sagPanel4Butonu;
    public Label vsAltNesne;
    public Label vsAltDayaniklilik;
    public Label vsAltDeneyim;
    public Pane vsPanelAlt;
    public Label labelKazanan;
    public Pane sagPanel0;
    public Pane sagPanel1;
    public Pane sagPanel2;
    public Pane sagPanel3;
    public Pane sagPanel4;
    int vsUstPanelIndex=0;
    int vsAltPanelIndex=0;

    public Pane solPanel1;


    public Label solPanel2Nesne;

    public Button solPanel2Butonu;
    public Pane solPanel0ikon;
    public Label solPanel0Nesne;
    public Pane solPanel0;
    public Button solPanel0Butonu;
    public Pane solPanel2;
    public Pane solPanel2ikon;
    public Pane solPanel3;
    public Pane solPanel3ikon;
    public Label solPanel3Nesne;
    public Button solPanel3Butonu;
    public Pane solPanel4;
    public Pane solPanel4ikon;
    public Label solPanel4Nesne;
    public Button solPanel4Butonu;
    public AnchorPane anaPanel;

    public Button solPanel1Butonu;
    public Pane solPanel1ikon;
    public Label vsUstDayaniklilik;
    public Label vsUstDeneyim;
    public Label vsUstNesne;
    public Pane vsPanelUst;

    @FXML
    public void initialize()//İlk bu metot çalışır.
    {
        Oyun game= new Oyun();
        oyunTipiComboBox.getSelectionModel().selectFirst();
        hamleSayisiAlani.setText("10");
        labelSayiHatasi.setText("(İdeal hamle sayısı 40'tır.)");
        sagPanel0.setVisible(false);
        solPanel0.setVisible(false);
        sagPanel1.setVisible(false);
        solPanel1.setVisible(false);
        solPanel2.setVisible(false);
        sagPanel2.setVisible(false);
        sagPanel3.setVisible(false);
        solPanel3.setVisible(false);
        sagPanel4.setVisible(false);
        solPanel4.setVisible(false);
        oynaButonu.setDisable(true);

    }
    public TextField hamleSayisiAlani;
    public ComboBox oyunTipiComboBox;
    public Label solPanel1Nesne;
    public Button oynaButonu;

    public Pane oyunPanel;
    public Button oyunaBaslaButonu;
    public Label label1deneme;
    public Label labelSayiHatasi;


    public boolean hamleSayisiGirdisiKontrol(){
        try {
            int hamlesayisi=Integer.parseInt(hamleSayisiAlani.getText());
            labelSayiHatasi.setText("");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("hamleSayisiAlani'na sayi olmayan bir değer girildi.");
            labelSayiHatasi.setText("Lütfen bir sayı girin.");
            return false;
        }
    }
    public void solTumPanelAyarla()
    {
        solPanel1Ayarla();
        solPanel0Ayarla();
        solPanel2Ayarla();
        solPanel3Ayarla();
        solPanel4Ayarla();
    }
    public void sagTumPanelAyarla()
    {
        sagPanel0Ayarla();
        sagPanel1Ayarla();
        sagPanel2Ayarla();
        sagPanel3Ayarla();
        sagPanel4Ayarla();
    }
    public void solPanel0Ayarla()
    {
        if(oyuncu1.nesneList.get(0).getClass().getSimpleName().equals("Bos"))
        {
            solPanel0.setVisible(false);
        }
        solPanel0Nesne.setText(oyuncu1.nesneList.get(0).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu1.nesneList.get(0).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu1.nesneList.get(0).getDeneyim()));
        solPanel0ikon.setEffect(new ImageInput(oyuncu1.nesneList.get(0).getIkon()));
    }
    public void solPanel1Ayarla()
    {
        if(oyuncu1.nesneList.get(1).getClass().getSimpleName().equals("Bos"))
        {
           solPanel1.setVisible(false);

        }
        solPanel1Nesne.setText(oyuncu1.nesneList.get(1).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu1.nesneList.get(1).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu1.nesneList.get(1).getDeneyim()));


        solPanel1ikon.setEffect(new ImageInput(oyuncu1.nesneList.get(1).getIkon()));

    }
    public void solPanel2Ayarla()
    {
        if(oyuncu1.nesneList.get(2).getClass().getSimpleName().equals("Bos"))
        {
            solPanel2.setVisible(false);

        }
        solPanel2Nesne.setText(oyuncu1.nesneList.get(2).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu1.nesneList.get(2).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu1.nesneList.get(2).getDeneyim()));


        solPanel2ikon.setEffect(new ImageInput(oyuncu1.nesneList.get(2).getIkon()));
    }
    public void solPanel3Ayarla()
    {
        if(oyuncu1.nesneList.get(3).getClass().getSimpleName().equals("Bos"))
        {
            solPanel3.setVisible(false);

        }
        solPanel3Nesne.setText(oyuncu1.nesneList.get(3).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu1.nesneList.get(3).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu1.nesneList.get(3).getDeneyim()));


        solPanel3ikon.setEffect(new ImageInput(oyuncu1.nesneList.get(3).getIkon()));
    }
    public void solPanel4Ayarla()
    {
        if(oyuncu1.nesneList.get(4).getClass().getSimpleName().equals("Bos"))
        {
            solPanel4.setVisible(false);

        }
        solPanel4Nesne.setText(oyuncu1.nesneList.get(4).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu1.nesneList.get(4).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu1.nesneList.get(4).getDeneyim()));

        solPanel4ikon.setEffect(new ImageInput(oyuncu1.nesneList.get(4).getIkon()));
    }
    public void sagPanel0Ayarla()
    {
        if(oyuncu2.nesneList.get(0).getClass().getSimpleName().equals("Bos"))
        {
            sagPanel0.setVisible(false);

        }
        else{
            sagPanel0Nesne.setText(oyuncu2.nesneList.get(0).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu2.nesneList.get(0).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu2.nesneList.get(0).getDeneyim()));
            sagPanel0ikon.setEffect(new ImageInput(oyuncu2.nesneList.get(0).getIkon()));
        }

    }
    public void sagPanel1Ayarla()
    {
        if(oyuncu2.nesneList.get(1).getClass().getSimpleName().equals("Bos"))
        {
            sagPanel1.setVisible(false);

        }
        else{
            sagPanel1Nesne.setText(oyuncu2.nesneList.get(1).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu2.nesneList.get(1).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu2.nesneList.get(1).getDeneyim()));
            sagPanel1ikon.setEffect(new ImageInput(oyuncu2.nesneList.get(1).getIkon()));
        }

    }
    public void sagPanel2Ayarla()
    {
        if(oyuncu2.nesneList.get(2).getClass().getSimpleName().equals("Bos"))
        {
            sagPanel2.setVisible(false);

        }
        else{
            sagPanel2Nesne.setText(oyuncu2.nesneList.get(2).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu2.nesneList.get(2).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu2.nesneList.get(2).getDeneyim()));
            sagPanel2ikon.setEffect(new ImageInput(oyuncu2.nesneList.get(2).getIkon()));
        }

    }
    public void sagPanel3Ayarla()
    {
        if(oyuncu2.nesneList.get(3).getClass().getSimpleName().equals("Bos"))
        {
            sagPanel3.setVisible(false);

        }
        else{
            sagPanel3Nesne.setText(oyuncu2.nesneList.get(3).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu2.nesneList.get(3).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu2.nesneList.get(3).getDeneyim()));
            sagPanel3ikon.setEffect(new ImageInput(oyuncu2.nesneList.get(3).getIkon()));
        }

    }
    public void sagPanel4Ayarla()
    {
        if(oyuncu2.nesneList.get(4).getClass().getSimpleName().equals("Bos"))
        {
            sagPanel4.setVisible(false);

        }
        else{
            sagPanel4Nesne.setText(oyuncu2.nesneList.get(4).getClass().getSimpleName()+"\nDayanıklılık:"+ String.valueOf(oyuncu2.nesneList.get(4).getDayaniklilik())+"\nDeneyim:" + String.valueOf(oyuncu2.nesneList.get(1).getDeneyim()));
            sagPanel4ikon.setEffect(new ImageInput(oyuncu2.nesneList.get(4).getIkon()));
        }

    }
    public void solPanel0Butonu(){
        vsPanelUst.setEffect(new ImageInput(oyuncu1.nesneList.get(0).getOrtaIkon()));
        vsUstDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu1.nesneList.get(0).getDayaniklilik()));
        vsUstDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu1.nesneList.get(0).getDeneyim()));
        vsUstNesne.setText(oyuncu1.nesneList.get(0).getClass().getSimpleName());
        vsUstPanelIndex=0;
    }
    public void solPanel1Butonu(){
        vsPanelUst.setEffect(new ImageInput(oyuncu1.nesneList.get(1).getOrtaIkon()));
        vsUstDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu1.nesneList.get(1).getDayaniklilik()));
        vsUstDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu1.nesneList.get(1).getDeneyim()));
        vsUstNesne.setText(oyuncu1.nesneList.get(1).getClass().getSimpleName());
        vsUstPanelIndex=1;
    }
    public void solPanel2Butonu(){
        vsPanelUst.setEffect(new ImageInput(oyuncu1.nesneList.get(2).getOrtaIkon()));
        vsUstDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu1.nesneList.get(2).getDayaniklilik()));
        vsUstDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu1.nesneList.get(2).getDeneyim()));
        vsUstNesne.setText(oyuncu1.nesneList.get(2).getClass().getSimpleName());
        vsUstPanelIndex=2;
    }
    public void solPanel3Butonu(){
        vsPanelUst.setEffect(new ImageInput(oyuncu1.nesneList.get(3).getOrtaIkon()));
        vsUstDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu1.nesneList.get(3).getDayaniklilik()));
        vsUstDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu1.nesneList.get(3).getDeneyim()));
        vsUstNesne.setText(oyuncu1.nesneList.get(3).getClass().getSimpleName());
        vsUstPanelIndex=3;
    }
    public void solPanel4Butonu(){
        vsPanelUst.setEffect(new ImageInput(oyuncu1.nesneList.get(4).getOrtaIkon()));
        vsUstDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu1.nesneList.get(4).getDayaniklilik()));
        vsUstDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu1.nesneList.get(4).getDeneyim()));
        vsUstNesne.setText(oyuncu1.nesneList.get(4).getClass().getSimpleName());
        vsUstPanelIndex=4;
    }
    public void sagPanel0Butonu(){
        vsPanelAlt.setEffect(new ImageInput(oyuncu2.nesneList.get(0).getOrtaIkon()));
        vsAltDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu2.nesneList.get(0).getDayaniklilik()));
        vsAltDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu2.nesneList.get(0).getDeneyim()));
        vsAltNesne.setText(oyuncu2.nesneList.get(0).getClass().getSimpleName());
        vsAltPanelIndex=0;
    }
    public void sagPanel1Butonu(){
        vsPanelAlt.setEffect(new ImageInput(oyuncu2.nesneList.get(1).getOrtaIkon()));
        vsAltDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu2.nesneList.get(1).getDayaniklilik()));
        vsAltDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu2.nesneList.get(1).getDeneyim()));
        vsAltNesne.setText(oyuncu2.nesneList.get(1).getClass().getSimpleName());
        vsAltPanelIndex=1;
    }
    public void sagPanel2Butonu(){
        vsPanelAlt.setEffect(new ImageInput(oyuncu2.nesneList.get(2).getOrtaIkon()));
        vsAltDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu2.nesneList.get(2).getDayaniklilik()));
        vsAltDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu2.nesneList.get(2).getDeneyim()));
        vsAltNesne.setText(oyuncu2.nesneList.get(2).getClass().getSimpleName());
        vsAltPanelIndex=2;
    }
    public void sagPanel3Butonu(){
        vsPanelAlt.setEffect(new ImageInput(oyuncu2.nesneList.get(3).getOrtaIkon()));
        vsAltDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu2.nesneList.get(3).getDayaniklilik()));
        vsAltDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu2.nesneList.get(3).getDeneyim()));
        vsAltNesne.setText(oyuncu2.nesneList.get(3).getClass().getSimpleName());
        vsAltPanelIndex=3;
    }
    public void sagPanel4Butonu(){
        vsPanelAlt.setEffect(new ImageInput(oyuncu2.nesneList.get(4).getOrtaIkon()));
        vsAltDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu2.nesneList.get(4).getDayaniklilik()));
        vsAltDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu2.nesneList.get(4).getDeneyim()));
        vsAltNesne.setText(oyuncu2.nesneList.get(4).getClass().getSimpleName());
        vsAltPanelIndex=4;
    }
    public void vsPanelUstAyarla() throws InterruptedException {

        while(oyuncu1.nesneList.get(vsUstPanelIndex).getClass().getSimpleName().equals("Bos"))
        {
            vsUstPanelIndex = Oyun.random.nextInt(5);
        }

        vsPanelUst.setEffect(new ImageInput(oyuncu1.nesneList.get(vsUstPanelIndex).getOrtaIkon()));
        vsUstDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu1.nesneList.get(vsUstPanelIndex).getDayaniklilik()));
        vsUstDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu1.nesneList.get(vsUstPanelIndex).getDeneyim()));
        vsUstNesne.setText(oyuncu1.nesneList.get(vsUstPanelIndex).getClass().getSimpleName());

    }
    public void vsPanelAltAyarla() throws InterruptedException {
            while(oyuncu2.nesneList.get(vsAltPanelIndex).getClass().getSimpleName().equals("Bos"))
            {
                vsAltPanelIndex = Oyun.random.nextInt(5);
            }

        vsPanelAlt.setEffect(new ImageInput(oyuncu2.nesneList.get(vsAltPanelIndex).getOrtaIkon()));
        vsAltDayaniklilik.setText("Dayanıklılık\n"+String.valueOf(oyuncu2.nesneList.get(vsAltPanelIndex).getDayaniklilik()));
        vsAltDeneyim.setText("Deneyim\n"+String.valueOf(oyuncu2.nesneList.get(vsAltPanelIndex).getDeneyim()));
        vsAltNesne.setText(oyuncu2.nesneList.get(vsAltPanelIndex).getClass().getSimpleName());

    }
    public void skorHesapla(Oyun.Oyuncu oyuncu)
    {
        oyuncu.setSkor(0);
        for(int i=0;i<5;i++)
        {
            oyuncu.setSkor((int) (oyuncu.getSkor()+oyuncu.nesneList.get(i).getDayaniklilik()));
        }
    }
    public void hamleBitti()
    {
        labelSkorOyuncu1.setText("Skor: "+ oyuncu1.getSkor());
        labelSkorOyuncu2.setText("Skor: "+ oyuncu2.getSkor());
        if(oyuncu1.getSkor()==oyuncu2.getSkor())
        {
            System.out.println("Hamle Tükendi! Oyun Berabere!");
            labelKazanan.setText("Hamle Kalmadı. Oyun Berabere!");
            oynaButonu.setDisable(true);
        }
        else if(oyuncu1.getSkor()>oyuncu2.getSkor())
        {
            System.out.println("Hamle Tükendi! oyuncu1 kazandı!");
            labelKazanan.setText("Hamle Kalmadı. Oyuncu1 kazandı!");
            oynaButonu.setDisable(true);

        }
        else
        {
            System.out.println("Hamle Tükendi! oyuncu2 kazandı!");
            labelKazanan.setText("Hamle Kalmadı. Oyuncu2 kazandı!");
            oynaButonu.setDisable(true);

        }
    }
    public void oynaButonu() throws InterruptedException {
        System.out.println(hamle+". hamle");
        suAnkiHamle.setText("Hamle: "+ hamle);

        if(oyunTipiComboBox.getSelectionModel().getSelectedIndex()==0)
        {
            hamle++;
            vsAltPanelIndex=oyuncu2.nesneSec(true);

            Oyun.karsilasma(oyuncu1,vsUstPanelIndex,oyuncu2,vsAltPanelIndex);
            System.out.println();
            solTumPanelAyarla();
            sagTumPanelAyarla();


        }
        else
        {
            Oyun.karsilasma(oyuncu1,vsUstPanelIndex,oyuncu2,vsAltPanelIndex);
            solTumPanelAyarla();
            sagTumPanelAyarla();

        }
        skorHesapla(oyuncu1);
        skorHesapla(oyuncu2);
        labelSkorOyuncu1.setText("Skor: "+ oyuncu1.getSkor());
        labelSkorOyuncu2.setText("Skor: "+ oyuncu2.getSkor());
        if(hamle==Integer.parseInt(hamleSayisiAlani.getText()))
        {
            hamleBitti();
        }
        if(oyuncu1kalan==0 && oyuncu2kalan==0)
        {
            System.out.println("Oyun Berabere Bitti!");
            labelKazanan.setText("Oyun Berabere Bitti!");
            oyunbitti=true;
            oynaButonu.setDisable(true);
        } else if (oyuncu2kalan==0) {
            System.out.println("Oyuncu1 Kazandı!");
            labelKazanan.setText("Oyuncu1 Kazandı!");
            oyunbitti=true;
            oynaButonu.setDisable(true);
        } else if (oyuncu1kalan==0) {
            System.out.println("Oyuncu2 Kazandı!");
            labelKazanan.setText("Oyuncu2 Kazandı!");
            oyunbitti=true;
            oynaButonu.setDisable(true);
        }
        else {
            vsPanelUstAyarla();
            vsPanelAltAyarla();
        }
        switch(vsAltPanelIndex)
        {
            case 0:
                sagPanel0.setVisible(true);
                break;
            case 1:
                sagPanel1.setVisible(true);
                break;
            case 2:
                sagPanel2.setVisible(true);
                break;
            case 3:
                sagPanel3.setVisible(true);
                break;
            case 4:
                sagPanel4.setVisible(true);
                break;

        }



    }

    public void baslangicPanelAyar()
    {
        solTumPanelAyarla();
        sagTumPanelAyarla();
        sagPanel0.setVisible(false);
        solPanel0.setVisible(true);
        sagPanel1.setVisible(false);
        solPanel1.setVisible(true);
        solPanel2.setVisible(true);
        sagPanel2.setVisible(false);
        sagPanel3.setVisible(false);
        solPanel3.setVisible(true);
        sagPanel4.setVisible(false);
        solPanel4.setVisible(true);
        oynaButonu.setDisable(false);
    }
    static Oyun.Oyuncu oyuncu1= new Oyun.Oyuncu();
    static Oyun.Oyuncu oyuncu2= new Oyun.Oyuncu();
    public void OyunaBaslaButonu() throws IOException, InterruptedException {
        vsUstPanelIndex=0;
        vsAltPanelIndex=0;
        labelKazanan.setText(" ");
        oyuncu1kalan=5;
        oyuncu2kalan=5;
        oyunbitti=false;
        hamle=1;
        if(hamleSayisiGirdisiKontrol())
        {
            int hamlesayisi=Integer.parseInt(hamleSayisiAlani.getText());
            System.out.println("Max Hamle Sayısı: "+hamlesayisi);
            String oyuntipi= oyunTipiComboBox.getValue().toString();

            System.out.println("Oyun tipi: "+ oyuntipi);
            if(oyunTipiComboBox.getSelectionModel().getSelectedIndex()==0)
            {
                Oyun.main(0);
                oyuncu1= Oyun.oyuncu;
                oyuncu2= Oyun.bilgisayar1;
                baslangicPanelAyar();
                sagPanel0Butonu.setDisable(true);
                sagPanel1Butonu.setDisable(true);
                sagPanel2Butonu.setDisable(true);
                sagPanel3Butonu.setDisable(true);
                sagPanel4Butonu.setDisable(true);
            }
            else if(oyunTipiComboBox.getSelectionModel().getSelectedIndex()==1)
            {
                Oyun.main(1);
                oyuncu1= Oyun.bilgisayar1;
                oyuncu2= Oyun.bilgisayar2;
                baslangicPanelAyar();
                for(hamle=1;hamle<=hamlesayisi;hamle++)
                {

                    if(oyunbitti)
                    {
                        break;

                    }
                    vsUstPanelIndex= oyuncu1.nesneSec(true);
                    vsAltPanelIndex= oyuncu2.nesneSec(true);
                    vsPanelUstAyarla();
                    vsPanelAltAyarla();
                    oynaButonu();


                }
            }
        }





    }

}