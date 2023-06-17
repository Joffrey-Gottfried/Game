import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Karte karte = new Karte();
        karte.v(); //erstellt value_ein
        karte.t(); //erstellt value_all
        HashMap a = karte.z(); //erstellt basic

        Karte gegner = new Karte();
        gegner.v();
        gegner.t();
        HashMap b = gegner.z();
        Deck.geg();
        Deck.gegn.putAll(b);

        Deck.main();
        Deck.deck.putAll(a);

        //Game.main();
        Gam.gam();

        System.out.println(Deck.deck);

        // System.out.println(Arrays.toString(karte.value_ein));

        //System.out.println(Arrays.deepToString(karte.value_all));

        //System.out.println(karte.basic);
    }
}

/*
karten spiel,

 werte jeder karte wie stark,
 vier klassen,
  standard klassen die jeder hat,   [zuerst einfach halber nur die]
 besondere klasse welche farben unspezifisch und jeder haben kann.

  normalerweise stellt man selbst deck zsm.
  einfachhalber hier nicht

  bekommt 7 random karten zugelost, vorher wöhlt welche klasse man spielen kann

  geht darum wer am meisten schaden gemacht hat

  drei runden
  nach jeder runde gibt es einen gewinner,
  der gewinner, behält eine random karte (wieder in der hand)
  der verlierer, erhält zwei random karten aus deck

  sonst werden keine neuen karten gezogen


 */