import java.util.*;
import java.util.HashMap;

public class Karte {
    public static final int num_card = 10; //kartendeck größe
    public String[] kartenwerte = {"Name","Leben","Defensive","Special","Kosten"};
    public String[] fahigk_in = {"(bauer) holt weiter Bauern(pro runde am leben 1)",
            "(knappe) wird nach zwei runden zum ritter",
            "(ritter) hat einen schild(einmal block)",
    "(könig) kann nur attakiert werden wenn keine anderen karten existiern",
    "(zofe) kann könig und königin nach zwei zügen direkt töten",
    "(hexe) tötet random eine karte auf dem spielfedl",
    "(jäger) tötet random eine karte auf dem spielfeld des gegners",
    "(narr) verwandelt sich wenn tot in bauer",
    "(dieb) stielt eine random fähigkeit einer karte des gegners auf dem spielfeld",
    "(königin) kann könig direkt töten"};


    public HashMap basic = new HashMap(); //alle basic karten

    public String[] names = {"Bauer","Knappe","König","Zofe","Hexe","Jäger","Narr","Dieb","Königin"}; //kartenname

    public int[] value_ein = new int[40]; //alle werte von einer karte
    public int[][] value_all = new int[num_card][4]; //alle werte pro karte

    public int[] v() {
        for (int card = 0; card < num_card; card++) {
            var a = card + 1;
            var b = (card * 3) % 8;

            value_ein[0+card*4] = a;//wert
            value_ein[1+card*4] = b;//defens bisschen durcheinander
            value_ein[2+card*4] = card;//verweißt auf individuelle fähigkeit in array
            value_ein[3+card*4] = a; //kosten wie wert
        }
        return value_ein;
    }

    public int[][] t(){
           for (int einz = 0; einz < num_card; einz++) {
               int[] h = new int[4];
               for (int a = 0;a < 5;a++){
                   h[0] = value_ein[0+a*einz]; //alle karten
                   h[1] = value_ein[1+a*einz]; //alle karten
                   h[2] = value_ein[2+a*einz]; //alle karten
                   h[3] = value_ein[3+a*einz]; //alle karten
               }
               value_all[einz] = h;
        }
           return value_all;
    }

    public HashMap z(){
        for(int t = 0; t < num_card-1; t++) {
            var a = Arrays.toString(value_all[t]);
            basic.put((names[t]), a);
        }
        return basic;
    }
    public static void main(String[] args){};
}
