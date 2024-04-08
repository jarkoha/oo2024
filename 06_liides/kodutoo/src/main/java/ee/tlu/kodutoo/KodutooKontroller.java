package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KodutooKontroller {

    List<Integer> numbrid = new ArrayList<>();

    @GetMapping("numbrid")
    public List<Integer> saaNumbrid() {
        return numbrid;
    }

    @PostMapping("numbrid/{number}")
    public List<Integer> lisaNumber(@PathVariable int number) {
        numbrid.add(number);
        return numbrid;
    }

    @DeleteMapping("numbrid/{index}")
    public List<Integer> kustutaNumber(@PathVariable int index) {
        numbrid.remove(index);
        return numbrid;
    }

    @GetMapping("numbrid/loendur")
    public int loeNumbrid() {
        return numbrid.size();
    }

    @GetMapping("numbrid/summa")
    public int summa() {
        int sum = 0;
        for (int number : numbrid) {
            sum += number;
        }
        return sum;
    }

    @GetMapping("numbrid/keskmine")
    public double keskmine() {
        if (numbrid.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for(int number : numbrid) {
            sum += number;
        }
        return (double) sum / numbrid.size();
    }

}
