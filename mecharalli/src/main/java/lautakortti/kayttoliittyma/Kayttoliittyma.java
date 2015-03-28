package lautakortti.kayttoliittyma;

import java.util.Scanner;
import lautakortti.pelimekaniikka.AlkeellinenPelilauta;
import lautakortti.pelimekaniikka.Pelilauta;
import lautakortti.pelitapahtumienGrafiikka.Tekstiesitys;

public class Kayttoliittyma {

    private Scanner lukija;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        System.out.println("Tervetuloa pelaamaan Mecharallia!");
        while (true) {
            System.out.println("Valitse pelattava kenttä:");
            System.out.println("1: pikajuoksurata");
            System.out.println("0: lopeta peli");
            String kasky = lukija.nextLine();
            int arvo = 240;
            if (kasky.equals("0")) {
                return;
            } else if (kasky.equals("1")) {
                arvo = 1;
            }
            if (arvo == 240) {   //Jos arvo ei muuttunut, ei saatu kunnon käskyä.
                System.out.println("Epäselvä käsky, ohjelma sulkeutuu.");
                return;
            }
            pelaa(alustaLauta(arvo));
        }
    }

    public void pelaa(Pelilauta lauta) { //Käynnistää pelin annetulla pelilaudalla.
        String komento = "";
        while (true) {
            lauta.piirra();
            System.out.print("Komento? (X lopettaa)");
            komento = lukija.nextLine();
            if (komento.equals("X")) {
                break;
            }
            lauta.teeSiirrot();
            if (lauta.voittikoPelaaja()) {
                System.out.println("Onneksi olkoon, voitit.");
                return;
            }
        }
    }

    public Pelilauta alustaLauta(int laji) { //Luo pyydetynlaisen pelilaudan.
        Tekstiesitys esitys = new Tekstiesitys();
        return new AlkeellinenPelilauta(laji, esitys);

    }
}
