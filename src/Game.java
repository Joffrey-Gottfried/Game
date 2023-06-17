import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.DateTime;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.TextField;

import java.util.Arrays;
import java.util.HashMap;

public class Game{

    public static String[] karts = new String[Deck.deck.size()];
    public HashMap buttons = new HashMap();

    public HashMap card_disp(HashMap nam,int width,int height){
        for (int i = 0;i < nam.size();i++){
            int[] a = {100,100,10 + ((width / 10) * i), 10 + ((height / 10) * i)};
            buttons.put(nam.keySet().toArray()[i],a);
        }
        return buttons;
    }

    public static boolean red = false;
    public static HashMap hand = new HashMap();

    protected Integer zeit;

    public static HashMap spielen = new HashMap();
    public static String last = new String();

    public static void main() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Game on");

        Point size = shell.getSize();
        int width = size.x;
        int height = size.y;

        Color blue = display.getSystemColor(SWT.COLOR_BLUE);
        Color green = display.getSystemColor(SWT.COLOR_GREEN);
        Color brown = display.getSystemColor(SWT.COLOR_GRAY);
        Color cyan = display.getSystemColor(SWT.COLOR_CYAN);
        Color magenta = display.getSystemColor(SWT.COLOR_DARK_MAGENTA);
        Color black = display.getSystemColor(SWT.COLOR_BLACK);

        Button ziehen = new Button(shell, SWT.PUSH);
        ziehen.setBackground(blue);
        ziehen.setForeground(green);
        ziehen.setText("ziehen");
        ziehen.setBounds(0,0,width/10,height/10);
        ziehen.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Instant end = Instant.now();
                Duration duration = Duration.between(Deck.start, end);
                int sec = (int) duration.getSeconds();
                if (Deck.deck.size() != 0){
                    if (hand.size() >= 1) {
                        int seconds = sec % Deck.deck.size();
                        Set<String> keys = Deck.deck.keySet();
                        List<String> keyList = Arrays.asList(keys.toArray(new String[0]));

                        System.out.println(seconds);
                        Object nas = keyList.get(seconds);
                        hand.put(nas,Deck.deck.get(nas));
                        Deck.deck.remove(nas);
                        System.out.println(hand);
                        red = true;
                    } else {
                        Random rng = new Random();
                        int seconds = rng.nextInt(Deck.deck.size() - 1);
                        Set<String> keys = Deck.deck.keySet();
                        List<String> keyList = Arrays.asList(keys.toArray(new String[0]));

                        System.out.println(seconds);
                        Object nas = keyList.get(seconds);
                        hand.put(nas, Deck.deck.get(nas));
                        Deck.deck.remove(nas);
                        System.out.println(hand);
                        red = true;
                    }
                }
                else{
                    System.out.println("Keine Karten mehr");
                }
            }
        });

        Button play = new Button(shell,SWT.PUSH);
        play.setBackground(magenta);
        play.setForeground(green);
        play.setText("Spielen");
        play.setBounds(width-155,0,width/10,height/10);
        play.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                System.out.println("Play");
            }
        });

        /*
        Composite composite3 = new Composite(shell, SWT.NONE); //composite zeigt werte an
        composite3.setBackground(cyan);
        composite3.setBounds(width-300,height-150,400,150);
*/

        for (int i = 0;i < hand.size();i++){
            Button button = new Button(shell, SWT.PUSH);
            int[] a = {100,100,10 + ((width / 10) * i), 10 + ((height / 10) * i)};
            Object ad = hand.keySet().toArray()[i];
            String as = ad.toString();
            button.setBackground(green);
            button.setForeground(black);
            button.setText(as);
            button.setBounds(200+(200*i),height/90,10 + ((width / 10)), 10 + ((height / 10)));
            button.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    Object b = hand.get(as);
                    /*
                    System.out.printl(b.toString());

                    Label wert = new Label(composite3, SWT.None);
                    wert.setBounds(width-300,height-150,400,150);
                    wert.setBackground(brown);
                    wert.setText(b.toString());

                    TextField text = new TextField();
                    text.setBounds(width-300,height-150,400,150);
                    text.setForeground(java.awt.Color.BLACK);
                    shell.redraw();

                     */
                    last = b.toString();
                    spielen.put(as,b);
                    hand.remove(b);

                    Button tex = new Button(shell, SWT.NONE);
                    tex.setForeground(black);
                    tex.setText(b.toString());
                    tex.setBackground(cyan);
                    tex.setBounds(width-300,height-150,300,100);
                   /*
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        tex.dispose();
                    }catch (InterruptedException exc){
                    }
                    */
                }
            });
        }


        Composite composite1 = new Composite(shell, SWT.NONE); //zeigt hand an
        composite1.setBackground(brown);
        composite1.setBounds(0,0,width,height/5);
/*
        Composite composite2 = new Composite(shell, SWT.NONE); //zeigt gegner an
        composite2.setBackground(brown);
        composite2.setBounds(0,height-150,width,height/5);


 */

        shell.open();
        while (!shell.isDisposed()) {
            if (red = true) {
                shell.redraw();
                red = false;
            }
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}