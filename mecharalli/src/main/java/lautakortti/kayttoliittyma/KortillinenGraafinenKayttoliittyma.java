package lautakortti.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.*;
import lautakortti.pelimekaniikka.Esterata;
import lautakortti.pelimekaniikka.Pelilauta;
import lautakortti.pelitapahtumienGrafiikka.Kuvaesitys;

public class KortillinenGraafinenKayttoliittyma implements Runnable {

    private JFrame pohja;
    private JPanel ruutu;
    private Kuvaesitys esitys;
    private JPanel kayttis;
    private JButton nappi;
    private JPanel komennot;
    private Pelilauta lauta;
    private JTextArea vuoroteksti;
    private int kierrosvaihe;
    private Kortinvalintapainike eka;
    private Kortinvalintapainike toka;
    private Kortinvalintapainike kolmas;
    private Kortinvalintapainike neljas;
    private Kortinvalintapainike viides;

    public KortillinenGraafinenKayttoliittyma() {
        kierrosvaihe = 0;
    }

    public void run() {
        alustaKayttis();
        pohja.setVisible(true);
    }

    public void aloita() {
        this.lauta = alustaLauta(2);
        lauta.piirra();
        kysyEkaEkaSiirto();
    }

    /**
     * Aloittaa siirtojen kyselemisen ja toteuttamisen kierteen, alustaa
     * siirtonamiskat.
     */
    public void kysyEkaEkaSiirto() {
        this.komennot = new JPanel();
        alustaValintapainikkeet();
        this.kayttis.add(komennot);

    }

    /**
     * Tuuppaa valintapainikkeet (5kpl) komentopaneeliin.
     */
    private void alustaValintapainikkeet() {
        this.eka = new Kortinvalintapainike();
        this.toka = new Kortinvalintapainike();
        this.kolmas = new Kortinvalintapainike();
        this.neljas = new Kortinvalintapainike();
        this.viides = new Kortinvalintapainike();
        komennot.add(eka);
        komennot.add(toka);
        komennot.add(kolmas);
        komennot.add(neljas);
        komennot.add(viides);
        valintapainikkeisiinKuuntelijat();
        this.uudetSiirrot();
    }

