import java.util.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Deck extends Karte {

    public static HashMap deck = new HashMap();
    public static HashMap gegn = new HashMap();

    public static Instant start = Instant.now();
    public static Integer reich = 0;


    public static void main() {
        // Reiche , Ilchane, Achämeniden, Timuriden, Meder
        Scanner scanner = new Scanner(System.in);  // create a scanner object to read input
        System.out.println("Welches Reich möchtest du spielen ? \n Mongolen (1), \n Perser (2), \n Vikings (3), \n Atzteken (4) \n Deine Eingabe hier (1-4) ...");

        String input = scanner.nextLine();  // read the user's input as a string

        switch (input.toLowerCase()) {  // convert the input to lowercase and use it in the switch statement
            case "1":
                System.out.println("Du spielst das Ilchanereich/Mongolenreich.");
                int karten_anzahl = 2;
                int[] werte = {9,9,5,0, 1, 1, 1, 1};
                String[] namen = {"Dschingis Khan","Roos"};
                int[][] arr = create_all(karten_anzahl, werte);
                deck = (create_Hash(karten_anzahl, arr, namen));

                reich = 1;
                break;
            case "2":
                System.out.println("Du spielst die Achämeniden/Perser.");
                int karten_anzah = 3;
                int[] wert = {3, 3, 3, 9, 7, 3, 7, 7, 2, 6, 6, 6};
                String[] nam = {"Gelehrter", "Schahmane", "Normane"};
                int[][] ar = create_all(karten_anzah, wert);
                deck = create_Hash(karten_anzah, ar, nam);

                reich = 2;
                break;
            case "3":
                System.out.println("Du spielst die Vikings.");
                int karten_anzahl1 = 3;
                int[] werte1 = {1, 1, 1, 1, 7, 7, 7, 7, 9, 0, 9, 9};
                String[] namen1 = {"Rabe", "Lothbrok", "Odin"};
                int[][] arr1 = create_all(karten_anzahl1, werte1);
                deck = create_Hash(karten_anzahl1, arr1, namen1);

                reich = 3;
                break;
            case "4":
                System.out.println("Du spielst das Atztekenreich.");
                int karten_anzahl2 = 3;
                int[] werte2 = {7, 7, 5, 9, 5, 2, 6, 5, 4, 4, 4, 4};
                String[] namen2 = {"Quetzalacoatl", "Moctezuma", "Jaguarkrieger"};
                int[][] arr2 = create_all(karten_anzahl2, werte2);
                deck = create_Hash(karten_anzahl2, arr2, namen2);

                reich = 4;
                break;
            default:
                System.out.println("Falsche Eingabe. Nur 1-4 möglich");
        }
    }
    public static void geg(){
        Random rane = new Random();
        int ran = rane.nextInt(3);
        if (reich == 1){
            if (ran == 1){
                ran = 4;
            }
        }
        if (reich == 2){
            if (ran == 2){
                ran = 4;
            }
        }
        if (reich == 3){
            if (ran == 3){
                ran = 4;
            }
        }
        if (ran == 1){
            System.out.println("Dein Gegner spielt die Mongolen.");
            int karten_anzahl = 2;
            int[] werte = {7,8,0,9, 1, 1, 1, 1};
            String[] namen = {"Dschingis Khan","Roos"};
            int[][] arr = create_all(karten_anzahl, werte);
            gegn = (create_Hash(karten_anzahl, arr, namen));
        }
        if (ran == 2){
            System.out.println("Dein Gener spielt die Achämeniden/Perser.");
            int karten_anzah = 3;
            int[] wert = {3, 3, 3, 9, 7, 3, 7, 7, 2, 6, 6, 6};
            String[] nam = {"Gelehrter", "Schahmane", "Normane"};
            int[][] ar = create_all(karten_anzah, wert);
            gegn = create_Hash(karten_anzah, ar, nam);
        }
        if (ran == 3){
            System.out.println("Dein Gegner spielt die Vikings.");
            int karten_anzahl1 = 3;
            int[] werte1 = {1, 1, 1, 1, 7, 7, 7, 7, 9, 5, 9, 9};
            String[] namen1 = {"Rabe", "Lothbrok", "Odin"};
            int[][] arr1 = create_all(karten_anzahl1, werte1);
            gegn = create_Hash(karten_anzahl1, arr1, namen1);
        }
        if (ran == 4){
            System.out.println("Dein Gegner spielt die Atzteken.");
            int karten_anzahl2 = 3;
            int[] werte2 = {7, 3, 7, 7, 5, 4, 5, 5, 4, 6, 4, 4};
            String[] namen2 = {"Quetzalacoatl", "Moctezuma", "Jaguarkrieger"};
            int[][] arr2 = create_all(karten_anzahl2, werte2);
            gegn = create_Hash(karten_anzahl2, arr2, namen2);
        }
    }

    public static HashMap create_Hash(int menge,int[][] werte,String[] namen) {
        HashMap hash = new HashMap();
        for (int t = 0; t < menge; t++) {
            var a = Arrays.toString(werte[t]);
            hash.put((namen[t]), a);
        }
        return hash;
    }

    public static int[][] create_all(int menge,int[] arr){
        int[][] all = new int[menge][4];
        for (int einz = 0; einz < menge; einz++) {
            int[] h = new int[4];
            for (int a = 0;a < 5;a++){
                h[0] = arr[0+a*einz]; //alle karten
                h[1] = arr[1+a*einz]; //alle karten
                h[2] = arr[2+a*einz]; //alle karten
                h[3] = arr[3+a*einz]; //alle karten
            }
            all[einz] = h;
        }
        return all;
    }
}

/*

    private boolean zustimmen;

    private boolean player;

    private Integer spieler;

    protected Integer zeit;

    public Integer getZeit() {
        return zeit;
    }


    private void zieheKarte() {
        zustimmen = !zustimmen;
        Integer turnOnTime;

        System.out.println("Karte ziehen?");

        if (!zustimmen)
            turnOnTime = new Date().getTime();
        else
            System.out.println("Deine zufällige Karte ist ");
            deck.put(basic[(new Date().getTime() - turnOnTime) % super.karten.size()]);

    }

    public void abfrage() {
        if (player)
            spieler = 1;
        else
            spieler = 2;
        System.out.println("Spieler "+ spieler +" ist an der Reihe." );
    }
}


 */