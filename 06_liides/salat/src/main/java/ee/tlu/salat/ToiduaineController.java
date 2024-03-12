package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToiduaineController {
    List<String> toiduained = new ArrayList<>(); //imiteerime andmebaasi

    //localhost:8080/saa-toiduained ---> []
    @GetMapping("toiduained")
    public List<String> saaToiduained(){
        return toiduained;
    }

    //PostMappingut ei saa brauser teha
    //localhost:8080/toiduained/Kartul POST
    @PostMapping("toiduained/{toiduaine}")
    public List<String> lisaToiduaine(@PathVariable String toiduaine) {
        toiduained.add(toiduaine);
        return toiduained;
    }

    //DeleteMappingut ei saa brauser teha
    //localhost:8080/toiduained/0 DELETE
    @DeleteMapping("toiduained/{index}")
    public List<String> kustutaToiduaine(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }

    //PutMappingut ei saa brauser teha
    //localhost:8080/toiduained/0/Kartul
    @PutMapping("toiduained/{index}/{newValue}")
    public List<String> muudaToiduaine(@PathVariable int index, @PathVariable String newValue) {
        toiduained.set(index, newValue);
        return toiduained;
    }

    @GetMapping("toiduained/{index}")
    public String saaYksToiduaine(@PathVariable int index){
        return toiduained.get(index);
    }


    //läheb käima, kui minnakse localhost:8080/tere/"nimi"
    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi) {
        return "Tere " + nimi;
    }

    //läheb käima, kui minnakse localhost:8080/korruta/x/x
    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2) {
        return arv1*arv2;
    }
}

// 404 - URL ehk API otspunkt on vale
// 4xx - Front-endi viga
// 5xx - Back-endi viga, serveripoolne viga