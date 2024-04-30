package ee.tlu.proovikontrolltoo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Tellimus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tellija;

    @ManyToMany
    private List<Toode> tooted;
}
