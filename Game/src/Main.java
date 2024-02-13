import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //saab endale terve hunniku funktsioone ja muutujaid
        //klass
        Random random = new Random();

        int kaardiKorgus = 5;
        int kaardiLaius = 10;
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Mangija mangija = new Mangija();

        int draakonXCoord = saaKoordinaat(random, kaardiLaius);
        int draakonYCoord = saaKoordinaat(random, kaardiKorgus);
        char draakonSymbol = 'D';

        int orkXCoord = saaKoordinaat(random, kaardiLaius);
        int orkYCoord = saaKoordinaat(random, kaardiKorgus);
        char orkSymbol = 'O';

        // import java.util.Scanner;
        // klass
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt

        prindiKaart(kaardiKorgus, kaardiLaius, mangija, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
        String sisend = scanner.nextLine();

        //mangija.liigu() funktsiooni väljakutsumine tuleb siia

//        if (sisend.equals("w")) {
//            mangijaYCoord--;
//        } else if (sisend.equals("s")) {
//            mangijaYCoord++;
//        }  else if (sisend.equals("a")) {
//            mangijaXCoord--;
//        } else if (sisend.equals("d")) {
//            mangijaXCoord++;
//        }

        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            prindiKaart(kaardiKorgus, kaardiLaius, mangija, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);
            sisend = scanner.nextLine();
            mangija.liigu();
        }



    } // main (args[])

    private static void prindiKaart(int kaardiKorgus, int kaardiLaius, Mangija mangija, int draakonXCoord, int draakonYCoord, char draakonSymbol, int orkXCoord, int orkYCoord, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mangija.mangijaXCoord && y == mangija.mangijaYCoord) {
                        symbol = mangija.mangijaSymbol;
                    } else if (x == draakonXCoord && y == draakonYCoord) {
                        symbol = draakonSymbol;
                    } else if (x == orkXCoord && y == orkYCoord) {
                        symbol = orkSymbol;
                    } else  {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} // Main ()