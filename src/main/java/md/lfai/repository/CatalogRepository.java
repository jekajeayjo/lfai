package md.lfai.repository;

import md.lfai.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository  extends JpaRepository<CatalogEntity,Long> {
}
