package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumbrikomponentController {
    List<Numbrikomponent> numbrikomponendid = new ArrayList<>();

    @PostMapping("numbrikomponent")
    public List<Numbrikomponent> lisaNumbrikomponent(@RequestBody Numbrikomponent komponent){
        numbrikomponendid.add(komponent);
        return numbrikomponendid;
    }

    @PutMapping("numbrikomponent/{index}")
    public List<Numbrikomponent> muudaNumbrikomponent(@PathVariable int index, @RequestBody Numbrikomponent komponent) {
        numbrikomponendid.set(index, komponent);
        return numbrikomponendid;
    }
}
