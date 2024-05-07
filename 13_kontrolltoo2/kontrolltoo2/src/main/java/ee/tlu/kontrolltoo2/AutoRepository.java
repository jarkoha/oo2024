package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<AutoEntity, String> {

    List<AutoEntity> findByAasta(int aasta);

    List<AutoEntity> findByPikkusBetween(float pikkusStart, float pikkusEnd);

    AutoEntity findFirstByMassNotNullOrderByMassDesc();
}
