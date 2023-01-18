package no.ntnu.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookControllerTests {

    /*
     * Test objects
     */
    private Book book = new Book("Mikkel", 12, 12, 12);
    private BookController bookController = new BookController();

    @Test
    void testIsValidMethod_Positive(){
        assertEquals(true, bookController.isTitleValid("12 rules of life"));
    }
    
}
