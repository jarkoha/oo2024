package ee.tlu.salat.entity;

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
    private String nimetus; //nimetus on primaarvõti
    private int valk;
    private int rasv;
    private int sysivesik;


}
