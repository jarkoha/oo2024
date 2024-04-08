package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class KodutooEntityController {

    KodutooRepository kodutooRepository;
    public KodutooEntityController(KodutooRepository kodutooRepository) {
        this.kodutooRepository = kodutooRepository;
    }

    @GetMapping("numbrid")
    public List<KodutooEntity> saaNumbrid(){
        return kodutooRepository.findAll();
    }

    @PostMapping("numbrid/{nimetus}/{number}/{paaris}/{algarv}")
    public List<KodutooEntity> lisaNumber(
            @PathVariable String nimetus,
            @PathVariable int number,
            @PathVariable boolean paaris
            ) {
            KodutooEntity number1 = new KodutooEntity(nimetus, number, paaris);
            kodutooRepository.save(number1);
            return kodutooRepository.findAll();
    }

    @PostMapping("numbrid")
    public List<KodutooEntity> lisaNumber(@RequestBody KodutooEntity kodutooEntity) {
        /*if (kodutooEntity.algarv) {
            return kodutooRepository.findAll();
        }*/
        kodutooRepository.save(kodutooEntity);
        return kodutooRepository.findAll();
    }

    @DeleteMapping("numbrid/{nimi}")
    public List<KodutooEntity> kustutaNumber(
            @PathVariable String nimi
    ){
        kodutooRepository.deleteById(nimi);
        return kodutooRepository.findAll();
    }

    @PutMapping("numbrid")
    public List<KodutooEntity> muudaNumbrid(
            @RequestParam int index,
            @RequestParam String nimetus,
            @RequestParam int number,
            @RequestParam boolean paaris
            ) {
            KodutooEntity number1 = new KodutooEntity(nimetus, number, paaris);
            kodutooRepository.save(number1);
            return kodutooRepository.findAll();

    }

    @GetMapping("numbrid/summa")
    public int liidaNumbrid() {
        /*int sum = 0;
        for (KodutooEntity entity : numbrid) {
            sum += entity.getNumber();
        }
        return sum;*/
        return kodutooRepository.findAll().stream().mapToInt(KodutooEntity::getNumber).sum();
    }

}
