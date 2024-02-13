import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //saab endale terve hunniku funktsioone ja muutujaid
        //klass
        Random random = new Random();

        Maailm maailm = new Maailm(5, 10);

        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);


        // import java.util.Scanner;
        // klass
        Scanner scanner = new Scanner(System.in); // 2. tund selgitame lähemalt

        maailm.prindiKaart(mangija, draakon, ork);
        String sisend = scanner.nextLine();

        //mangija.liigu() funktsiooni väljakutsumine tuleb siia
        mangija.liigu(sisend, maailm);


        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            maailm.prindiKaart(mangija, draakon, ork);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
        }
    } // main (args[])
    //private static int saaKoordinaat(Random random, int kaart) {
    //    return random.nextInt(1, kaart - 1);
    //}
} // Main ()