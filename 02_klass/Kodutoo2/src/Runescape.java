public class Runescape {
    String kasutajanimi;
    int totalLevel;
    String staatus;

    public Runescape(String kasutajanimi, int totalLevel, String staatus) {
        this.kasutajanimi = kasutajanimi;
        this.totalLevel = totalLevel;
        this.staatus = staatus;
    }

    public String pikkus() {
        if (kasutajanimi.length() > 6) {
            kasutajanimi = kasutajanimi + " on pigem pikk nimi.";
        } else {
            kasutajanimi = kasutajanimi + " on lühike nimi ja sul on sellega vedanud.";
        }
        return kasutajanimi;
    }

    public String staadium() {
        if (totalLevel <= 1000) {
            staatus = "Mängu algusfaas.";
        } else if (totalLevel > 1000 && totalLevel <= 1700){
            staatus = "Mängu keskpaik.";
        } else {
            staatus = "Mängu lõppfaas.";
        }
        return staatus;
    }

}
