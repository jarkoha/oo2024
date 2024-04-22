package ee.tlu.kodutoo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "planeedid")
@Entity
@NoArgsConstructor
public class KodutooEntity {
    @Id
    String nimetus;
    int labimoot;
    int kaugus;
}
