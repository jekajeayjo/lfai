package md.lfai.repository;

import md.lfai.entity.CatalogEntity;
import md.lfai.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity,Long> {
}
