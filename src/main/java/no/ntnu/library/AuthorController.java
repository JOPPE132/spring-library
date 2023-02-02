package no.ntnu.library;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.swing.text.html.parser.Entity;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * REST API Controller for all endpoints related to book.
 */
@RestController
public class AuthorController {

    private List<Author> authors;

    public AuthorController() {
        initializeData();
    }

    private void initializeData() {
        authors = new ArrayList<>();
        authors.add(new Author(1, "Stephen", "King", 1947));
        authors.add(new Author(2, "Charles", "Dickens", 1812));
        authors.add(new Author(3, "George", "Orwell", 1903));
    }

    @Operation(summary = "Get all books", description = "Get all books inside collection")
    @GetMapping("/authors")
    public ResponseEntity<Object> getAuthors() {
        ResponseEntity response;

        if (this.authors.isEmpty()) {
            response = new ResponseEntity<>("Collection contains no elements", HttpStatus.BAD_REQUEST);
        } else {
            response = new ResponseEntity<>(authors, HttpStatus.ACCEPTED);
        }
        return response;
    }

    @Operation(summary = "Add author", description = "Adds a author to the author collection")
    @PostMapping("/authors")
    public ResponseEntity<Object> addAuthorMap(@RequestBody Author author) throws Exception { 
        ResponseEntity response;

        if (author != null) {
            response = new ResponseEntity<>(author, HttpStatus.CREATED);
            this.authors.add(author);
        } else {
            response = new ResponseEntity<>(author, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Operation(summary = "Delete author", description = "Deletes a author from the collection")
    @DeleteMapping("/authors/{lastName}")
    public ResponseEntity<Object> deleteAuthorMap(@PathVariable String lastName) {
        ResponseEntity response;

        Author author = deleteAuthorByLastName(lastName);

        if (author != null) {
            response = new ResponseEntity<>("Successfull deletion of: " + author.getFirstName() + " " + author.getLastName(), HttpStatus.OK);
            authors.remove(author);
        } else {
            response = new ResponseEntity<>("Author not found.", HttpStatus.NOT_FOUND);
        }

        return response;
    }

    /**
     * Delete author by name.
     * @param name of author
     * @return the author for deletion
     */
    public Author deleteAuthorByLastName(String name) {
        Author author = null;

        Iterator<Author> it = authors.iterator();

        while (it.hasNext()) {
            Author a = it.next();

            if (a.getLastName().equals(name)) {
                author = a;
            }
        }
        return author;
    }

    /**
     * Returns collection of authors.
     */
    public List<Author> getList() {
        return this.authors;
    }
}
