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





    Autod autod = new Autod("Audi", 1995, 20000,0);
    Autod autod2 = new Autod("Volkswagen", 2022, 32000,0);

    String autodNimi = autod.nimi();
        System.out.println(autodNimi);
    String autod2Nimi = autod2.nimi();
        System.out.println(autod2Nimi);

    double autodVordlus = autod.erinevus(5000);
        System.out.println("Auto väärtus on muutunud " + autod.protsent + "%.");
    double autod2Vordlus = autod2.erinevus(40000);
        System.out.println("Auto väärtus on muutunud " + autod2.protsent + "%.");



    Runescape tegelane = new Runescape("TaevaTursk",1200, "" );
    Runescape tegelane2 = new Runescape("Olm", 2000, "");

    String nimePikkus = tegelane.pikkus();
        System.out.println(nimePikkus);
    String nimePikkus2 = tegelane2.pikkus();
        System.out.println(nimePikkus2);

    String manguStaadium = tegelane.staadium();
        System.out.println(manguStaadium);
    String manguStaadium2 = tegelane2.staadium();
        System.out.println(manguStaadium2);

    }
}