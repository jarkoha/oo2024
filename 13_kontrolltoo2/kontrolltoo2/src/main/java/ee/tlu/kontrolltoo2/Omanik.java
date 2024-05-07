package ee.tlu.kontrolltoo2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Omanik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimetus;

}

//• Loo andmebaasi võimalus hoiustada Omanikku.
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