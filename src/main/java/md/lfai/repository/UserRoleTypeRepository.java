package md.lfai.repository;

import md.lfai.entity.CatalogEntity;
import md.lfai.entity.UserRoleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleTypeRepository extends JpaRepository<UserRoleTypeEntity,Long> {
}
