package ee.tlu.kodutoo.controller;

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

    @GetMapping("saa-koik")
    public List<Root> getRoot() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.osrsbox.com/osrsbox-db/monsters-complete.json";
        ResponseEntity<Root[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Root[].class);

        return List.of(response.getBody());
    }

}
