package ee.tlu.salat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Toit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //alustab ühest ja 1,2,3,4,5...
    private Long Id;

    private String nimetus;

    @ManyToMany
    List<Toidukomponent> toidukomponendid;
}
