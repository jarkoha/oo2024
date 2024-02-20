public class Autod {
    String mark;
    int aasta;
    double vaartusUuena;
    double protsent;

    public Autod(String mark, int aasta, double vaartusUuena, double protsent) {
        this.mark = mark;
        this.aasta = aasta;
        this.vaartusUuena = vaartusUuena;
        this.protsent = protsent;
    }
    public String nimi () {
        if (aasta < 2005) {
            mark = "Vana " +mark;
        } else if (aasta >= 2020) {
            mark = "Uus " +mark;
        } else {
            mark = mark;
        }
        return mark;
    }

    public double erinevus(double vaartusPraegu) {
        protsent = ((vaartusPraegu/vaartusUuena)-1)*100;
        return protsent;
    }

}
