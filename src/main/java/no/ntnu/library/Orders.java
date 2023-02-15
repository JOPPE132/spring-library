package no.ntnu.library;

import java.util.HashMap;

public class Orders {

    private HashMap<Author, Book> order;
    private AuthorController authorController;
    private BookController bookController;

    public Orders() {
        this.order = new HashMap<>();
        this.authorController = new AuthorController();
        this.bookController = new BookController();

    }
}
