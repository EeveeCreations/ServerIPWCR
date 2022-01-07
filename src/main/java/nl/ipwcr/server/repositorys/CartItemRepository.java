package nl.ipwcr.server.repositorys;

import nl.ipwcr.server.models.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
