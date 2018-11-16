package at03;
import fi.jyu.mit.ohj2.Syotto;

/**
 * Ohjelmalla pelataan Hirsipuu-peli�
 * 
 * @author vesal
 */
public class Hirsipuu {

    /**
     * Tulostaa ohjelman logon
     */
    public static void tulostaLogo() {
        System.out.println("Hirsipuu-peli");
        System.out.println("=============");
        System.out.println();
    }
    
    
    /**
     * Luo sanasta jonon, jossa jokaisen merkin kohdalla on _
     * @param sana josta jono luodaan
     * @return sanan pituuden verran alleviivoja
     */
    public static StringBuilder luoTulosjono(String sana) {
        StringBuilder tulos =  new StringBuilder(sana);
        for (int i=0; i<tulos.length(); i++) {
            tulos.setCharAt(i,'_');
        } 
        return tulos;
    }

    
    /**
     * Palauttaa jono niin ett� joka toinen paikka on tyhj�
     * Esim: k_ss_   => k _ s s _
     * @param jono 
     * @return jono harvana
     * @example
     * <pre name="test">
     *   harvakseen("") === "";
     *   harvakseen("k") === "k";
     *   harvakseen("ki") === "k i";
     *   harvakseen("kissa") === "k i s s a";
     * </pre>
     */
    public static String harvakseen(String jono) {
        StringBuilder tulos = new StringBuilder();
        String vali = "";
        for (int i=0; i<jono.length(); i++) {
            tulos.append(vali + jono.charAt(i));
            vali = " ";
        }
        return tulos.toString();
    }
    
    
    /**
     * Palauttaa jonon niin ett� joka toinen paikka on tyhj�
     * Esim: k_ss_   => k _ s s _
     * @param jono 
     * @return jono harvana
     * @example
     * <pre name="test">
     *   harvakseen(new StringBuilder("kissa")) === "k i s s a";
     * </pre>
     */
    public static String harvakseen(StringBuilder jono) {
        return harvakseen(jono.toString());
    }
    
    
    /**
     * Tutkii montako kertaa merkki l�ytyy sanasta.  Samalla
     * l�ytyneiden merkkien kohdalle tulos-jonoon merkit��n ko. merkki.
     * Jos merkki jo on tulos-jonossa, se tulkitaan v��r�ksi.
     * @param sana   mist� merkki� etsit��n
     * @param merkki etsitt�v� kirjain
     * @param tulos  jono johon oikeat merkit��n
     * @return oikeiden merkkien m��r�
     * @example
     * <pre name="test">
     *   String sana = "kissa";
     *   StringBuilder tulos = luoTulosjono(sana);
     *   tutkiOikeat(sana,'z',tulos) === 0;
     *   tutkiOikeat(sana,'k',tulos) === 1;  
     *   tulos.toString() === "k____";
     *   tutkiOikeat(sana,'k',tulos) === 0;  
     *   tulos.toString() === "k____";
     *   tutkiOikeat(sana,'i',tulos) === 1;  
     *   tulos.toString() === "ki___";
     * </pre>
     */
    public static int tutkiOikeat(String sana,char merkki, StringBuilder tulos) {
        int pituus = Math.min(sana.length(), tulos.length());
        int lkm = 0;
        for (int i=0; i<pituus; i++) {
            if ( merkki != sana.charAt(i) ) continue;
            if ( merkki == tulos.charAt(i)) continue;  
            lkm++;
            tulos.setCharAt(i,merkki);
        }
        
        return lkm;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        final int MAXVAARIA = 6;
        String sana = "kissa"; // TODO  arvo t�h�n sana
        String vaaria = ""; // Sis�lt�� ne v��r�t arvaukset
        int oikeita = 0;
        StringBuilder tulos = luoTulosjono(sana);
        
        tulostaLogo();
        
        while ( true ) {
            System.out.println();
            System.out.println("Sana: "+harvakseen(tulos));
            String syote = Syotto.kysy("Anna kirjain");
            //T�ss� pit�isi tarkastaa, ettei k�ytt�j� paina pelkk�� enteri�.
            char c = syote.charAt(0);
            System.out.println("Annoit kirjaimen " + c);
            int lkm = tutkiOikeat(sana,c,tulos);
            if ( lkm == 0 ) {
                vaaria += c;
                System.out.printf("Virheit�: %d/%d%n", vaaria.length(),MAXVAARIA);
                System.out.println("V��ri� kirjaimia: " + harvakseen(vaaria));
                if ( vaaria.length() >= MAXVAARIA) {
                    System.out.println("H�visit!");
                    break;
                }
            }
            oikeita += lkm; // ei haittaa virheenk��n 
            if ( oikeita >= sana.length() ) {
                System.out.println("Voitit!");
                break;
            }  
            
        }

        System.out.println("Sana: " + sana);
    }
    
}