import java.util.HashMap;
import java.util.Map;

public class tahtedelugemine {
    public static Map<String, Integer> sonadeArv = new HashMap<>();
    public static double keskmineASonades = 0.0;
    public static double suhtarvA = 0.0;

    // Loeb mitu suurt ja väikest a'd on tekstis
    public static int[] countAs(String text) {
        int suurA = 0;
        int vaikeA = 0;

        for (char ch : text.toCharArray()) {
            if (ch == 'A') {
                suurA++;
            } else if (ch == 'a') {
                vaikeA++;
            }
        }
        // A esinemine võttes arvesse tähtede kogu arvu
        suhtarvA = (double) (suurA + vaikeA) / text.replaceAll("\\s+", "").length();
        return new int[]{suurA, vaikeA};
    }

    //Palju esineb sõnas A'd ja/või a'd kokku
    public static void loeSonadesA(String text) {
        sonadeArv.clear();
        String[] sonad = text.split("\\s+");
        for (String sona : sonad) {
            int loe = 0;
            for (char ch : sona.toCharArray()) {
                if (ch == 'A' || ch == 'a') {
                    loe++;
                }
            }
            sonadeArv.put(sona, loe);
        }
        keskmiseltASonades();
    }

    // A esinemise arvutamine sõnades keskmiselt
    public static void keskmiseltASonades() {
        double total = 0;
        for (int count : sonadeArv.values()) {
            total += count;
        }
        keskmineASonades = sonadeArv.size() > 0 ? total / sonadeArv.size() : 0;
    }

    public static Map<Integer, Map<Integer, Integer>> sonadePikkusedTaheAEsinemine(String text) {
        Map<Integer, Map<Integer, Integer>> table = new HashMap<>();
        String[] sonad = text.split("\\s+");

        for (String sona : sonad) {
            int pikkus = sona.length();
            int aLoend = 0;
            for (char ch : sona.toCharArray()) {
                if (ch == 'A' || ch == 'a') {
                    aLoend++;
                }
            }

            table.putIfAbsent(pikkus, new HashMap<>());
            table.get(pikkus).put(aLoend, table.get(pikkus).getOrDefault(aLoend, 0) + 1);
        }

        return table;
    }


}
