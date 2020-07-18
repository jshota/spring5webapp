package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.models.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author j.h on 7/18/20
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
