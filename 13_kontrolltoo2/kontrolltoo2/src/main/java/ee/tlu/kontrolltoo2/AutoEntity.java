package ee.tlu.kontrolltoo2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


//Tee uus veebiprojekt.
// Loo klass (entity) auto andmete hoidmiseks (mark,
// pikkus, mass ning aasta). Primaarvõtmeks pane kas nimetus
// või automaatselt genereeritud ID – valik on sinu).
// Tee auto jaoks nii Repository kui ka Controller ning
// loo andmebaasiühendus.
// Võimalda autosid võtta andmebaasist, lisada andmebaasi
// kui ka kustutada andmebaasist.
// Tee võimalikult lihtne front-end Reactis, mis võimaldab
// nii võtta, lisada kui ka kustutada andmebaasist läbi Java back-endi.
//
// • Tee 3 API otspunkti, mis võimaldab välja kuvada autosid
// aasta järgi (sisestad aasta ja tagastatakse kõik selle aasta autod),
// andes vahemiku pikkuse jaoks (2 numbrit ning
// tagastatakse kõik autod selles vahemikus) ning
// kõige suurema massiga auto.

// Tee RestTemplate päring siia API otspunkti:
// https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100
// Tee 3 API otspunkti front-endile:
// 1) kas kõik autod Listina
// 2) võimalus sisestada bränd ning antakse kõik seda
// marki autod (sisestades “Honda”)
// 3) Listina võtmed “make” + “model” kokkuliidetuna
// (midagi muud ei ole – ei aastat, id-d jne),
// ainult Stringide List.
// Tee RestTemplate päring siia API otspunkti: https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers
// Näita eraldi API otspunktides kõige väiksema keskmise
// hobujõuga autot, kõige suurema keskmise hinnaga autot,
// kõik autod väiksema keskmise hinnaga kui sisestatud hind,
// kõik autod suurema keskmise hobujõuga kui sisestatud hobujõud
// ja kõik autod sisestatud hinnavahemikus (5 erinevat API otspunkti).
//
// • Loo andmebaasi võimalus hoiustada Omanikku.
// Omadusteks anna omanikule nimetus (Primaarvõtmeks pane kas
// nimetus või automaatselt genereeritud ID – valik on sinu).
// Tee seos Auto sisse – lisa auto tabelisse Omanik.
// Võimalda omaniku kõiki autosid väljastada. Väljasta API
// otspunktide kaudu kõige pikemat ja kõige raskemat autot
// Omaniku osas küsida, andes sisendiks Omaniku.
// Kontrolli uue sõiduauto lisamise puhul, et mass ei
// ületaks viite tonni ning ära lase lisada kui see juhtub.
// Kontrolli auto lisamisel, et ühel omanikul ei oleks üle 3
// autoga ning ära lase autot lisada kui see juhtub.
@Getter
@AllArgsConstructor
@Table(name = "auto")
@Entity
@NoArgsConstructor
public class AutoEntity {
    @Id
    private String mark;
    private float pikkus;
    private int mass;
    private int aasta;

    @ManyToOne
    private Omanik omanik;
}