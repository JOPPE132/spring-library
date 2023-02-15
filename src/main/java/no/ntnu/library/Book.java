package no.ntnu.library;

import org.hibernate.annotations.CollectionId;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description = "Represents a book in our library", title = "Book")
@Entity
@Table(name = "books")
public class Book {

    @Schema(description = "Title of the book")
    @Column(name = "title")
    private String title;
    @Schema(description = "ID of the book")
    @Id
    @Column(name = "id")
    private int id;
    @Schema(description = "Production year of the book")
    @Column(name = "year")
    private int year;
    @Schema(description = "Number of pages of the book")
    @Column(name = "numberOfPages")
    private int numberOfPages;

    public Book(String title, int id, int year, int numberOfPages) {
        setTitle(title);
        setId(id);
        setYear(year);
        setNumberOfPages(numberOfPages);
    }

    public Book() {
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
