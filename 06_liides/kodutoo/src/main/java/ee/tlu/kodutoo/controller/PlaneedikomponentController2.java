/*package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.entity.Planeedikomponent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaneedikomponentController2 {
    List<Planeedikomponent> planeedikomponendid = new ArrayList<>();

    @PostMapping("planeedikomponent")
    public List<Planeedikomponent> lisaPlaneedikompnent(@RequestBody Planeedikomponent komponent) {
        planeedikomponendid.add(komponent);
        return planeedikomponendid;
    }

    @PutMapping("planeedikomponent/{index}")
    public List<Planeedikomponent> muudaPlaneedikomponent(@PathVariable int index, @RequestBody Planeedikomponent komponent) {
        planeedikomponendid.set(index, komponent);
        return planeedikomponendid;
    }
}*/
