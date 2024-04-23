package ee.tlu.proovikontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//application.properties failis tuleb muuta
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToodeController {

    @Autowired
    ToodeRepository toodeRepository;

    @GetMapping("tooted")
    public List<Toode> getTooted() {
        return toodeRepository.findAll();
    }

    @PostMapping("tooted")
    public List<Toode> postToode(@RequestBody Toode toode) {
        toodeRepository.save(toode);
        return toodeRepository.findAll();
    }

    @DeleteMapping("tooted/{id}")
    public List<Toode> deleteToode(@PathVariable Long id) {
        toodeRepository.deleteById(id);
        return toodeRepository.findAll();
    }

    @GetMapping("toote-hind-vahemik/{min}/{max}")
    public List<Toode> tooteHindVahemik(@PathVariable double min, @PathVariable double max) {
        return toodeRepository.findByHindBetween(min, max);
    }

    @GetMapping("max-hinnaga-toode")
    public Toode maxHinnagaToode() {
        return toodeRepository.findFirstByHindNotNullOrderByHindDesc();
    }

}
