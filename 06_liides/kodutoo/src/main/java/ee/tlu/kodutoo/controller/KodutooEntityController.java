package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.entity.KodutooEntity;
import ee.tlu.kodutoo.repository.KodutooRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class KodutooEntityController {

    KodutooRepository kodutooRepository;
    public KodutooEntityController(KodutooRepository kodutooRepository) {
        this.kodutooRepository = kodutooRepository;
    }

    @GetMapping("planeedid")
    public List<KodutooEntity> saaPlaneedid(){
        return kodutooRepository.findAll();
    }

    @PostMapping("planeedid/{nimetus}/{labimoot}/{kaugus}")
    public List<KodutooEntity> lisaPlaneet(
            @PathVariable String nimetus,
            @PathVariable int labimoot,
            @PathVariable int kaugus
            ) {
            KodutooEntity number1 = new KodutooEntity(nimetus, labimoot, kaugus);
            kodutooRepository.save(number1);
            return kodutooRepository.findAll();
    }

    @PostMapping("planeedid")
    public List<KodutooEntity> lisaPlaneet(@RequestBody KodutooEntity kodutooEntity) {
        kodutooRepository.save(kodutooEntity);
        return kodutooRepository.findAll();
    }

    @DeleteMapping("planeedid/{nimi}")
    public List<KodutooEntity> kustutaPlaneet(
            @PathVariable String nimi
    ){
        kodutooRepository.deleteById(nimi);
        return kodutooRepository.findAll();
    }

    @PutMapping("planeedid")
    public List<KodutooEntity> muudaPlaneet(
            @RequestParam int index,
            @RequestParam String nimetus,
            @RequestParam int labimoot,
            @RequestParam int kaugus
            ) {
            KodutooEntity planeet1 = new KodutooEntity(nimetus, labimoot, kaugus);
            kodutooRepository.save(planeet1);
            return kodutooRepository.findAll();

    }


}
