package pelimekaniikka;

import pelitapahtumien_grafiikka.*;

public class Nappula implements Liikkuva, Kuvastuva {
    private int x;
    private int y;

    Nappula(int alkusijaintiX, int alkusijaintiY) {
        this.x = alkusijaintiX;
        this.y = alkusijaintiY;
    }
    
    
    public int kerroSeuraavaSiirto() {
        return 0;   //Siirtoja ei ole toteutettu vielä...
    }

    public int sijaintiSivusuunnassa() {
        return this.x;
    }

    public int sijaintiPystysuunnassa() {
        return this.y;
    }

    public int mikaKuva() {
        return 1;
    }

    
    public void liiku(int y, int x) {
        if(true){   //Tässä testataan, onko siirto laillinen! XX
            this.x += x;
        }
        
        if(true){   //Tässä testataan, onko siirto laillinen! XX
            this.y += y;
        }
    }
    
}
