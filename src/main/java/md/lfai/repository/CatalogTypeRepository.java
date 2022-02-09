package md.lfai.repository;

import md.lfai.entity.CatalogEntity;
import md.lfai.entity.CatalogTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogTypeRepository extends JpaRepository<CatalogTypeEntity,Long> {
}
