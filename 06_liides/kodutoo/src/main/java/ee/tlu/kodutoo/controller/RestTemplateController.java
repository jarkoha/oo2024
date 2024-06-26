package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.model.Autod;
import ee.tlu.kodutoo.model.Root;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class RestTemplateController {

    @GetMapping("saa-autod")
    public List<Autod> getAutod() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        return response.getBody().results;
    }

    @GetMapping("saa-autod/{make}")
    public List<Autod> getAutodByMake(@PathVariable String make) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response = restTemplate.exchange("https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100", HttpMethod.GET, null, Root.class);

        List<Autod> sobilikudAutod = new ArrayList<>();
        for (Autod a : response.getBody().results) {
            if(a.getMake() != null && a.getMake().equalsIgnoreCase(make)) {
                sobilikudAutod.add(a);
            }
        }
        return sobilikudAutod;
    }

}
