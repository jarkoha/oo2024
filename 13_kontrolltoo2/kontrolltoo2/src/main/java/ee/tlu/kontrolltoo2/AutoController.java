package ee.tlu.kontrolltoo2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AutoController {

    AutoRepository autoRepository;
    public AutoController(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @GetMapping("autod")
    public List<AutoEntity> saaAutod(){
        return autoRepository.findAll();
    }

    @PostMapping("autod")
    public List<AutoEntity> lisaAuto(@RequestBody AutoEntity autoEntity) {
        autoRepository.save(autoEntity);
        return autoRepository.findAll();
    }

    @DeleteMapping("autod/{mark}")
    public List<AutoEntity> kustutaAuto(@PathVariable String mark) {
        autoRepository.deleteById(mark);
        return autoRepository.findAll();
    }

    @GetMapping("autod-aasta/{aasta}")
    public List<AutoEntity> autodAastaJargi(@PathVariable int aasta) {
        return autoRepository.findByAasta(aasta);
    }

    @GetMapping("autod-pikkus/{min}/{max}")
    public List<AutoEntity> autodPikkusega(@PathVariable float min, @PathVariable float max) {
        return autoRepository.findByPikkusBetween(min, max);
    }

    @GetMapping("koige-raskem-auto")
    public AutoEntity maxRaskusegaAuto() {
        return autoRepository.findFirstByMassNotNullOrderByMassDesc();
    }

}

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