package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;

public class LiikkumatonEste implements Kuvastuva {

    private int x;
    private int y;
    private int kuva;
    private boolean vahingoittaaKolaroidessa;

    public LiikkumatonEste(int x, int y, int kuva, boolean vahingoittava) {
        this.x = x;
        this.y = y;
        this.kuva = kuva;
        this.vahingoittaaKolaroidessa = vahingoittava;
    }
    
    public LiikkumatonEste(int x, int y, int kuva){
        this(x,y,kuva,false);
    }
    
    public LiikkumatonEste(int x, int y){
        this(x,y,6,false);
    }

    public int sijaintiSivusuunnassa() {
       return this.x;
       }

    public int sijaintiPystysuunnassa() {
        return this.y;}

    public int mikaKuva() {
        return this.kuva;
    }
    
    public boolean vahingoittaako(){
        return this.vahingoittaaKolaroidessa;
    }

}
