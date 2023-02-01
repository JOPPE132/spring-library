package no.ntnu.library;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a book in our library", title = "Book")
public class Book {

    @Schema(description = "Title of the book")
    private String title;
    @Schema(description = "ID of the book")
    private int id;
    @Schema(description = "Production year of the book")
    private int year;
    @Schema(description = "Number of pages of the book")
    private int numberOfPages;
    
    public Book(String title, int id, int year, int numberOfPages){
        setTitle(title);
        setId(id);
        setYear(year);
        setNumberOfPages(numberOfPages);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    
}
