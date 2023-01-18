package no.ntnu.library;

public class Author {
    
    private int id;
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(int id, String firstName, String lastName, int birthYear){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthYear(birthYear);
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
