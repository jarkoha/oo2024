package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.entity.Planeedikomponent;
import ee.tlu.kodutoo.repository.PlaneedikomponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class PlaneedikomponentController {
    @Autowired
    PlaneedikomponentRepository planeedikomponentRepository;

    @GetMapping("planeedikomponendid")
    public List<Planeedikomponent> getPlaneedikomponendid() {
        return planeedikomponentRepository.findAll();
    }

    @DeleteMapping("planeedikomponendid/{id}")
    public List<Planeedikomponent> deletePlaneedikomponent(@PathVariable Long id) {
        planeedikomponentRepository.deleteById(id);
        return planeedikomponentRepository.findAll();
    }

    @PostMapping("planeedikomponendid")
    public List<Planeedikomponent> lisaPlaneedikomponent(@RequestBody Planeedikomponent planeedikomponent){
        planeedikomponentRepository.save(planeedikomponent);
        return planeedikomponentRepository.findAll();
    }

}
