import java.util.Random;

public class Mangija extends Tegelane implements JuhuslikKoordinaat { //tegelane on mängija ülemklass, igal klassil saab olla üks ülemklass
    Suund suund;
    Ese ese; //klassikomplekt
    Soiduk soiduk;

    public Mangija(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius); //saab väärtuse
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'x';
        suund = Suund.YLES;
    }

    public void liigu(String sisend, Maailm maailm) {
        switch (sisend) {
            case "w" -> suund = Suund.YLES;
            case "s" -> suund = Suund.ALLA;
            case "a" -> suund = Suund.VASAKULE;
            case "d" -> suund = Suund.PAREMALE;
        } // switch() sulgkinni
        switch (suund) {
            case YLES -> {
                if (yCoord > 1) yCoord--;
            }
            case ALLA -> {
                if (yCoord < maailm.kaardiKorgus - 2) yCoord++;
            }
            case VASAKULE -> {
                if (xCoord > 1) xCoord--;
            }
            case PAREMALE -> {
                if (xCoord < maailm.kaardiLaius - 2) xCoord++;
            }
        }
    } // liigu() sulgkinni
    public int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} //mangja sulgkinni

