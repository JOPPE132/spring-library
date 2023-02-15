package no.ntnu.library;

import org.springframework.data.repository.CrudRepository;

/*
 * Handle SQL for books. CRUD Operations.
 */
public interface BookRepository extends CrudRepository<Book, Integer> { // Integer is datatype of primary key

}
