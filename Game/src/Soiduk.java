import java.util.Random;

public class Soiduk {
    int kiirus;
    String nimetus;
    int xCoord;
    int yCoord;
    char symbol;

    public Soiduk(int kiirus, String nimetus, Random random, Maailm maailm) {
        this.kiirus = kiirus;
        this.nimetus = nimetus;
        xCoord = saaKoordinaat(random, maailm.kaardiLaius);
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'S';
    }


    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
