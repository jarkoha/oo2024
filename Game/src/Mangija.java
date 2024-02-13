public class Mangija {
    int mangijaXCoord = saaKoordinaat(random, kaardiLaius);
    int mangijaYCoord = saaKoordinaat(random, kaardiKorgus);
    char mangijaSymbol = 'x';

    public void liigu() {
        switch (sisend) {
            case "w" -> mangijaYCoord--;
            case "s" -> mangijaYCoord++;
            case "a" -> mangijaXCoord--;
            case "d" -> mangijaXCoord++;
        } // switch() sulgkinni
    } // liigu() sulgkinni
} //mangja sulgkinni

