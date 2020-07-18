package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author j.h on 7/18/20
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
