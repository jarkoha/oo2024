public class Auto {
    String mark;
    String mudel;
    int labisoit;
    double mootorimaht;

    public Auto(String mark, String mudel, int labisoit, double mootorimaht) {
        this.mark = mark;
        this.mudel = mudel;
        this.labisoit = labisoit;
        this.mootorimaht = mootorimaht;
    }

    public void muudaMarki(String uusMark) {
        mark = uusMark;
    }
}
