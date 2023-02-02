package no.ntnu.library;

import io.swagger.v3.oas.annotations.media.Schema;

//@Schema(description = "Represents an Author in our library", title = "Author")
public class Author {

    // @Schema(description = "ID of the author")
    private int id;
    // @Schema(description = "First name of the author")
    private String firstName;
    // @Schema(description = "Last name of the author")
    private String lastName;
    // @Schema(description = "Birth year of the author")
    private int birthYear;

    public Author(int id, String firstName, String lastName, int birthYear) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthYear(birthYear);

    }

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

}