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

/**
 * Graafinen käyttöliittymä.
 * <p>
 * Luo pyydetyn pelilaudan ja sitten toimii yhteyskohtana pelaajan ja pelilaudan
 * välillä.
 *
 * @author Matti Palomäki
 */
public class KortillinenGraafinenKayttoliittyma implements Runnable {

    private JFrame pohja;   //kaikki muu tulee tähän
    private JPanel ruutu;       //pelilaudan kuva tule tähän
    private Kuvaesitys esitys;
    private JPanel kayttis;     //Painikkeet yms. käyttöliittymä tulee tähän
    private JButton nappi;
    private JPanel komennot;    //Siirtovalintapainikkeet tähän
    private Pelilauta lauta;
    private JTextArea vuoroteksti;      //Käyttäjälle tiedoksi tuleva teksti
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

    /**
     * Tekee pelin alkutoimet.
     */
    private void aloita(int laudanlaji) {
        this.lauta = alustaLauta(laudanlaji);
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
        JButton nollaa = new JButton("Peru valinnat.");
        nollaa.setBackground(Color.ORANGE);
        nollaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                nollaaSiirrot();
            }
        }
        );
        komennot.add(nollaa);
        this.uudetSiirrot();
    }

    /**
     * Lisää valintapainikkeisiin omat kuuntelijat. Kuuntelija kasvattaa
     * kierroksen etenemistä mittaavaa laskuria ja asettaa valitun siirron
     * pelaajanappulalle.
     */
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
    private void eteneVuoro() {
        this.vuoroteksti.setText(lauta.teeSiirrot());
        lauta.piirra();
        if (lauta.voittikoPelaaja()) {
            pelaajaVoitti();
        } else if (lauta.tuhoutuikoPelaaja()) {
            pelaajaTuhoutui();
        } else if (kierrosvaihe == 3) {
            alustaNappi(true, "Valitse seuraavat siirrot.");
        } else {
            alustaNappi(true, "Toteuta seuraavat siirrot.");
        }
    }

    /**
     * Voittoviesti ja pelin lopetus.
     */
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

    /**
     * Tappioviesti ja pelin lopetus.
     */
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
     * @param laji Parametri kertoo, minkälainen lauta luodaan. 1 = 4x4
     * pelilauta, 2 = 7x7 pelilauta, 3 = 8x8, 4 = 12x12 satunnaisgeneroitu lauta
     * @return Palauttaa luodun laudan.
     */
    public Pelilauta alustaLauta(int laji) { //Luo pyydetynlaisen pelilaudan.
        if (laji < 5 && laji > 0) {
            return new Esterata(laji, esitys);
        } else {
            return new Esterata(2, esitys); //keskikokoinen lauta on oletus
        }
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
        kayttis.setPreferredSize(new Dimension(400, 500));
        final JButton aloitusnappi = new JButton("1. Pieni pelilauta");
        final JButton aloitusnappi2 = new JButton("2. Isompi pelilauta");
        final JButton aloitusnappi3 = new JButton("3. Vielä isompi pelilauta");
        final JButton aloitusnappi4 = new JButton("4. Isoin, arvottu lauta");
        alustaTervehdysteksti();
        aloitusnappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aloitusnappi2.setVisible(false);
                aloitusnappi.setVisible(false);
                aloitusnappi3.setVisible(false);
                aloitusnappi4.setVisible(false);
                vuoroteksti.setText("");
                aloita(1);
            }
        });
        aloitusnappi3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        aloitusnappi2.setVisible(false);
                        aloitusnappi.setVisible(false);
                        aloitusnappi3.setVisible(false);
                        aloitusnappi4.setVisible(false);
                        vuoroteksti.setText("");
                        aloita(3);
                    }
                }
        );
        aloitusnappi2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        aloitusnappi2.setVisible(false);
                        aloitusnappi.setVisible(false);
                        aloitusnappi3.setVisible(false);
                        aloitusnappi4.setVisible(false);
                        vuoroteksti.setText("");
                        aloita(2);
                    }
                }
        );
        aloitusnappi4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        aloitusnappi2.setVisible(false);
                        aloitusnappi.setVisible(false);
                        aloitusnappi3.setVisible(false);
                        aloitusnappi4.setVisible(false);
                        vuoroteksti.setText("");
                        aloita(4);
                    }
                }
        );

        this.nappi = new JButton();
        alustaNappi(false, "Selvä.");
        kayttis.add(nappi);
        nappi.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        nappi.setVisible(false);
                        jatkaSiirtoja();
                    }
                }
        );
        kayttis.add(vuoroteksti);
        kayttis.add(aloitusnappi);
        kayttis.add(aloitusnappi2);
        kayttis.add(aloitusnappi3);
        kayttis.add(aloitusnappi4);
        ruutu.add(esitys);
        ruutu.add(kayttis);
        pohja.add(ruutu);
        pohja.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pohja.setMinimumSize(new Dimension(800, 500));
        pohja.setLocationRelativeTo(null);
        pohja.pack();
    }

    /**
     * Alustaa käyttiksen tekstikentän ja asettaa sen ensimmäiseksi arvoksi
     * tervetulotekstin.
     */
    private void alustaTervehdysteksti() {
        String apu = "      Tervetuloa pelaamaan Mecharallia.\n\n";
        apu += "Ohjaat vaaleanpunaista mecha-robottia.\n";
        apu += "Valitse aina kerrallaan kolme \nseuraavaa siirtoasi napsauttamalla niitä.\n";
        apu += "Tavoitteenasi on päästä vaaleanpunaiseen maaliin.\n\n";
        apu += "    Hauskaa hurjastelua!\n";
        this.vuoroteksti = new JTextArea();
        vuoroteksti.setText(apu);
        this.vuoroteksti.setEditable(false);
        this.vuoroteksti.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * nappi-nappi ja kolmantena painettu valintanamiska tuovat tähän metodiin.
     * Jos kolme kierrosta siirtoja on jo tehty, piilottaa napin ja tarjoaa
     * uudet siirrot. Jos kolme kierrosta ei ole täynnä, tekee seuraavat
     * siirrot.
     */
    private void jatkaSiirtoja() {
        this.vuoroteksti.setText("");
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
     * Alustaa viisi siirronvalintapainiketta uusilla siirroilla pelaajanappulan
     * pakasta.
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

    /**
     * nollaa-nappi tuo tänne. Poistaa tehdyt siirtovalinnat ja ottaa
     * valintapainikkeet taas käyttöön.
     */
    private void nollaaSiirrot() {
        this.eka.setEnabled(true);
        this.toka.setEnabled(true);
        this.kolmas.setEnabled(true);
        this.neljas.setEnabled(true);
        this.viides.setEnabled(true);
        this.lauta.nollaaSiirrot();
        kierrosvaihe = -1;
    }
}
