package com.example.arayuzilk;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.*;

public class Oyun {
    static Random random = new Random();

    static Oyuncu oyuncu= new Kullanici();
    static Bilgisayar bilgisayar1 = new Bilgisayar();
    static Bilgisayar bilgisayar2= new Bilgisayar();

    static Tas tastemp= new Tas();
    static Kagit kagittemp= new Kagit();
    static Makas makastemp= new Makas();
    static AgirTas agirtastemp= new AgirTas();
    static OzelKagit ozelkagittemp= new OzelKagit();
    static UstaMakas ustamakastemp= new UstaMakas();
    static class Oyuncu {

        int tassayac = 0, kagitsayac = 0, makassayac = 0;
        Scanner scan = new Scanner(System.in);
        String[] nesneliste = new String[5];
        List<Nesne> nesneList = new ArrayList<Nesne>();
        Tas[] tas = new Tas[5];
        Kagit[] kagit = new Kagit[5];
        Makas[] makas = new Makas[5];
        private String oyuncuid;
        private String oyuncuadi;
        private int skor;

        public void setOyuncuadi(String oyuncuadi) {
            this.oyuncuadi = oyuncuadi;
        }

        public String getOyuncuadi() {
            return oyuncuadi;
        }

        public void setSkor(int skor) {
            this.skor = skor;
        }

        public int getSkor() {
            return skor;
        }

        public void nesneListesi() {
            for (int i = 0; i < 5; i++) {
                System.out.println(nesneliste[i]);

            }
        }
        static public int sayac=0;
        public void NesneListeOlustur(boolean bilgisayarmi,int secim) {

            if (!bilgisayarmi) {

                int tassayac = 0, kagitsayac = 0, makassayac = 0;


                switch (secim) {
                    case 1:
                        tas[tassayac] = new Tas();
                        nesneliste[sayac] = "tas";
                        nesneList.add(tas[tassayac]);
                        tassayac++;
                        break;
                    case 2:
                        kagit[kagitsayac] = new Kagit();
                        nesneliste[sayac] = "kagit";
                        nesneList.add(kagit[kagitsayac]);
                        kagitsayac++;
                        break;
                    case 3:
                        makas[makassayac] = new Makas();
                        nesneliste[sayac] = "makas";
                        nesneList.add(makas[makassayac]);
                        makassayac++;
                        break;
                }
                sayac++;

            } else {
                int tassayac = 0, kagitsayac = 0, makassayac = 0;
                Random ran = new Random();
                for (int i = 0; i < 5; i++) {
                    int x = ran.nextInt(3) + 1;
                    switch (x) {
                        case 1:
                            tas[tassayac] = new Tas();
                            nesneliste[i] = "tas";
                            nesneList.add(tas[tassayac]);
                            tassayac++;
                            break;
                        case 2:
                            kagit[kagitsayac] = new Kagit();
                            nesneliste[i] = "kagit";
                            nesneList.add(kagit[kagitsayac]);
                            kagitsayac++;
                            break;
                        case 3:
                            makas[makassayac] = new Makas();
                            nesneliste[i] = "makas";
                            nesneList.add(makas[makassayac]);
                            makassayac++;
                            break;
                    }
                }
            }
        }

        public int skorGoster() {
            return skor;
        }

        public int nesneSec(boolean bilgisayarmi) {
            if (!bilgisayarmi) {
                System.out.println("Birini seçiniz:");
                for (int i = 0; i < 5; i++) {
                    System.out.println(nesneliste[i]);
                }
                int index=scan.nextInt()-1;
                return index;
            } else {
                Random ran = new Random();
                int x= ran.nextInt(5);

                return x;
            }
        }
        public Oyuncu()
        {
            this.oyuncuid="oyuncu";
            this.oyuncuadi="Oyuncu";
            this.skor=0;
        }
        public Oyuncu(String oyuncuid,String oyuncuadi,int skor)
        {
            this.oyuncuid=oyuncuid;
            this.oyuncuadi=oyuncuadi;
            this.skor=skor;
        }
    }
    static class Bilgisayar extends Oyuncu{

        public Bilgisayar()
        {
            super("bilgisayar","bilgisayar",0);
        }
        public Bilgisayar(String oyuncuid, String oyuncuadi, int skor) {

            super(oyuncuid, oyuncuadi, skor);
        }
    }
    static class Kullanici extends Oyuncu{
        public Kullanici()
        {
            super("Oyuncu1","Oyuncu",0);
        }
        public Kullanici(String oyuncuid, String oyuncuadi, int skor) {

            super(oyuncuid, oyuncuadi, skor);
        }

    }









    abstract static class Nesne{
        float a=0.2f;

        private float dayaniklilik;

        public float getDayaniklilik() {
            return dayaniklilik;
        }

        public void setDayaniklilik(float dayaniklilik) {
            this.dayaniklilik = dayaniklilik;
        }

        private int deneyim;

        public int getDeneyim() {
            return deneyim;
        }

        public void setDeneyim(int deneyim) {
            this.deneyim = deneyim;
        }
        public Nesne()
        {
            this.dayaniklilik=20;
            this.deneyim=0;
        }

        public Nesne(float dayaniklilik, int deneyim)
        {
            this.dayaniklilik=dayaniklilik;
            this.deneyim=deneyim;
        }
        abstract public Image getIkon();

        abstract public Image getOrtaIkon();

        abstract public float etkiHesapla();


        public abstract float etkiHesapla(Tas tas, Nesne nesne);

        public abstract float etkiHesapla(Kagit kagit, Nesne nesne);

        public abstract float etkiHesapla(Makas makas, Nesne nesne);
        public abstract float etkiHesapla(AgirTas tas, Nesne nesne);
        public abstract float etkiHesapla(OzelKagit kagit, Nesne nesne);
        public abstract float etkiHesapla(UstaMakas makas, Nesne nesne);
    }
    static class Tas extends Nesne{
        private float katilik;

