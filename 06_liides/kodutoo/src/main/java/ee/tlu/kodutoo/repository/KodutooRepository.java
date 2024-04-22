package ee.tlu.kodutoo.repository;

import ee.tlu.kodutoo.entity.KodutooEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KodutooRepository extends JpaRepository<KodutooEntity, String> {


}
