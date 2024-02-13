//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //main klass + enda tehtud klass
        //klassis konstruktor
        //vähemalt kaks omadust (nimi, aktiivne ...)
        //vähemalt kaks funktsiooni
        //mainis vähemalt kaks instantsi temast
        //mainis vähemalt 2 funktsiooni välja kutset.
    Kasutaja kasutaja = new Kasutaja("Jarl", true, 27, 'j',0.0);
    Kasutaja kasutaja2 = new Kasutaja("Tarvi", false, 42, 't',0.5);

    kasutaja.muudaAktiivne();
        System.out.println(kasutaja.aktiivne);
    double kasutaja2Raha = kasutaja2.lisaRaha(500);
        System.out.println(kasutaja2Raha);

    }
}