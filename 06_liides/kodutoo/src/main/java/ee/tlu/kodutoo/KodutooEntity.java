package ee.tlu.kodutoo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "numbrid")
@Entity
@NoArgsConstructor
public class KodutooEntity {
    @Id
    String nimetus;
    int number;
    boolean paaris;
}
