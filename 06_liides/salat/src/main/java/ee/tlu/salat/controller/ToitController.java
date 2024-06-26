package ee.tlu.salat.controller;

import ee.tlu.salat.entity.Toit;
import ee.tlu.salat.repository.ToitRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToitController {

    @Autowired
    ToitRepository toitRepository;

    //GetMapping
    @GetMapping("toit")
    public List<Toit> getToidud() {
        return toitRepository.findAll();
    }

    //Delete
    @DeleteMapping("toit/{id}")
    public List<Toit> deleteToit(@PathVariable Long id) {
        toitRepository.deleteById(id);
        return toitRepository.findAll();
    }

    //Lisamine
    @PostMapping("toit")
    public List<Toit> addToit(@RequestBody Toit toit) {
        toitRepository.save(toit);
        return toitRepository.findAll();
    }
}
