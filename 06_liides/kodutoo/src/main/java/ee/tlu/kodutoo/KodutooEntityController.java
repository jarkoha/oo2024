package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class KodutooEntityController {
    List<KodutooEntity> numbrid = new ArrayList<>();

    @GetMapping("numbrid")
    public List<KodutooEntity> saaNumbrid(){
        return numbrid;
    }

    @PostMapping("numbrid/{nimetus}/{number}/{paaris}")
    public List<KodutooEntity> lisaNumber(
            @PathVariable String nimetus,
            @PathVariable int number,
            @PathVariable boolean paaris
            ) {
            KodutooEntity number1 = new KodutooEntity(nimetus, number, paaris);
            numbrid.add(number1);
            return numbrid;
    }

    @DeleteMapping("numbrid/{index}")
    public List<KodutooEntity> kustutaNumber(
            @PathVariable int index
    ){
        numbrid.remove(index);
        return numbrid;
    }

    //ei tööta miskipärast
    @PutMapping("numbrid")
    public List<KodutooEntity> muudaNumbrid(
            @RequestParam int index,
            @RequestParam String nimetus,
            @RequestParam int number,
            @RequestParam boolean paaris
            ) {
            KodutooEntity number1 = new KodutooEntity(nimetus, number, paaris);
            numbrid.set(index, number1);
            return numbrid;

    }

}
