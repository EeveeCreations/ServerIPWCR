package nl.ipwcr.server.repositorys;

import nl.ipwcr.server.models.WebUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends CrudRepository<WebUser, Long> {
    WebUser findByName(String name);
}
