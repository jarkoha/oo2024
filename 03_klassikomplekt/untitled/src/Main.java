//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ühe klassi sees teine klass
        //klasside sisse omadused

        Auto auto = new Auto("Mersu", "E63 AMG", 151211, 6.3);
        Esindus esindus = new Esindus(auto , 90000, "Rohe auto");
        esindus.muudaEsindust("Silberauto");
        esindus.auto.muudaMarki("Mercedes-Benz");


        Esindus auto2 = new Esindus(
                new Auto("Ford", "Focus", 40000, 1.6),
                24000, "Infoauto");
        auto2.paneAllahindlus(5000);

        System.out.println(auto.mark);
        System.out.println(esindus.esindus);
        System.out.println(auto2.maksumus);


    }
}