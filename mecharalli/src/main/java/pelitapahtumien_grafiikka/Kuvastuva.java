package pelitapahtumien_grafiikka;

public interface Kuvastuva {
    //Tämän rajapinnan täyttävät oliot piirtyvät pelilaudalle. 
    //Ne osaavat ilmoittaa sijaintinsa laudalla ja miltä ne näyttävät.
    
    abstract int sijaintiSivusuunnassa();

    abstract int sijaintiPystysuunnassa();
    
    abstract int mikaKuva();

}