    private void valintapainikkeisiinKuuntelijat() {
        eka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kierrosvaihe++;
                lauta.asetaSiirto(eka.annaSiirto());
                if (kierrosvaihe == 2) {
                    kierrosvaihe = -1;
                    jatkaSiirtoja();
                }
            }
        });
        toka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kierrosvaihe++;
                lauta.asetaSiirto(toka.annaSiirto());
                if (kierrosvaihe == 2) {
                    kierrosvaihe = -1;
                    jatkaSiirtoja();
                }
            }
        });
        kolmas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kierrosvaihe++;
                lauta.asetaSiirto(kolmas.annaSiirto());
                if (kierrosvaihe == 2) {
                    kierrosvaihe = -1;
                    jatkaSiirtoja();
                }
            }
        });
        neljas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kierrosvaihe++;
                lauta.asetaSiirto(neljas.annaSiirto());
                if (kierrosvaihe == 2) {
                    kierrosvaihe = -1;
                    jatkaSiirtoja();
                }
            }
        });
        viides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                kierrosvaihe++;
                lauta.asetaSiirto(viides.annaSiirto());
                if (kierrosvaihe == 2) {
                    kierrosvaihe = -1;
                    jatkaSiirtoja();
                }
            }
        });
    }

    /**
     * Pyörittää yhden kierroksen siirrot. jatkaSiirtoja() tuo tänne.
     */
    public void eteneVuoro() {
        this.vuoroteksti.setText(lauta.teeSiirrot());
        lauta.piirra();
        if (lauta.voittikoPelaaja()) {
            pelaajaVoitti();
        } else if (lauta.tuhoutuikoPelaaja()) {
            pelaajaTuhoutui();
        } else if (kierrosvaihe==2){
            alustaNappi(true, "Valitse seuraavat siirrot.");
        } else {
            alustaNappi(true, "Seuraavat siirrot.");
        }
    }

    public void pelaajaVoitti() {
        alustaNappi(true, "Poistu voittajana.");
        kayttis.add(new JLabel("Onneksi olkoon, voitit!"));
        nappi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }

        });
    }

    public void pelaajaTuhoutui() {
        kayttis.add(new JLabel("Voi sentään, hävisit!"));
        alustaNappi(true, "Lopeta peli.");
        nappi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }

        });
    }

    /**
     * Luo uuden pelilaudan.
     *
     * @param laji Parametri kertoo, minkälainen lauta luodaan.
     * 1=4x4-alkeellinenPelilauta
     * @return
     */
    public Pelilauta alustaLauta(int laji) { //Luo pyydetynlaisen pelilaudan.
//        if (laji == 1) {
//            return new Esterata(laji, new Tekstiesitys());
//        } else {
        return new Esterata(1, esitys);
//        }

    }

    /**
     * Alustaa napin, jolla pelikierroksessa edetään.
     *
     * @param nakyy Tuleeko nappi näkyviin vai ei
     * @param viesti Mikä viesti nappiin kirjoitetaan
     */
    public void alustaNappi(boolean nakyy, String viesti) {
        this.nappi.setName(viesti);
        nappi.setText(viesti);
        this.nappi.repaint();
        this.nappi.setVisible(nakyy);
    }

    /**
     * Alustaa graafisen käyttiksen.
     */
    public void alustaKayttis() {
        this.pohja = new JFrame();
        this.ruutu = new JPanel();
        this.esitys = new Kuvaesitys();
        this.kayttis = new JPanel();
        kayttis.setPreferredSize(new Dimension(350, 500));
        final JButton aloitusnappi = new JButton("Aloita Mecharalli!");
        String apu = "Tervetuloa pelaamaan Mecharallia.\n";
        apu+="Tavoitteenasi on päästä vaaleanpunaiseen maaliin.\n"
        apu+="Valitse aina kerrallaan kolme \nseuraavaa siirtoasi napsauttamalla niitä.\n"
                apu+="Hauskaa hurjastelua!"
        this.vuoroteksti = new JTextArea();
        vuoroteksti.setText(apu);
        this.vuoroteksti.setEditable(false);
        this.vuoroteksti.setBackground(Color.LIGHT_GRAY);
        aloitusnappi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                aloitusnappi.setVisible(false);
                vuoroteksti.setText("");
                aloita();
            }
        });
        this.nappi = new JButton();
        alustaNappi(false, "Selvä.");
        kayttis.add(nappi);
        nappi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                nappi.setVisible(false);
                jatkaSiirtoja();
            }

        });

        kayttis.add(vuoroteksti);
        kayttis.add(aloitusnappi);
        ruutu.add(esitys);
        ruutu.add(kayttis);
        pohja.add(ruutu);
        pohja.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pohja.setMinimumSize(new Dimension(1000, 700));
        pohja.setLocationRelativeTo(null);
        pohja.pack();
    }

    /**
     * nappi-nappi ja kolmantena painettu valintanamiska tuovat tähän metodiin.
     * Jos kolme kierrosta siirtoja on jo tehty, piilottaa napin ja tarjoaa
     * uudet siirrot. Jos kolme kierrosta ei ole täynnä, tekee seuraavat
     * siirrot.
     */
    private void jatkaSiirtoja() {
        if (kierrosvaihe < 0) {
            komennot.setVisible(false);
            kierrosvaihe = 0;
            alustaNappi(true, "Aloita siirrot.");
        } else if (kierrosvaihe < 3) {
            kierrosvaihe++;
            eteneVuoro();
        } else {        //3 kierrosta täynnä.
            alustaNappi(false, "selvä");
            uudetSiirrot();
        }
    }

    /**
     * Alustaa viisi valintapainiketta uusilla siirroilla.
     */
    private void uudetSiirrot() {
        kierrosvaihe = -1;
        ArrayList<Integer> siirrot = lauta.seuraavatViisiVaihtoehtoa();
        eka.alusta(siirrot.get(0));
        toka.alusta(siirrot.get(1));
        kolmas.alusta(siirrot.get(2));
        neljas.alusta(siirrot.get(3));
        viides.alusta(siirrot.get(4));
        this.komennot.setVisible(true);
    }

}
