package ee.tlu.salat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "toiduaine") //vabatahtlik, vahetab tabeli nime
@Entity //andmebaasi panekuks
@NoArgsConstructor //andmebaasi panekuks
public class ToiduaineEntity {
    @Id //alati unikaalne-kustutamiseks, võtmiseks, muutmiseks
    String nimetus; //nimetus on primaarvõti
    int valk;
    int rasv;
    int sysivesik;


}
