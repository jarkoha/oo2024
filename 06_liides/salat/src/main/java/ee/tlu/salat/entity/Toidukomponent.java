package ee.tlu.salat.entity;

//mis koosneb toiduainest ja temaga seotud kogusest toidu sees
//Klassikomplekt -> Kartul+omadused ja mitu grammi

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Toidukomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne //(cascade = CascadeType.ALL) // kui kustutatakse toiduained, siis kustuvad temaga ka seotud toiduained
    ToiduaineEntity toiduaine;

    @ManyToOne
    Toit toit;

    int kogus;

}