        public float getKatilik() {
            return katilik;
        }

        public void setKatilik(float katilik) {
            this.katilik = katilik;
        }
        public Tas()
        {
            this.katilik=2;
        }

        @Override
        public float etkiHesapla() {
            return 0;
        }

        public Tas(float katilik) {
            super(20, 0);

            this.katilik = katilik;
        }
        Image tasikon= new Image(getClass().getResource("/Tasmini.png").toExternalForm());
        Image tasortaikon= new Image(getClass().getResource("/Tasorta.png").toExternalForm());
        @Override
        public Image getIkon(){
            return tasikon;
        }
        @Override
        public Image getOrtaIkon(){
            return tasortaikon;
        }
        @Override
        public float etkiHesapla(Tas tas,Nesne nesne) {
            float tas_etkisi = 0;
            switch (nesne.getClass().getSimpleName()) {
                case "Tas":
                    tastemp=(Tas)nesne;
                    tas_etkisi= tas.getKatilik() /((1-a)* tastemp.getKatilik());
                    return tas_etkisi;
                case "Kagit":
                    kagittemp=(Kagit) nesne;
                    tas_etkisi= tas.getKatilik() /((1-a)* kagittemp.getNufuz());
                    return tas_etkisi;
                case "Makas":
                    makastemp=(Makas)nesne;
                    tas_etkisi= tas.getKatilik() /((a)* makastemp.getKeskinlik());
                    return tas_etkisi;
                case "AgirTas":
                    agirtastemp=(AgirTas) nesne;
                    tas_etkisi= tas.getKatilik() /((1-a)* agirtastemp.getKatilik()*agirtastemp.getSicaklik());
                    return tas_etkisi;
                case "OzelKagit":
                    ozelkagittemp=(OzelKagit)nesne;
                    tas_etkisi= tas.getKatilik() /((1-a)* ozelkagittemp.getNufuz()*ozelkagittemp.getKalinlik());
                    return tas_etkisi;
                case "UstaMakas":
                    ustamakastemp=(UstaMakas)nesne;
                    tas_etkisi= tas.getKatilik() /((a)* ustamakastemp.getKeskinlik() *ustamakastemp.getDirenc());
                    return tas_etkisi;
            }
            return 0;
        }

