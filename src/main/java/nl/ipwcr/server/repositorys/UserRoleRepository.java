package nl.ipwcr.server.repositorys;

import nl.ipwcr.server.models.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long> {
   UserRole findByRole(String name);
}
