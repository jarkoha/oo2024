package ee.tlu.kodutoo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KodutooKontroller {

    List<String> planeedid = new ArrayList<>();

    @GetMapping("planeedid")
    public List<String> saaPlaneet() {
        return planeedid;
    }

    @PostMapping("planeedid/{planeet}")
    public List<String> lisaPlaneet(@PathVariable String planeet) {
        planeedid.add(planeet);
        return planeedid;
    }

    @DeleteMapping("planeedid/{index}")
    public List<String> kustutaPlaneet(@PathVariable int index) {
        planeedid.remove(index);
        return planeedid;
    }

    @GetMapping("planeedid/loendur")
    public int loePlaneedid() {
        return planeedid.size();
    }

    /*@GetMapping("planeedid/summa")
    public int summa() {
        int sum = 0;
        for (int number : planeedid) {
            sum += number;
        }
        return sum;
    }

    @GetMapping("planeedid/keskmine")
    public double keskmine() {
        if (planeedid.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for(int number : planeedid) {
            sum += number;
        }
        return (double) sum / planeedid.size();
    }*/

}
