package lautakortti.kayttoliittyma;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.*;
import lautakortti.pelimekaniikka.Esterata;
import lautakortti.pelimekaniikka.Pelilauta;
import lautakortti.pelitapahtumienGrafiikka.Kuvaesitys;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame pohja;
    private JPanel ruutu;
    private Kuvaesitys esitys;
    private JPanel kayttis;
    private JButton nappi;
    private JPanel komennot;
    private Pelilauta lauta;

    public GraafinenKayttoliittyma() {
    }

    public void run() {
        this.pohja = new JFrame();
        this.ruutu = new JPanel();
        this.esitys = new Kuvaesitys();
        this.kayttis = new JPanel();
        kayttis.setPreferredSize(new Dimension(350, 500));
        final JButton aloitusnappi = new JButton("Aloita Mecharalli!");
        final JLabel tervehdysteksti = new JLabel("Tervetuloa pelaamaan Medhcarallia.");
        aloitusnappi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                aloitusnappi.setVisible(false);
                tervehdysteksti.setVisible(false);
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
                komennot.setVisible(true);
            }

        });

        kayttis.add(tervehdysteksti);
        kayttis.add(aloitusnappi);
        ruutu.add(esitys);
        ruutu.add(kayttis);
        pohja.add(ruutu);
        pohja.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pohja.setMinimumSize(new Dimension(1000, 700));
        pohja.setLocationRelativeTo(null);
        pohja.pack();
        pohja.setVisible(true);

    }

    public void aloita() {
        this.lauta = alustaLauta(2);
        lauta.piirra();
        kysyEkatSiirrot();
    }

    public void kysyEkatSiirrot() {
        //ruutu.repaint();
        this.komennot = new JPanel();
        JButton y = new JButton("ylös");
        y.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                komennot.setVisible(false);
                eteneVuoro("z");
            }

        });
        JButton a = new JButton("alas");
        a.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                komennot.setVisible(false);
                eteneVuoro("w");
            }

        });
        JButton v = new JButton("vasemmalle");
        v.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                komennot.setVisible(false);
                eteneVuoro("a");
            }

        });

        JButton o = new JButton("oikealle");
        o.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                komennot.setVisible(false);
                eteneVuoro("s");
            }

        });

        komennot.add(y);
        komennot.add(a);
        komennot.add(v);
        komennot.add(o);
        this.kayttis.add(komennot);

    }

    public void eteneVuoro(String komento) {
        lauta.asetaSiirto(komento);
        lauta.teeSiirrot();

        if (lauta.voittikoPelaaja()) {
            pelaajaVoitti();
        } else if (lauta.tuhoutuikoPelaaja()) {
            pelaajaTuhoutui();
        } else {
            lauta.piirra();
            alustaNappi(true, "Seuraava kierros.");
            //esitys.repaint();
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

    public void alustaNappi(boolean nakyy, String viesti) {
        this.nappi.setName(viesti);
        nappi.setText(viesti);
        this.nappi.repaint();
        this.nappi.setVisible(nakyy);
    }

}
