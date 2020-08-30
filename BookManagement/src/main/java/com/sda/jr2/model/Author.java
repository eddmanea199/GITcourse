package com.sda.jr2.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId")
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "country")
    private String country;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "author")
    Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName, String country, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return id + " | " + firstName + " | " + lastName + " | " + country + " | " + dateOfBirth;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + country + "," + dateOfBirth+"\n";
    }
}
