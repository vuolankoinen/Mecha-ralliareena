package pelimekaniikka;

public interface Liikkuva {

//Tämän rajapinnan toteuttavat oliot osaavat kertoa, mihin ne seuraavaksi liikkuvat.    
    abstract int kerroSeuraavaSiirto();

//Niiden sijaintia voi myös muuttaa metodikutsulla.
    abstract void liiku(int pystysuoraMuutosSijainnissa, int vaakasuoraMuutosSijainnissa);
    
}
