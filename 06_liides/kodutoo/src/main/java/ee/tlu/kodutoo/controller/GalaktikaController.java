package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.entity.Galaktika;
import ee.tlu.kodutoo.repository.GalaktikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GalaktikaController {

    @Autowired
    GalaktikaRepository galaktikaRepository;

    @GetMapping("galatika")
    public List<Galaktika> getGalaktikad() {
        return galaktikaRepository.findAll();
    }

    @DeleteMapping("galatika/{id}")
    public List<Galaktika> deleteGalaktika(@PathVariable Long id) {
        galaktikaRepository.deleteById(id);
        return galaktikaRepository.findAll();
    }

    @PostMapping("galatika")
    public List<Galaktika> addGalaktika(@RequestBody Galaktika galaktika) {
        galaktikaRepository.save(galaktika);
        return galaktikaRepository.findAll();
    }
}
