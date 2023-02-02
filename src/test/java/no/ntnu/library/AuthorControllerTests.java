package no.ntnu.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.AuthorizeCallback;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AutoProxyRegistrar;

public class AuthorControllerTests {

    private AuthorController authorController = new AuthorController();

    /**
     * Test deletion of Author from collection.
     */
    @Test
    void testDeleteAuthor_positive() {
        String str = authorController.getList().get(0).getLastName();
        authorController.deleteAuthor(authorController.findAuthorByLastName(str));
        assertEquals(2, authorController.getList().size());
    }

    @Test
    void testFindAuthorByLastName_positive() {
        assertEquals("King", authorController.getList().get(0).getLastName());
    }

}
