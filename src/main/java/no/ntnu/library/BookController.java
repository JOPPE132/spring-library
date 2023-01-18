package no.ntnu.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.RepaintManager;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API Controller for all endpoints related to book.
 */
@RestController
public class BookController {

    List<Book> books = new ArrayList<>();

    public BookController() {
        initializeDate(); // dummy books, not necessary.
    }

    private void initializeDate() {
        books.add(new Book("12 Rules for Life", 1, 2015, 251));
        books.add(new Book("Algorithms and Datastructures", 2, 2021, 441));
        books.add(new Book("Fullstack with Spring and React", 3, 2022, 681));
    }

    /*
     * HTTP END POINT for getting all the books. GET = Read
     */
    @GetMapping("/books")
    public List<Book> getBooks() {
        return books; // if books.size() = 0?? invalid? exception?
    }

    /**
     * HTTP END POINT for getting a book with a certain ID. GET = Read
     * @param id the given Id of the book
     * @return response code 200 or 404; OK or NOT_FOUND.
     */
    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id){
        ResponseEntity<Object> response;

        Book book = findBookById(id);
        if(book != null){
            response = new ResponseEntity<>(book, HttpStatus.OK); //HTTP Response 200.
        } else{
            response = new ResponseEntity<>("No books found with ID: " + id, HttpStatus.NOT_FOUND); //HTTP Reponse 404.
        }
        return response;
    }


    /**
     * HTTP END POINT for adding new books. POST = New
     */
    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        ResponseEntity response;

        if(book != null){
            response = new ResponseEntity<>(book, HttpStatus.OK); //HTTP Response 200.
            addBookToCollection(book);
        } else{
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST); //HTTP Response 400.
        }
        return response;
    }

    /**
     * HTTP END POINT for delete a existing book. DELETE = Delete
     */
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id){
        ResponseEntity response;

        Book book = deleteBookById(id);

        if(book != null){
            books.remove(book);
            response = new ResponseEntity<>(book, HttpStatus.OK);
        } else{
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * Check if book title is valid. Title cannot contain symbols or other
     * irregular characters.
     * @param title title of the book
     * @return true or false on whether the title is valid or not. valid if title does
     * not contain illegal symbols, otherwise invalid.
     */
    public boolean isTitleValid(String title) {
        Pattern pattern = Pattern.compile("[/~#@*+%{}<>\\[\\]|\"\\_^]"); // All invalid symbols
        Matcher matcher = pattern.matcher(title);

        boolean validString = matcher.find();
        boolean isValid = true;

        if (title.isBlank() || validString) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Check if Id of book is valid or not. Id is only valid if given id is 
     * above 0(exclusive).
     * @param id the given id of the book.
     * @return true or false on whether the book has a valid id or not.
     */
    public boolean isIdValid(int id){
        boolean isValid = true;

        if(id <= 0){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Check if the production year of the book is valid. Production year must be
     * above 1400's, because thats when books started to get printed!
     * @param year the given year of the book.
     * @return true or false on whether it has valid production year.
     */
    public boolean isYearValid(int year){
        boolean isValid = true;

        if(year < 1400){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Check if the number of pages on a book is valid or not. Number of pages cannot be 0 or less than 0.
     * @param numberOfPages the given number of amount of pages.
     * @return true or false on whether it has valid amounts or not.
     */
    public boolean isNumberOfPagesValid(int numberOfPages){
        boolean isValid = true;

        if(numberOfPages <= 0){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Search for book by book ID. Returns the book if the given ID matches a
     * book in the library.
     * 
     * @param id
     * @return
     */
    public Book findBookById(int id) {
        Book foundBook = null;
        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {
            Book b = it.next();

            if (b.getId() == id) {
                foundBook = b;
            }
        }
        return foundBook;
    }

    public Book deleteBookById(int id){
        Book foundBook = null;
        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {
            Book b = it.next();

            if (b.getId() == id) {
                foundBook = b;
            }
        }
        return foundBook;
    }


    /**
     * Adds a book to the library.
     * @param book the book to add to the library.
     */
    public void addBookToCollection(Book book){
        if(isTitleValid(book.getTitle()) 
            && isIdValid(book.getId())
            && isYearValid(book.getYear())
            && isNumberOfPagesValid(book.getNumberOfPages())){
                books.add(book);
        }
    }
}