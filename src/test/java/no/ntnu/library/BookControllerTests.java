package no.ntnu.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookControllerTests {

    /*
     * Test objects
     */
    private Book book = new Book("Mikkel", 12, 1500, 12);
    private Book book2 = new Book("###@*+", -2, 1200, -200); //FAULTY BOOK
    private BookController bookController = new BookController();

    /**
     * Test title
     */
    @Test
    void testIsTitleValid_positive(){
        assertEquals(true, bookController.isTitleValid(book.getTitle()));
    }
    @Test
    void testIsTitleValid_negative(){
        assertEquals(false, bookController.isTitleValid(book2.getTitle()));
    }

    /**
     * Test id
     */
    @Test
    void testIsIdValid_positive(){
        assertEquals(true, bookController.isIdValid(book.getId()));
    }
    @Test
    void isTestIdValid_negative(){
        assertEquals(false, bookController.isIdValid(book2.getId()));
    }

    /**
     * Test year
     */
    @Test
    void testIsYearValid_positive(){
        assertEquals(true, bookController.isYearValid(book.getYear()));
    }
    void testIsYearvalid_negative(){
        assertEquals(false, bookController.isYearValid(book2.getYear()));
    }

    /**
     * Test number of pages
     */
    @Test
    void testIsNumberOfPagesValid_positive(){
        assertEquals(true, bookController.isNumberOfPagesValid(book.getNumberOfPages()));
    }
    @Test
    void testIsNumberOfPagesValid_negative(){
        assertEquals(false, bookController.isNumberOfPagesValid(book2.getNumberOfPages()));
    }

    @Test
    void testIsVerified_positive(){
        assertEquals(true, bookController.isVerified(book));
    }
    @Test
    void testIsVerified_negative(){
        assertEquals(false, bookController.isVerified(book2));
    }
}