import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.Random;

public class Gam {

    public static String[] karts = new String[Deck.deck.size()];

    public static boolean red = false;
    public static HashMap hand = new HashMap();

    public static Random rand = new Random();
    protected Integer zeit;

    public static int leben = 3;
    public static int runde = 3;
    public static HashMap spielen = new HashMap();
    public static HashMap gespie = new HashMap();
    public static String last = new String();
    public static boolean game = true;
    public static Instant end = Instant.now();
    public static Duration duration = Duration.between(Deck.start, end);
    public static int sec = duration.getNano();

    public static void gam() {
        while (game == true) {
            main();
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Du bist in Runde "+ runde);
            System.out.println("Du hast "+leben+" Leben");
            System.out.println("");

            if (runde == 0){
                if (leben == 0){
                    System.out.println("Du bist tot!");
                }else{
                    System.out.println("Du hast gewonnen.");
                }
                game = false;
            }
            if (leben == 0){
                System.out.println("Du bist tot.");
            }
        }
    }
    public static void test(){
        Set<String> keys = spielen.keySet();
        List<String> keyList = Arrays.asList(keys.toArray(new String[0]));
        Object[] d = keyList.toArray();

        Set<String> kes = Deck.gegn.keySet();
        List<String> keList = Arrays.asList(kes.toArray(new String[0]));
        Object[] dd = keList.toArray();

        System.out.println("Kampf");


        Object bb = gespie.get(dd[0]);
        Object aa = spielen.get(d[0]);


        Random rando = new Random();
        int x = rando.nextInt(4);
        int z = x-1;
        int y = 1+(z*3);

        char c = aa.toString().charAt(y);
        char cc = bb.toString().charAt(y);

        System.out.println(c);
        System.out.println(cc);

        if (c == cc){
            System.out.println("Unentschieden");
            runde -= 1;
        }
        if (c < cc){
            System.out.println("Du hast verloren");
            leben -= 1;
            runde -= 1;
        }
        if (c > cc){
            System.out.println("Du hast gewonnen");
            runde -= 1;
        }

        //System.out.println(spielen);
        hand.remove(d[0]);
        spielen.remove(d[0]);
        gespie.remove(0);

    }
    public static void gegnere(){
        int rando = rand.nextInt(Deck.gegn.size());
        Set<String> keys = Deck.gegn.keySet();
        List<String> keyList = Arrays.asList(keys.toArray(new String[0]));
        Object[] dd = keyList.toArray();
        gespie.put(dd[0],Deck.gegn.get(dd[0]));

        System.out.println("Dein Gegner spielt "+gespie);
    }
    public static void main() {
        Scanner scanner = new Scanner(System.in);  // create a scanner object to read input
        System.out.println("Was möchtest du tun ? \n (1) Karte auswählen \n (2) Karte spielen \n (3) Karte ziehen");
        String input = scanner.nextLine();  // read the user's input as a string

        switch (input.toLowerCase()) {  // convert the input to lowercase and use it in the switch statement
            case "1":
                if (hand.size() == 0) {
                    System.out.println("Keine Karte auf deiner Hand. Ziehe zuerst eine Karte.");
                }else{
                    Set<String> keys = hand.keySet();
                    List<String> keyList = Arrays.asList(keys.toArray(new String[0]));
                    Object[] dd = keyList.toArray();
                    Scanner auswahl = new Scanner(System.in);
                    System.out.println("Welche Karte möchtest du wählen \n ");
                    for (int a = 0;a < hand.size();a++) {
                        Object g = dd[a];
                        System.out.println(g + "(" + (a + 1) + ")");
                        System.out.println("[" + hand.get(g) + "]");
                    }
                    gegnere();
                    }
                String llk = scanner.nextLine();  // read the user's input as a string
            {
                switch (llk.toLowerCase()) {
                    case "1":
                        if (hand.size() >= 1) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[0].toString();
                            System.out.println(last);
                            spielen.put(ded[0], hand.get(ded[0]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 1) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "2":
                        if (hand.size() >= 2) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[1].toString();
                            System.out.println(last);
                            spielen.put(ded[1], hand.get(ded[1]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 2) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "3":
                        if (hand.size() >= 3) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[2].toString();
                            System.out.println(last);
                            spielen.put(ded[2], hand.get(ded[2]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 3) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "4":
                        if (hand.size() >= 4) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[3].toString();
                            System.out.println(last);
                            spielen.put(ded[3], hand.get(ded[3]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 4) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "5":
                        if (hand.size() >= 5) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[4].toString();
                            System.out.println(last);
                            spielen.put(ded[4], hand.get(ded[4]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 5) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "6":
                        if (hand.size() >= 6) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[5].toString();
                            System.out.println(last);
                            spielen.put(ded[5], hand.get(ded[5]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 6) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "7":
                        if (hand.size() >= 7) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[6].toString();
                            System.out.println(last);
                            spielen.put(ded[6], hand.get(ded[6]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 7) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "8":
                        if (hand.size() >= 8) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[7].toString();
                            System.out.println(last);
                            spielen.put(ded[7], hand.get(ded[7]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 8) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "9":
                        if (hand.size() >= 9) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[8].toString();
                            System.out.println(last);
                            spielen.put(ded[8], hand.get(ded[8]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 9) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "10":
                        if (hand.size() >= 10) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[9].toString();
                            System.out.println(last);
                            spielen.put(ded[9], hand.get(ded[9]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 10) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "11":
                        if (hand.size() >= 11) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[10].toString();
                            System.out.println(last);
                            spielen.put(ded[10], hand.get(ded[10]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 11) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "12":
                        if (hand.size() >= 12) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[11].toString();
                            System.out.println(last);
                            spielen.put(ded[11], hand.get(ded[11]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 12) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "13":
                        if (hand.size() >= 13) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[12].toString();
                            System.out.println(last);
                            spielen.put(ded[12], hand.get(ded[12]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 13) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "14":
                        if (hand.size() >= 14) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[13].toString();
                            System.out.println(last);
                            spielen.put(ded[13], hand.get(ded[13]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 14) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "15":
                        if (hand.size() >= 15) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[14].toString();
                            System.out.println(last);
                            spielen.put(ded[14], hand.get(ded[14]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 15) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;
                    case "16":
                        if (hand.size() >= 16) {
                            Set<String> kes = hand.keySet();
                            Object[] ded = kes.toArray();
                            last = ded[15].toString();
                            System.out.println(last);
                            spielen.put(ded[15], hand.get(ded[15]));
                            System.out.println(spielen);
                        }
                        if (hand.size() < 16) {
                            System.out.println("Wähle eine Zahl, welche kleiner als " + hand.size() + "ist.");
                        }
                        break;

                    default:
                        System.out.println("Nur zahlen von 1-" + hand.size() + " möglich.");
                }
            }
            break;
            case "2":
                if (hand.size() == 0) {
                    System.out.println("Keine Karte auf deiner Hand. Ziehe zuerst eine Karte.");
                }
                if (spielen.size() == 0) {
                    System.out.println("Keine Karte ausgewöhlt. Wöhle zuerst eine Karte von deiner Hand.");
                }
                if (spielen.size() > 0) {
                    System.out.println("Du spielst " + spielen);
                    last = null;
                    test();
                }
                break;
            case "3":
                if (Deck.deck.size() > 0) {
                    if (hand.size() < 5) {
                        int seconds = sec % Deck.deck.size();
                        Set<String> kys = Deck.deck.keySet();
                        List<String> kyList = Arrays.asList(kys.toArray(new String[0]));
                        Object nas = kyList.get(seconds);
                        hand.put(nas, Deck.deck.get(nas));
                        Deck.deck.remove(nas);

                        System.out.println("Du hast " + nas + " gezogen. \n Mit folgenden Werten " + hand.get(nas));
                    }else {
                        System.out.println("Limit an Karten gezogen.");
                    }
                }
                if (Deck.deck.size() == 0){
                    System.out.println("Keine Karten im Deck mehr vorhanden. Du hast alle Karten gezogen.");
                }

                break;
            default:
                System.out.println("Falsche Eingabe. Nur 1-3 möglich");

        }
    }
}
