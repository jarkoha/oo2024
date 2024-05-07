package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ee.tlu.kontrolltoo2.Autod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class RestTemplateController {


    //https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100
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

    @GetMapping("saa-autod/make-model")
    public List<CarMakeModel> saaAutoMarkMudel() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        List<CarMakeModel> carMakeModels = new ArrayList<>();
        for (Autod autod : response.getBody().results) {
            carMakeModels.add(new CarMakeModel(autod.getMake(), autod.getModel()));
        }
        return carMakeModels;
    }

    @GetMapping("saa-autod/koige-norgem")
    public Autod2 saaKoigeNorgemAuto() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<Autod2[]> response = restTemplate.getForEntity(url, Autod2[].class);

        Autod2[] autodList = response.getBody();
        Autod2 koigeNorgemAuto = autodList[0];
        double lowestAvgHorsepower = koigeNorgemAuto.getAvg_horsepower();

        for (int i = 1; i < autodList.length; i++) {
            if (autodList[i].getAvg_horsepower() < lowestAvgHorsepower) {
                koigeNorgemAuto = autodList[i];
                lowestAvgHorsepower = koigeNorgemAuto.getAvg_horsepower();
            }
        }

        return koigeNorgemAuto;
    }

    @GetMapping("saa-autod/koige-kallim")
    public Autod2 saaKoigeKallimAuto() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<Autod2[]> response = restTemplate.getForEntity(url, Autod2[].class);

        Autod2[] autodList = response.getBody();
        Autod2 koigeKallimAuto = autodList[0];
        double highestAvgPrice = koigeKallimAuto.getAvg_price();

        for (int i = 1; i < autodList.length; i++) {
            if (autodList[i].getAvg_price() > highestAvgPrice) {
                koigeKallimAuto = autodList[i];
                highestAvgPrice = koigeKallimAuto.getAvg_price();
            }
        }

        return koigeKallimAuto;
    }

    @GetMapping("saa-autod/vaiksema-hinnaga/{hind}")
    public Autod2[] saaAutodWithSmallerPrice(@PathVariable double hind) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<Autod2[]> response = restTemplate.getForEntity(url, Autod2[].class);

        Autod2[] autodList = response.getBody();
        List<Autod2> autodsWithSmallerPrice = new ArrayList<>();

        for (Autod2 autod : autodList) {
            if (autod.getAvg_price() < hind) {
                autodsWithSmallerPrice.add(autod);
            }
        }

        return autodsWithSmallerPrice.toArray(new Autod2[0]);
    }

    @GetMapping("saa-autod/suurem-joud/{joud}")
    public Autod2[] saaAutodWithHigherHorsepower(@PathVariable double joud) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<Autod2[]> response = restTemplate.getForEntity(url, Autod2[].class);

        Autod2[] autodList = response.getBody();
        List<Autod2> autodsWithHigherHorsepower = new ArrayList<>();

        for (Autod2 autod : autodList) {
            if (autod.getAvg_horsepower() > joud) {
                autodsWithHigherHorsepower.add(autod);
            }
        }

        return autodsWithHigherHorsepower.toArray(new Autod2[0]);
    }

    @GetMapping("saa-autod/vahemik/{minPrice}/{maxPrice}")
    public Autod2[] saaAutodBetweenPrices(@PathVariable double minPrice, @PathVariable double maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<Autod2[]> response = restTemplate.getForEntity(url, Autod2[].class);

        Autod2[] autodList = response.getBody();
        List<Autod2> autodsWithinPriceRange = new ArrayList<>();

        for (Autod2 autod : autodList) {
            double avgPrice = autod.getAvg_price();
            if (avgPrice >= minPrice && avgPrice <= maxPrice) {
                autodsWithinPriceRange.add(autod);
            }
        }

        return autodsWithinPriceRange.toArray(new Autod2[0]);
    }

}

// Tee RestTemplate päring siia API otspunkti:
// https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100
// Tee 3 API otspunkti front-endile:
// 1) kas kõik autod Listina
// 2) võimalus sisestada bränd ning antakse kõik seda
// marki autod (sisestades “Honda”)
// 3) Listina võtmed “make” + “model” kokkuliidetuna
// (midagi muud ei ole – ei aastat, id-d jne),
// ainult Stringide List.

// Tee RestTemplate päring siia API otspunkti: https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers
// Näita eraldi API otspunktides kõige väiksema keskmise
// hobujõuga autot, kõige suurema keskmise hinnaga autot,
// kõik autod väiksema keskmise hinnaga kui sisestatud hind,
// kõik autod suurema keskmise hobujõuga kui sisestatud hobujõud
// ja kõik autod sisestatud hinnavahemikus (5 erinevat API otspunkti).