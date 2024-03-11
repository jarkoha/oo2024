public class Esindus {
    Auto auto; //klassikomplekt
    int maksumus;
    String esindus;

    public Esindus(Auto auto, int maksumus, String esindus) {
        this.auto = auto;
        this.maksumus = maksumus;
        this.esindus = esindus;
    }

    public void muudaEsindust(String esindus) {
        this.esindus = esindus;
    }

    public int paneAllahindlus(int allahindlus) {
        this.maksumus = this.maksumus - allahindlus;
        return this.maksumus;
    }
}
