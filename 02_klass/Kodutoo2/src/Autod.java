public class Autod {
    String mudel;
    int aasta;
    double vaartusUuena;
    double protsent;

    public Autod(String mudel, int aasta, double vaartusUuena, double protsent) {
        this.mudel = mudel;
        this.aasta = aasta;
        this.vaartusUuena = vaartusUuena;
        this.protsent = protsent;
    }
    public String nimi () {
        if (aasta < 2005) {
            mudel = "Vana " +mudel;
        } else if (aasta >= 2020) {
            mudel = "Uus " +mudel;
        } else {
            mudel = mudel;
        }
        return mudel;
    }

    public double erinevus(double vaartusPraegu) {
        protsent = ((vaartusPraegu/vaartusUuena)-1)*100;
        return protsent;
    }

}
