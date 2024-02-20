import java.util.ArrayList;
import java.util.List;
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
        List<Tegelane> tegelased = new ArrayList<>();
        tegelased.add(mangija);
        tegelased.add(draakon);
        tegelased.add(ork);

        Ese m66k = new Ese("Mõõk", 10, 1, random, maailm);
        Ese haamer = new Ese("Haamer", 5, 3, random, maailm);
        Ese saabas = new Ese("Saabas", 1, 5, random, maailm);
        List<Ese> esemed = new ArrayList<>();
        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);

        // import java.util.Scanner;
        // klass
        Scanner scanner = new Scanner(System.in); // 2. tund selgitame lähemalt

        maailm.prindiKaart(tegelased, esemed);
        String sisend = scanner.nextLine();

        //mangija.liigu() funktsiooni väljakutsumine tuleb siia
        mangija.liigu(sisend, maailm);


        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            maailm.prindiKaart(tegelased, esemed);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
            for (Ese e : esemed) {
                if (mangija.xCoord == e.xCoord && mangija.yCoord == e.yCoord) {
                    mangija.ese = e;
                    System.out.println("Korjasid üles eseme: " + e.nimetus);
                    break;
                }
            }
        }
    } // main (args[])
    //private static int saaKoordinaat(Random random, int kaart) {
    //    return random.nextInt(1, kaart - 1);
    //}
} // Main ()