package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ToiduaineEntityController {

    ToiduaineRepository toiduaineRepository;
    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository) {
        this.toiduaineRepository = toiduaineRepository;
    }

    //List<ToiduaineEntity> toiduained = new ArrayList<>();

    //localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained(){
        return toiduaineRepository.findAll();
    }

    //localhost:8080/api/toiduained/kartul/5/3/10
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduaine(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
            ) {
            if (valk + rasv + sysivesik > 100) {
                return toiduaineRepository.findAll();
            }
            ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
            toiduaineRepository.save(toiduaine);
            return toiduaineRepository.findAll();
    }

    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.valk + toiduaineEntity.rasv + toiduaineEntity.sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

    //localhost:8080/api/toiduained?index=0&nimi=kartul&valk=5&rasv=3&sysivesik=10
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
            ){
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        //toiduained.set(index, toiduaine);
        toiduaineRepository.save(toiduaine); //täpselt sama mis POST
        // Hibernate kontrollib, kas on sellise primary key'ga element andmebaasis. Kui on, siis muudab, kui ei ole, siis lisab
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduained/{nimi}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi){
        return toiduaineRepository.findById(nimi).get();
    }

    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv(){
        return toiduaineRepository.findAll().size();
    }

    @GetMapping("toiduained-valk-min/{minValk}")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int minValk) {
        return toiduaineRepository.findAllByValkGreaterThan(minValk);
    }

    @GetMapping("toiduained-sysivesik/{min}/{max}")
    public List<ToiduaineEntity> toiduainedSysivesik(@PathVariable int min, @PathVariable int max) {
        return toiduaineRepository.findAllBySysivesikBetween(min, max);
    }

}

// 404 - URL ehk API otspunkt on vale
// 4xx - Front-endi viga
// 5xx - Back-endi viga, serveripoolne viga