        @Override
        public float etkiHesapla(Kagit kagit, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(Makas makas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(AgirTas tas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(OzelKagit kagit, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(UstaMakas makas, Nesne nesne) {
            return 0;
        }


    }
    static class AgirTas extends Tas{
        private float sicaklik;

        public float getSicaklik() {
            return sicaklik;
        }

        public void setSicaklik(float sicaklik) {
            this.sicaklik = sicaklik;
        }
        public AgirTas()
        {
            super(2);
            this.sicaklik=2;
        }
        public AgirTas(float sicaklik)
        {
            super(2);

            this.sicaklik=sicaklik;
        }
        @Override
        public float etkiHesapla(AgirTas tas,Nesne nesne) {
            float tas_etkisi = 0;
            switch (nesne.getClass().getSimpleName()) {
                case "Tas":
                    tastemp=(Tas)nesne;
                    tas_etkisi= (tas.getKatilik()*tas.getSicaklik()) /((1-a)* tastemp.getKatilik());
                    return tas_etkisi;
                case "Kagit":
                    kagittemp=(Kagit) nesne;
                    tas_etkisi= (tas.getKatilik()*tas.getSicaklik()) /((1-a)* kagittemp.getNufuz());
                    return tas_etkisi;
                case "Makas":
                    makastemp=(Makas)nesne;
                    tas_etkisi= (tas.getKatilik()*tas.getSicaklik()) /((a)* makastemp.getKeskinlik());
                    return tas_etkisi;
                case "AgirTas":
                    agirtastemp=(AgirTas) nesne;
                    tas_etkisi= (tas.getKatilik()*tas.getSicaklik()) /((1-a)* agirtastemp.getKatilik()*agirtastemp.getSicaklik());
                    return tas_etkisi;
                case "OzelKagit":
                    ozelkagittemp=(OzelKagit)nesne;
                    tas_etkisi= (tas.getKatilik()*tas.getSicaklik()) /((1-a)* ozelkagittemp.getNufuz()*ozelkagittemp.getKalinlik());
                    return tas_etkisi;
                case "UstaMakas":
                    ustamakastemp=(UstaMakas)nesne;
                    tas_etkisi= (tas.getKatilik()*tas.getSicaklik()) /((a)* ustamakastemp.getKeskinlik() *ustamakastemp.getDirenc());
                    return tas_etkisi;
            }
            return 0;
        }
    }
    static class Kagit extends Nesne{
        Image kagitikon= new Image(getClass().getResource("/Kagitmini.png").toExternalForm());
        Image kagitortaikon= new Image(getClass().getResource("/Kagitorta.png").toExternalForm());
        @Override
        public Image getIkon(){
            return kagitikon;
        }
        public Image getOrtaIkon(){
            return kagitortaikon;
        }

        float nufuz;
        public Kagit()
        {
            this.nufuz=2;
        }

        @Override
        public float etkiHesapla() {
            return 0;
        }

        @Override
        public float etkiHesapla(Tas tas, Nesne nesne) {
            return 0;
        }

        public Kagit(float nufuz)
        {
            super(20,0);
            this.nufuz=nufuz;
        }

        public float getNufuz() {
            return nufuz;
        }

        public void setNufuz(float nufuz) {
            this.nufuz = nufuz;
        }
        @Override
        public float etkiHesapla(Kagit kagit,Nesne nesne) {
            float kagit_etkisi = 0;
            switch (nesne.getClass().getSimpleName()) {
                case "Tas":
                    tastemp=(Tas)nesne;
                    kagit_etkisi= kagit.getNufuz() /((a)* tastemp.getKatilik());
                    return kagit_etkisi;
                case "Kagit":
                    kagittemp=(Kagit) nesne;
                    kagit_etkisi= kagit.getNufuz() /((1-a)* kagittemp.getNufuz());
                    return kagit_etkisi;
                case "Makas":
                    makastemp=(Makas)nesne;
                    kagit_etkisi= kagit.getNufuz() /((1-a)* makastemp.getKeskinlik());
                    return kagit_etkisi;
                case "AgirTas":
                    agirtastemp=(AgirTas) nesne;
                    kagit_etkisi= kagit.getNufuz() /((a)* agirtastemp.getKatilik()*agirtastemp.getSicaklik());
                    return kagit_etkisi;
                case "OzelKagit":
                    ozelkagittemp=(OzelKagit)nesne;
                    kagit_etkisi= kagit.getNufuz() /((1-a)* ozelkagittemp.getNufuz()*ozelkagittemp.getKalinlik());
                    return kagit_etkisi;
                case "UstaMakas":
                    ustamakastemp=(UstaMakas)nesne;
                    kagit_etkisi= kagit.getNufuz() /((1-a)* ustamakastemp.getKeskinlik() *ustamakastemp.getDirenc());
                    return kagit_etkisi;
            }
            return 0;
        }

        @Override
        public float etkiHesapla(Makas makas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(AgirTas tas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(OzelKagit kagit, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(UstaMakas makas, Nesne nesne) {
            return 0;
        }


    }
    static class OzelKagit extends Kagit{
        private float kalinlik;
        public OzelKagit(float kalinlik){
            super(2);
            this.kalinlik=kalinlik;
        }
        public OzelKagit()
        {
            super(2);
            this.kalinlik=2;
        }

        public float getKalinlik() {
            return kalinlik;
        }

        public void setKalinlik(float kalinlik) {
            this.kalinlik = kalinlik;
        }
        @Override
        public float etkiHesapla(OzelKagit kagit,Nesne nesne) {
            float kagit_etkisi = 0;
            switch (nesne.getClass().getSimpleName()) {
                case "Tas":
                    tastemp=(Tas)nesne;
                    kagit_etkisi= (kagit.getNufuz()*kagit.getKalinlik()) /((a)* tastemp.getKatilik());
                    return kagit_etkisi;
                case "Kagit":
                    kagittemp=(Kagit) nesne;
                    kagit_etkisi= (kagit.getNufuz()*kagit.getKalinlik()) /((1-a)* kagittemp.getNufuz());
                    return kagit_etkisi;
                case "Makas":
                    makastemp=(Makas)nesne;
                    kagit_etkisi= (kagit.getNufuz()*kagit.getKalinlik()) /((1-a)* makastemp.getKeskinlik());
                    return kagit_etkisi;
                case "AgirTas":
                    agirtastemp=(AgirTas) nesne;
                    kagit_etkisi= (kagit.getNufuz()*kagit.getKalinlik()) /((a)* agirtastemp.getKatilik()*agirtastemp.getSicaklik());
                    return kagit_etkisi;
                case "OzelKagit":
                    ozelkagittemp=(OzelKagit)nesne;
                    kagit_etkisi= (kagit.getNufuz()*kagit.getKalinlik()) /((1-a)* ozelkagittemp.getNufuz()*ozelkagittemp.getKalinlik());
                    return kagit_etkisi;
                case "UstaMakas":
                    ustamakastemp=(UstaMakas)nesne;
                    kagit_etkisi= (kagit.getNufuz()*kagit.getKalinlik()) /((1-a)* ustamakastemp.getKeskinlik() *ustamakastemp.getDirenc());
                    return kagit_etkisi;
            }
            return 0;
        }
    }
    static class Makas extends Nesne{
        private float keskinlik;
        public Makas()
        {
            this.keskinlik=2;
        }

        @Override
        public float etkiHesapla() {
            return 0;
        }

        @Override
        public float etkiHesapla(Tas tas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(Kagit kagit, Nesne nesne) {
            return 0;
        }

        public Makas(float keskinlik){
            super(20,0);
            this.keskinlik=keskinlik;
        }
        Image makasikon= new Image(getClass().getResource("/Makasmini.png").toExternalForm());
        Image makasortaikon= new Image(getClass().getResource("/Makasorta.png").toExternalForm());
        @Override
        public Image getIkon(){
            return makasikon;
        }
        public Image getOrtaIkon(){
            return makasortaikon;
        }

        public float getKeskinlik() {
            return keskinlik;
        }

        public void setKeskinlik(float keskinlik) {
            this.keskinlik = keskinlik;
        }
        @Override
        public float etkiHesapla(Makas makas,Nesne nesne) {
            float makas_etkisi = 0;
            switch (nesne.getClass().getSimpleName()) {
                case "Tas":
                    tastemp=(Tas)nesne;
                    makas_etkisi= makas.getKeskinlik() /((1-a)* tastemp.getKatilik());
                    return makas_etkisi;
                case "Kagit":
                    kagittemp=(Kagit) nesne;
                    makas_etkisi= makas.getKeskinlik() /((a)* kagittemp.getNufuz());
                    return makas_etkisi;
                case "Makas":
                    makastemp=(Makas)nesne;
                    makas_etkisi= makas.getKeskinlik() /((1-a)* makastemp.getKeskinlik());
                    return makas_etkisi;
                case "AgirTas":
                    agirtastemp=(AgirTas) nesne;
                    makas_etkisi= makas.getKeskinlik() /((1-a)* agirtastemp.getKatilik()*agirtastemp.getSicaklik());
                    return makas_etkisi;
                case "OzelKagit":
                    ozelkagittemp=(OzelKagit)nesne;
                    makas_etkisi= makas.getKeskinlik() /((a)* ozelkagittemp.getNufuz()*ozelkagittemp.getKalinlik());
                    return makas_etkisi;
                case "UstaMakas":
                    ustamakastemp=(UstaMakas)nesne;
                    makas_etkisi= makas.getKeskinlik() /((1-a)* ustamakastemp.getKeskinlik() *ustamakastemp.getDirenc());
                    return makas_etkisi;
            }
            return 0;
        }

        @Override
        public float etkiHesapla(AgirTas tas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(OzelKagit kagit, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(UstaMakas makas, Nesne nesne) {
            return 0;
        }


    }
    static class UstaMakas extends Makas{
        private float direnc;
        public UstaMakas()
        {
            super(2);
            this.direnc=2;
        }
        public UstaMakas(float direnc){
            super(2);
            this.direnc=direnc;
        }

        public float getDirenc() {
            return direnc;
        }


        public void setDirenc(float direnc) {
            this.direnc = direnc;
        }
        @Override
        public float etkiHesapla(UstaMakas makas,Nesne nesne) {
            float makas_etkisi = 0;
            switch (nesne.getClass().getSimpleName()) {
                case "Tas":
                    tastemp=(Tas)nesne;
                    makas_etkisi= (makas.getKeskinlik()*makas.getDirenc()) /((1-a)* tastemp.getKatilik());
                    return makas_etkisi;
                case "Kagit":
                    kagittemp=(Kagit) nesne;
                    makas_etkisi= (makas.getKeskinlik()*makas.getDirenc()) /((a)* kagittemp.getNufuz());
                    return makas_etkisi;
                case "Makas":
                    makastemp=(Makas)nesne;
                    makas_etkisi= (makas.getKeskinlik()*makas.getDirenc()) /((1-a)* makastemp.getKeskinlik());
                    return makas_etkisi;
                case "AgirTas":
                    agirtastemp=(AgirTas) nesne;
                    makas_etkisi= (makas.getKeskinlik()*makas.getDirenc()) /((1-a)* agirtastemp.getKatilik()*agirtastemp.getSicaklik());
                    return makas_etkisi;
                case "OzelKagit":
                    ozelkagittemp=(OzelKagit)nesne;
                    makas_etkisi= (makas.getKeskinlik()*makas.getDirenc()) /((a)* ozelkagittemp.getNufuz()*ozelkagittemp.getKalinlik());
                    return makas_etkisi;
                case "UstaMakas":
                    ustamakastemp=(UstaMakas)nesne;
                    makas_etkisi= (makas.getKeskinlik()*makas.getDirenc()) /((1-a)* ustamakastemp.getKeskinlik() *ustamakastemp.getDirenc());
                    return makas_etkisi;
            }
            return 0;
        }
    }
    static class Bos extends Nesne{


        @Override
        public Image getIkon() {
            return null;

        }

        @Override
        public Image getOrtaIkon() {
            return null;
        }

        @Override
        public float etkiHesapla() {
            return 0;
        }

        @Override
        public float etkiHesapla(Tas tas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(Kagit kagit, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(Makas makas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(AgirTas tas, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(OzelKagit kagit, Nesne nesne) {
            return 0;
        }

        @Override
        public float etkiHesapla(UstaMakas makas, Nesne nesne) {
            return 0;
        }
    }






    public static Nesne nesneBul(int index, Oyuncu oyuncu)
    {
        int say=0;
        switch(oyuncu.nesneliste[index])
        {
            case "tas":
                for(int i=0;i<index;i++)
                {
                    if(oyuncu.nesneliste[i].equals((String) "tas"))
                    {
                        say++;
                    }

                }

                return oyuncu.tas[say];
            case "kagit":
                for(int i=0;i<index;i++)
                {
                    if(oyuncu.nesneliste[i].equals((String) "kagit"))
                    {
                        say++;
                    }
                }

                return oyuncu.kagit[say];
            case "makas":
                for(int i=0;i<index;i++)
                {
                    if(oyuncu.nesneliste[i].equals((String) "makas"))
                    {
                        say++;
                    }

                }

                return oyuncu.makas[say];
        }
        return null;
    }


    public static void karsilasma(Oyuncu oyuncu1, int index1, Oyuncu oyuncu2, int index2) throws InterruptedException {

        Tas[] tas= new Tas[2];
        Kagit[] kagit= new Kagit[2];
        Makas[] makas= new Makas[2];
        AgirTas[] agirtas= new AgirTas[2];
        OzelKagit[] ozelkagit= new OzelKagit[2];
        UstaMakas[] ustamakas= new UstaMakas[2];
        Nesne[] nesneRef= new Nesne[2];
        int deneyimmax = 30;


        nesneRef[0]= oyuncu1.nesneList.get(index1);
        nesneRef[1]= oyuncu2.nesneList.get(index2);
        switch (nesneRef[0].getClass().getSimpleName())
        {
            case "Tas":
                tas[0]=(Tas) nesneRef[0];
                switch (nesneRef[1].getClass().getSimpleName())
                {
                    case "Tas":
                        tas[1]=(Tas) nesneRef[1];

                        tas[0].setDayaniklilik(tas[0].getDayaniklilik()-tas[1].etkiHesapla(tas[1],tas[0]));
                        tas[1].setDayaniklilik(tas[1].getDayaniklilik()-tas[0].etkiHesapla(tas[0],tas[1]));

                        oyuncu2.nesneList.set(index2,tas[1]);
                        break;
                    case "Kagit":
                        kagit[1]=(Kagit) nesneRef[1];
                        tas[0].setDayaniklilik(tas[0].getDayaniklilik()-kagit[1].etkiHesapla(kagit[1],tas[0]));
                        kagit[1].setDayaniklilik(kagit[1].getDayaniklilik()-tas[0].etkiHesapla(tas[0],kagit[1]));

                        oyuncu2.nesneList.set(index2,kagit[1]);
                        break;
                    case "Makas":
                        makas[1]=(Makas) nesneRef[1];
                        tas[0].setDayaniklilik(tas[0].getDayaniklilik()-makas[1].etkiHesapla(makas[1],tas[0]));
                        makas[1].setDayaniklilik(makas[1].getDayaniklilik()-tas[0].etkiHesapla(tas[0],makas[1]));

                        oyuncu2.nesneList.set(index2,makas[1]);
                        break;
                    case "AgirTas":
                        agirtas[1]=(AgirTas) nesneRef[1];
                        tas[0].setDayaniklilik(tas[0].getDayaniklilik()-agirtas[1].etkiHesapla(agirtas[1],tas[0]));
                        agirtas[1].setDayaniklilik(agirtas[1].getDayaniklilik()-tas[0].etkiHesapla(tas[0],agirtas[1]));

                        oyuncu2.nesneList.set(index2,agirtas[1]);
                        break;
                    case "OzelKagit":
                        ozelkagit[1]=(OzelKagit) nesneRef[1];
                        tas[0].setDayaniklilik(tas[0].getDayaniklilik()-ozelkagit[1].etkiHesapla(ozelkagit[1],tas[0]));
                        ozelkagit[1].setDayaniklilik(ozelkagit[1].getDayaniklilik()-tas[0].etkiHesapla(tas[0],ozelkagit[1]));

                        oyuncu2.nesneList.set(index2,ozelkagit[1]);
                        break;
                    case "UstaMakas":
                        ustamakas[1]=(UstaMakas) nesneRef[1];
                        tas[0].setDayaniklilik(tas[0].getDayaniklilik()-ustamakas[1].etkiHesapla(ustamakas[1],tas[0]));
                        ustamakas[1].setDayaniklilik(ustamakas[1].getDayaniklilik()-tas[0].etkiHesapla(tas[0],ustamakas[1]));

                        oyuncu2.nesneList.set(index2,ustamakas[1]);
                        break;
                }

                oyuncu1.nesneList.set(index1,tas[0]);
                break;
            case "Kagit":
                kagit[0]=(Kagit) nesneRef[0];
                switch (nesneRef[1].getClass().getSimpleName())
                {
                    case "Tas":
                        tas[1]=(Tas) nesneRef[1];
                        kagit[0].setDayaniklilik(kagit[0].getDayaniklilik()-tas[1].etkiHesapla(tas[1],kagit[0]));
                        tas[1].setDayaniklilik(tas[1].getDayaniklilik()-kagit[0].etkiHesapla(kagit[0],tas[1]));

                        oyuncu2.nesneList.set(index2,tas[1]);
                        break;
                    case "Kagit":
                        kagit[1]=(Kagit) nesneRef[1];
                        kagit[0].setDayaniklilik(kagit[0].getDayaniklilik()-kagit[1].etkiHesapla(kagit[1],kagit[0]));
                        kagit[1].setDayaniklilik(kagit[1].getDayaniklilik()-kagit[0].etkiHesapla(kagit[0],kagit[1]));

                        oyuncu2.nesneList.set(index2,kagit[1]);
                        break;

                    case "Makas":
                        makas[1]=(Makas) nesneRef[1];
                        kagit[0].setDayaniklilik(kagit[0].getDayaniklilik()-makas[1].etkiHesapla(makas[1],kagit[0]));
                        makas[1].setDayaniklilik(makas[1].getDayaniklilik()-kagit[0].etkiHesapla(kagit[0],makas[1]));

                        oyuncu2.nesneList.set(index2,makas[1]);
                        break;
                    case "AgirTas":
                        agirtas[1]=(AgirTas) nesneRef[1];
                        kagit[0].setDayaniklilik(kagit[0].getDayaniklilik()-agirtas[1].etkiHesapla(agirtas[1],kagit[0]));
                        agirtas[1].setDayaniklilik(agirtas[1].getDayaniklilik()-kagit[0].etkiHesapla(kagit[0],agirtas[1]));


                        oyuncu2.nesneList.set(index2,agirtas[1]);
                        break;
                    case "OzelKagit":
                        ozelkagit[1]=(OzelKagit) nesneRef[1];
                        kagit[0].setDayaniklilik(kagit[0].getDayaniklilik()-ozelkagit[1].etkiHesapla(ozelkagit[1],kagit[0]));
                        ozelkagit[1].setDayaniklilik(ozelkagit[1].getDayaniklilik()-kagit[0].etkiHesapla(kagit[0],ozelkagit[1]));

                        oyuncu2.nesneList.set(index2,ozelkagit[1]);
                        break;
                    case "UstaMakas":
                        ustamakas[1]=(UstaMakas) nesneRef[1];
                        kagit[0].setDayaniklilik(kagit[0].getDayaniklilik()-ustamakas[1].etkiHesapla(ustamakas[1],kagit[0]));
                        ustamakas[1].setDayaniklilik(ustamakas[1].getDayaniklilik()-kagit[0].etkiHesapla(kagit[0],ustamakas[1]));


                        oyuncu2.nesneList.set(index2,ustamakas[1]);
                        break;
                }
                oyuncu1.nesneList.set(index1,kagit[0]);
                break;
            case "Makas":
                makas[0]=(Makas) nesneRef[0];
                switch (nesneRef[1].getClass().getSimpleName())
                {
                    case "Tas":
                        tas[1]=(Tas) nesneRef[1];
                        makas[0].setDayaniklilik(makas[0].getDayaniklilik()-tas[1].etkiHesapla(tas[1],makas[0]));
                        tas[1].setDayaniklilik(tas[1].getDayaniklilik()-makas[0].etkiHesapla(makas[0],tas[1]));

                        oyuncu2.nesneList.set(index2,tas[1]);
                        break;
                    case "Kagit":
                        kagit[1]=(Kagit) nesneRef[1];
                        makas[0].setDayaniklilik(makas[0].getDayaniklilik()-kagit[1].etkiHesapla(kagit[1],makas[0]));
                        kagit[1].setDayaniklilik(kagit[1].getDayaniklilik()-makas[0].etkiHesapla(makas[0],kagit[1]));

                        oyuncu2.nesneList.set(index2,kagit[1]);
                        break;

                    case "Makas":
                        makas[1]=(Makas) nesneRef[1];
                        makas[0].setDayaniklilik(makas[0].getDayaniklilik()-makas[1].etkiHesapla(makas[1],makas[0]));
                        makas[1].setDayaniklilik(makas[1].getDayaniklilik()-makas[0].etkiHesapla(makas[0],makas[1]));

                        oyuncu2.nesneList.set(index2,makas[1]);
                        break;
                    case "AgirTas":
                        agirtas[1]=(AgirTas) nesneRef[1];
                        makas[0].setDayaniklilik(makas[0].getDayaniklilik()-agirtas[1].etkiHesapla(agirtas[1],makas[0]));
                        agirtas[1].setDayaniklilik(agirtas[1].getDayaniklilik()-makas[0].etkiHesapla(makas[0],agirtas[1]));

                        oyuncu2.nesneList.set(index2,agirtas[1]);
                        break;
                    case "OzelKagit":
                        ozelkagit[1]=(OzelKagit) nesneRef[1];
                        makas[0].setDayaniklilik(makas[0].getDayaniklilik()-ozelkagit[1].etkiHesapla(ozelkagit[1],makas[0]));
                        ozelkagit[1].setDayaniklilik(ozelkagit[1].getDayaniklilik()-makas[0].etkiHesapla(makas[0],ozelkagit[1]));

                        oyuncu2.nesneList.set(index2,ozelkagit[1]);
                        break;
                    case "UstaMakas":
                        ustamakas[1]=(UstaMakas) nesneRef[1];
                        makas[0].setDayaniklilik(makas[0].getDayaniklilik()-ustamakas[1].etkiHesapla(ustamakas[1],makas[0]));
                        ustamakas[1].setDayaniklilik(ustamakas[1].getDayaniklilik()-makas[0].etkiHesapla(makas[0],ustamakas[1]));

                        oyuncu2.nesneList.set(index2,ustamakas[1]);
                        break;
                }
                oyuncu1.nesneList.set(index1,makas[0]);
                break;
            case "AgirTas":
                agirtas[0]=(AgirTas) nesneRef[0];
                switch (nesneRef[1].getClass().getSimpleName())
                {
                    case "Tas":
                        tas[1]=(Tas) nesneRef[1];
                        agirtas[0].setDayaniklilik(agirtas[0].getDayaniklilik()-tas[1].etkiHesapla(tas[1],agirtas[0]));
                        tas[1].setDayaniklilik(tas[1].getDayaniklilik()-agirtas[0].etkiHesapla(agirtas[0],tas[1]));


                        oyuncu2.nesneList.set(index2,tas[1]);
                        break;
                    case "Kagit":
                        kagit[1]=(Kagit) nesneRef[1];
                        agirtas[0].setDayaniklilik(agirtas[0].getDayaniklilik()-kagit[1].etkiHesapla(kagit[1],agirtas[0]));
                        kagit[1].setDayaniklilik(kagit[1].getDayaniklilik()-agirtas[0].etkiHesapla(agirtas[0],kagit[1]));

                        oyuncu2.nesneList.set(index2,kagit[1]);
                        break;

                    case "Makas":
                        makas[1]=(Makas) nesneRef[1];
                        agirtas[0].setDayaniklilik(agirtas[0].getDayaniklilik()-makas[1].etkiHesapla(makas[1],agirtas[0]));
                        makas[1].setDayaniklilik(makas[1].getDayaniklilik()-agirtas[0].etkiHesapla(agirtas[0],makas[1]));

                        oyuncu2.nesneList.set(index2,makas[1]);
                        break;
                    case "AgirTas":
                        agirtas[1]=(AgirTas) nesneRef[1];
                        agirtas[0].setDayaniklilik(agirtas[0].getDayaniklilik()-agirtas[1].etkiHesapla(agirtas[1],agirtas[0]));
                        agirtas[1].setDayaniklilik(agirtas[1].getDayaniklilik()-agirtas[0].etkiHesapla(agirtas[0],agirtas[1]));

                        oyuncu2.nesneList.set(index2,agirtas[1]);
                        break;
                    case "OzelKagit":
                        ozelkagit[1]=(OzelKagit) nesneRef[1];
                        agirtas[0].setDayaniklilik(agirtas[0].getDayaniklilik()-ozelkagit[1].etkiHesapla(ozelkagit[1],agirtas[0]));
                        ozelkagit[1].setDayaniklilik(ozelkagit[1].getDayaniklilik()-agirtas[0].etkiHesapla(agirtas[0],ozelkagit[1]));
                        oyuncu2.nesneList.set(index2,ozelkagit[1]);
                        break;
                    case "UstaMakas":
                        ustamakas[1]=(UstaMakas) nesneRef[1];
                        agirtas[0].setDayaniklilik(agirtas[0].getDayaniklilik()-ustamakas[1].etkiHesapla(ustamakas[1],agirtas[0]));
                        ustamakas[1].setDayaniklilik(ustamakas[1].getDayaniklilik()-agirtas[0].etkiHesapla(agirtas[0],ustamakas[1]));
                        oyuncu2.nesneList.set(index2,ustamakas[1]);
                        break;
                }
                oyuncu1.nesneList.set(index1,agirtas[0]);
                break;
            case "OzelKagit":
                ozelkagit[0]=(OzelKagit) nesneRef[0];
                switch (nesneRef[1].getClass().getSimpleName())
                {
                    case "Tas":
                        tas[1]=(Tas) nesneRef[1];
                        ozelkagit[0].setDayaniklilik(ozelkagit[0].getDayaniklilik()-tas[1].etkiHesapla(tas[1],ozelkagit[0]));
                        tas[1].setDayaniklilik(tas[1].getDayaniklilik()-ozelkagit[0].etkiHesapla(ozelkagit[0],tas[1]));

                        oyuncu2.nesneList.set(index2,tas[1]);
                        break;
                    case "Kagit":
                        kagit[1]=(Kagit) nesneRef[1];
                        ozelkagit[0].setDayaniklilik(ozelkagit[0].getDayaniklilik()-kagit[1].etkiHesapla(kagit[1],ozelkagit[0]));
                        kagit[1].setDayaniklilik(kagit[1].getDayaniklilik()-ozelkagit[0].etkiHesapla(ozelkagit[0],kagit[1]));

                        oyuncu2.nesneList.set(index2,kagit[1]);
                        break;

                    case "Makas":
                        makas[1]=(Makas) nesneRef[1];
                        ozelkagit[0].setDayaniklilik(ozelkagit[0].getDayaniklilik()-makas[1].etkiHesapla(makas[1],ozelkagit[0]));
                        makas[1].setDayaniklilik(makas[1].getDayaniklilik()-ozelkagit[0].etkiHesapla(ozelkagit[0],makas[1]));

                        oyuncu2.nesneList.set(index2,makas[1]);
                        break;
                    case "AgirTas":
                        agirtas[1]=(AgirTas) nesneRef[1];
                        ozelkagit[0].setDayaniklilik(ozelkagit[0].getDayaniklilik()-agirtas[1].etkiHesapla(agirtas[1],ozelkagit[0]));
                        agirtas[1].setDayaniklilik(agirtas[1].getDayaniklilik()-ozelkagit[0].etkiHesapla(ozelkagit[0],agirtas[1]));
                        oyuncu2.nesneList.set(index2,agirtas[1]);
                        break;
                    case "OzelKagit":
                        ozelkagit[1]=(OzelKagit) nesneRef[1];
                        ozelkagit[0].setDayaniklilik(ozelkagit[0].getDayaniklilik()-ozelkagit[1].etkiHesapla(ozelkagit[1],ozelkagit[0]));
                        ozelkagit[1].setDayaniklilik(ozelkagit[1].getDayaniklilik()-ozelkagit[0].etkiHesapla(ozelkagit[0],ozelkagit[1]));
                        oyuncu2.nesneList.set(index2,ozelkagit[1]);
                        break;
                    case "UstaMakas":
                        ustamakas[1]=(UstaMakas) nesneRef[1];
                        ozelkagit[0].setDayaniklilik(ozelkagit[0].getDayaniklilik()-ustamakas[1].etkiHesapla(ustamakas[1],ozelkagit[0]));
                        ustamakas[1].setDayaniklilik(ustamakas[1].getDayaniklilik()-ozelkagit[0].etkiHesapla(ozelkagit[0],ustamakas[1]));

                        oyuncu2.nesneList.set(index2,ustamakas[1]);
                        break;
                }

                oyuncu1.nesneList.set(index1,ozelkagit[0]);
                break;
            case "UstaMakas":
                ustamakas[0]=(UstaMakas) nesneRef[0];
                switch (nesneRef[1].getClass().getSimpleName())
                {
                    case "Tas":
                        tas[1]=(Tas) nesneRef[1];
                        ustamakas[0].setDayaniklilik(ustamakas[0].getDayaniklilik()-tas[1].etkiHesapla(tas[1],ustamakas[0]));
                        tas[1].setDayaniklilik(tas[1].getDayaniklilik()-ustamakas[0].etkiHesapla(ustamakas[0],tas[1]));


                        oyuncu2.nesneList.set(index2,tas[1]);
                        break;
                    case "Kagit":
                        kagit[1]=(Kagit) nesneRef[1];
                        ustamakas[0].setDayaniklilik(ustamakas[0].getDayaniklilik()-kagit[1].etkiHesapla(kagit[1],ustamakas[0]));
                        kagit[1].setDayaniklilik(kagit[1].getDayaniklilik()-ustamakas[0].etkiHesapla(ustamakas[0],kagit[1]));


                        oyuncu2.nesneList.set(index2,kagit[1]);
                        break;

                    case "Makas":
                        makas[1]=(Makas) nesneRef[1];
                        ustamakas[0].setDayaniklilik(ustamakas[0].getDayaniklilik()-makas[1].etkiHesapla(makas[1],ustamakas[0]));
                        makas[1].setDayaniklilik(makas[1].getDayaniklilik()-ustamakas[0].etkiHesapla(ustamakas[0],makas[1]));


                        oyuncu2.nesneList.set(index2,makas[1]);
                        break;
                    case "AgirTas":
                        agirtas[1]=(AgirTas) nesneRef[1];
                        ustamakas[0].setDayaniklilik(ustamakas[0].getDayaniklilik()-agirtas[1].etkiHesapla(agirtas[1],ustamakas[0]));
                        agirtas[1].setDayaniklilik(agirtas[1].getDayaniklilik()-ustamakas[0].etkiHesapla(ustamakas[0],agirtas[1]));

                        oyuncu2.nesneList.set(index2,agirtas[1]);
                        break;
                    case "OzelKagit":
                        ozelkagit[1]=(OzelKagit) nesneRef[1];
                        ustamakas[0].setDayaniklilik(ustamakas[0].getDayaniklilik()-ozelkagit[1].etkiHesapla(ozelkagit[1],ustamakas[0]));
                        ozelkagit[1].setDayaniklilik(ozelkagit[1].getDayaniklilik()-ustamakas[0].etkiHesapla(ustamakas[0],ozelkagit[1]));
                        oyuncu2.nesneList.set(index2,ozelkagit[1]);
                        break;
                    case "UstaMakas":
                        ustamakas[1]=(UstaMakas) nesneRef[1];
                        ustamakas[0].setDayaniklilik(ustamakas[0].getDayaniklilik()-ustamakas[1].etkiHesapla(ustamakas[1],ustamakas[0]));
                        ustamakas[1].setDayaniklilik(ustamakas[1].getDayaniklilik()-ustamakas[0].etkiHesapla(ustamakas[0],ustamakas[1]));
                        oyuncu2.nesneList.set(index2,ustamakas[1]);
                        break;
                }

                oyuncu1.nesneList.set(index1,ustamakas[0]);
                break;

        }
        Nesne bos= new Bos();
        if((oyuncu1.nesneList.get(index1).getDayaniklilik()<=0) && (oyuncu2.nesneList.get(index2).getDayaniklilik()>0))
        {
            System.out.printf(oyuncu2.nesneList.get(index2).getClass().getSimpleName()+ oyuncu1.nesneList.get(index1).getClass().getSimpleName()+ "'i yendi!!");
            oyuncu2.nesneList.get(index2).setDeneyim(oyuncu2.nesneList.get(index2).getDeneyim()+20);
            if(oyuncu2.nesneList.get(index2).getDeneyim()>=30)
            {
                nesneYukselt(oyuncu2,index2);

            }
            OyunController.oyuncu1kalan--;
            oyuncu1.nesneList.set(index1,bos);
        }
        if((oyuncu1.nesneList.get(index1).getDayaniklilik()>0) && (oyuncu2.nesneList.get(index2).getDayaniklilik()<=0))
        {
            System.out.printf(oyuncu1.nesneList.get(index1).getClass().getSimpleName()+ " "+oyuncu2.nesneList.get(index2).getClass().getSimpleName()+ "'i yendi!!");
            oyuncu1.nesneList.get(index1).setDeneyim(oyuncu1.nesneList.get(index1).getDeneyim()+20);
            if((oyuncu1.nesneList.get(index1).getDeneyim()>=30))
            {
                nesneYukselt(oyuncu1,index1);
            }
            OyunController.oyuncu2kalan--;
            oyuncu2.nesneList.set(index2,bos);
        }

    }

    private static void nesneYukselt(Oyuncu oyuncu, int index) {
        Tas tas= new Tas();
        Kagit kagit= new Kagit();
        Makas makas= new Makas();
        AgirTas agirtas= new AgirTas();
        OzelKagit ozelkagit= new OzelKagit();
        UstaMakas ustamakas= new UstaMakas();
        switch (oyuncu.nesneList.get(index).getClass().getSimpleName())
        {
            case "Tas":
                agirtas.setDayaniklilik(oyuncu.nesneList.get(index).getDayaniklilik());
                oyuncu.nesneList.set(index,agirtas);
                System.out.println("Taşın Seviyesi Yükseldi!");
                break;
            case "Kagit":
                ozelkagit.setDayaniklilik(oyuncu.nesneList.get(index).getDayaniklilik());
                oyuncu.nesneList.set(index,ozelkagit);
                System.out.println("Kağıdın Seviyesi Yükseldi!");
                break;
            case "Makas":
                ustamakas.setDayaniklilik(oyuncu.nesneList.get(index).getDayaniklilik());
                oyuncu.nesneList.set(index,ustamakas);
                System.out.println("Makasın Seviyesi Yükseldi!");
                break;
        }
    }
    public void yokEt(Oyuncu oyuncu, int index)
    {
        Nesne Bos = new Bos();
        oyuncu.nesneList.set(index,Bos);

    }

    public static void main(int oyuntipi) throws IOException {
        Oyuncu.sayac=0;
        oyuncu.nesneList.clear();
        bilgisayar2.nesneList.clear();
        bilgisayar1.nesneList.clear();
        if(oyuntipi==0)
        {
            Oyuncu oyuncu1= oyuncu;
            Oyuncu oyuncu2= bilgisayar1;
            bilgisayar1.NesneListeOlustur(true,1);
            HelloApplication.secimEkrani();
            System.out.println("Bilgisayarın nesne listesi:");
            bilgisayar1.nesneListesi();
            System.out.println("Oyuncunun nesne listesi:");
            oyuncu.nesneListesi();

        } else if (oyuntipi==1) {
            Oyuncu oyuncu1= bilgisayar1;
            Oyuncu oyuncu2= bilgisayar2;
            bilgisayar1.NesneListeOlustur(true,1);
            bilgisayar2.NesneListeOlustur(true,1);
            System.out.println("Bilgisayar1 nesne listesi:");
            bilgisayar1.nesneListesi();
            System.out.println("Bilgisayar2 nesne listesi:");
            bilgisayar2.nesneListesi();
        }

        /*System.out.println("Oyuncunun Nesne Listesi");
        oyuncu.nesneListesi();
        System.out.println("Bilgisayarın Nesne Listesi");
        bilgisayar1.nesneListesi();*/
       /* int hamlesayisi=10;
        for(int j=0;j<hamlesayisi;j++)
        {
            karsilasma(oyuncu,oyuncu.nesneSec(false),bilgisayar,bilgisayar.nesneSec(true));
            for (int i = 0; i < 5; i++) {
                System.out.println("oyuncu " + oyuncu.nesneList.get(i).getClass().getSimpleName()+" " + oyuncu.nesneList.get(i).getDayaniklilik()+ " " + oyuncu.nesneList.get(i).getDeneyim());
                System.out.println("bilgisayar " +bilgisayar.nesneList.get(i).getClass().getSimpleName()+" " + bilgisayar.nesneList.get(i).getDayaniklilik()+ " " + bilgisayar.nesneList.get(i).getDeneyim());
            }
        }*/

    }
}