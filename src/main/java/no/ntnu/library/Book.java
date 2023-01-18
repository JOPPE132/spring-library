package no.ntnu.library;

public class Book {

    private String title;
    private int id;
    private int year;
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
