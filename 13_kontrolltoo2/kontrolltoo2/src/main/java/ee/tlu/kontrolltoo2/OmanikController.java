package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OmanikController {

    @Autowired
    OmanikRepository omanikRepository;
    @Autowired
    AutoRepository autoRepository;

    @GetMapping("omanikud")
    public List<Omanik> getOmanikud() {
        return omanikRepository.findAll();
    }

    @PostMapping("omanikud")
    public List<Omanik> postOmanik(@RequestBody Omanik omanik) {
        omanikRepository.save(omanik);
        return omanikRepository.findAll();
    }


}
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