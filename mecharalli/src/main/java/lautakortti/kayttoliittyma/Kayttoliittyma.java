package lautakortti.kayttoliittyma;

import java.util.Scanner;
import lautakortti.pelimekaniikka.Esterata;
import lautakortti.pelimekaniikka.Pelilauta;
import lautakortti.pelitapahtumienGrafiikka.Kuvaesitys;
import lautakortti.pelitapahtumienGrafiikka.Tekstiesitys;

public class Kayttoliittyma {

    private Scanner lukija;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
    }

    /**
     * Tämä on pelin pääsilmukka.
     */
    public void kaynnista() {
        System.out.println("Tervetuloa pelaamaan Mecharallia!");
        while (true) {
            System.out.println("Valitse pelattava kenttä:");
            System.out.println("1: pikajuoksurata");
            System.out.println("2: pikajuoksurata grafiikoilla");
            System.out.println("0: lopeta peli");
            String kasky = lukija.nextLine();
            int arvo = 240;
            if (kasky.equals("0")) {
                return;
            } else if (kasky.equals("1")) {
                arvo = 1;
            } else if (kasky.equals("2")) {
                arvo = 2;
            }
            if (arvo == 240) {   //Jos arvo ei muuttunut, ei saatu kunnon käskyä.
                System.out.println("Epäselvä käsky, ohjelma sulkeutuu.");
                return;
            }
            pelaa(alustaLauta(arvo));   //Luodaan lauta ja pelataan se.
        }
    }

    /**
     * Yksittäisen pelilaudan silmukka. Lautaa pelataan, kunnes pelitilanteen
     * lopetusehto täyttyy (peli on hävitty tai voitettu).
     *
     * @param lauta Pelattava pelilauta.
     */
    public void pelaa(Pelilauta lauta) { //Käynnistää pelin annetulla pelilaudalla.
        String komento = "";
        while (true) {
            lauta.piirra();
            System.out.print("Komento? (X lopettaa)");
            komento = lukija.nextLine();
            if (komento.equals("X")) {
                break;
            } else {
                lauta.asetaSiirto(komento);
            }
            lauta.teeSiirrot();
            if (lauta.voittikoPelaaja()) {
                System.out.println("Onneksi olkoon, voitit.\n");
                return;
            }
            if (lauta.tuhoutuikoPelaaja()) {
                System.out.println("Voi sentään, hävisit.\n");
                return;
            }
        }
    }

    /**
     * Luo uuden pelilaudan.
     *
     * @param laji Parametri kertoo, minkälainen lauta luodaan.
     * 1=4x4-alkeellinenPelilauta
     * @return
     */
    public Pelilauta alustaLauta(int laji) { //Luo pyydetynlaisen pelilaudan.
        if (laji == 1) {
            return new Esterata(laji, new Tekstiesitys());
        } else {
            return new Esterata(1, new Kuvaesitys());
        }

    }
}
