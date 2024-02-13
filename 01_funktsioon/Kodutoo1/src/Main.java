//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Kodus kolm funktsiooni, milles on kasutatud vähemalt
        //nelja erinevat tüüpi:
        //void, String, int, char, long, double, float, boolean
        //tagastab int      parameetriks boolean
        //tagastab int      parameetriks boolean
        //tagastab String       parameetriks String

        //teha igast funktsioonist 2 erineva sisendiga väljakutset

        double kogumaksumus1 = traktoriRent(3, "K-rauta");
        System.out.println(kogumaksumus1 + " €/h");
        double kogumaksumus2 = traktoriRent(3, "EhituseABC");
        System.out.println(kogumaksumus2 + " €/h");

        sonadeVordlus("Eesti", "Autoratas");
        sonadeVordlus("Kass", "Koer");

        prindiOnne(27);
        prindiOnne(50);
    }

    private static double traktoriRent(int tunnid, String firma) {
        double tunniTasu;

        switch (firma) {
            case "K-rauta":
                tunniTasu = 2;
                break;
            case "EhituseABC":
                tunniTasu = 0.6;
                break;
            case "MERKO":
                tunniTasu = 1.7;
                break;
            default:
                tunniTasu = 1.0;
                break;
        }

        return 3 + tunniTasu * tunnid;
    }

    private static void sonadeVordlus(String sona1, String sona2) {
        int tahtedeArv1 = sona1.length();
        int tahtedeArv2 = sona2.length();
        if (tahtedeArv1 > tahtedeArv2) {
            System.out.println(sona1 + " on pikem sõna kui " + sona2);
        } else if (tahtedeArv1 < tahtedeArv2) {
            System.out.println(sona2 + " on pikem sõna kui " + sona1);
        } else {
            System.out.println("Molemad sonad on sama pikad.");
        }
    }

    private static void prindiOnne(int age) {
        for (int i = 0; i < age; i++) {
            System.out.println("Palju onne!");
        }
    }

}