package no.ntnu.library;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * REST API Controller for all endpoints related to book.
 */
@RestController
public class AuthorController {

    private List<Author> authors = new ArrayList<>();

    public AuthorController() {
        initializeData();
    }

    private void initializeData() {
        authors.add(new Author(1, "Stephen", "King", 1947));
        authors.add(new Author(2, "Charles", "Dickens", 1812));
        authors.add(new Author(3, "George", "Orwell", 1903));
    }

    @Operation(summary = "Get all books", description = "Get all books inside collection")
    @GetMapping("/authors")
    public ResponseEntity<Object> getAuthors() {
        ResponseEntity response;

        if (this.authors.size() == 0) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            response = new ResponseEntity<>(authors, HttpStatus.ACCEPTED);
        }
        return response;
    }

    @Operation(summary = "Add author", description = "Adds a author to the author collection")
    @PostMapping("/authors")
    public ResponseEntity<Object> addAuthor(@RequestBody Author author) {
        ResponseEntity response;

        if (author != null) {
            response = new ResponseEntity<>(author, HttpStatus.CREATED);
            this.authors.add(author);
        } else {
            response = new ResponseEntity<>(author, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
