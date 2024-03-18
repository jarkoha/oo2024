import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.*;
import java.util.Map;

//A-tähed tekstis
//* Loe programmi abil kokku, kui palju on tekstifailis a-tähti (nii suuri kui väikeseid).
// Kokku lugemiseks kasuta omaloodud klassi välja kutsutud funktsiooni.

//* Leia, kui palju oli a-tähti igas sõnas, sõnades keskmiselt, suhtarvuna tähtede üldarvu
// ning pane nad klassi muutujatesse. Kuva välja "sout" abil ning kirjuta ka tulem tekstifaili.

//* Loe kokku, mitu sõna oli ühe, kahe, kolme jne a-tähega. Koosta tekstifaili lihtsakoeline
// tabel, kus ridadeks tähtede arv sõnas ning veergudeks a-tähtede arv. Lahtris näidatakse,
// mitu vastavat sõna oli tekstis.

public class Main {
    public static void main(String[] args) {
        String filePath = "tekst.txt";
        BufferedReader br;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            String rida = br.readLine();
            while (rida != null) {
                sb.append(rida).append(System.lineSeparator());
                rida = br.readLine();
            }

            br.close();

            String kogutekst = sb.toString();

            // Tulemuste arvutamine
            int[] counts = tahtedelugemine.countAs(kogutekst);
            tahtedelugemine.loeSonadesA(kogutekst);
            double average = tahtedelugemine.keskmineASonades;
            double aSuhtarv = tahtedelugemine.suhtarvA;
            Map<Integer, Map<Integer, Integer>> kategoriseerimiseTabel = tahtedelugemine.sonadePikkusedTaheAEsinemine(kogutekst);

            // Tulemuste printimine
            System.out.println("Suuri 'A' tähtesid: " + counts[0]);
            System.out.println("Väikseid 'a' tähtesid: " + counts[1]);
            tahtedelugemine.sonadeArv.forEach((word, count) -> System.out.println("Sõna: \"" + word + "\" sisaldab 'a' või 'A': " + count));
            System.out.println("Keskmiselt 'a' või 'A' sõnades: " + average);
            System.out.println("A suhtarv tähtede üldarvuga: " + aSuhtarv);
         

            // Teksti faili kirjutamine
            bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.newLine();
            bw.newLine();
            bw.write("Suuri 'A' tähtesid: " + counts[0] + "\n");
            bw.write("Väikseid 'a' tähtesid: " + counts[1] + "\n");
            for (Map.Entry<String, Integer> entry : tahtedelugemine.sonadeArv.entrySet()) {
                bw.write("Sõna: \"" + entry.getKey() + "\" sisaldab 'a' või 'A': " + entry.getValue() + "\n");
            }
            bw.write("Keskmiselt 'a' või 'A' sõnades: " + average + "\n");
            bw.write("A suhtarv tähtede üldarvuga: " + aSuhtarv + "\n");
            bw.newLine();

            // Tabeli tegemine
            bw.write("Sõnade pikkus vs. 'a' tähtede arv:\n");
            // Tulbad
            int maxALoend = kategoriseerimiseTabel.values().stream()
                    .flatMap(m -> m.keySet().stream())
                    .max(Integer::compare)
                    .orElse(0);
            bw.write("Pikkus\\'a'");
            for (int i = 0; i <= maxALoend; i++) {
                bw.write("\t" + i + " a");
            }
            bw.newLine();

            // Read
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : kategoriseerimiseTabel.entrySet()) {
                bw.write(entry.getKey() + " tähte      ");
                for (int i = 0; i <= maxALoend; i++) {
                    bw.write("\t" + entry.getValue().getOrDefault(i, 0));
                }
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}