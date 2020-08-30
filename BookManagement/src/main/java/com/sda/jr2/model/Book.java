package com.sda.jr2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Integer id;
    @Column(name="title")
    private String title;
    @ManyToOne
    @JoinColumn(name="authorId")
    private Author author;
    @Column(name="description")
    private String description;
    @Column(name="isbn")
    private String isbn;
    @OneToMany(mappedBy = "book")
    Set<Reviews> reviews=new HashSet<>();

    public Book(String title, Author author, String description, String isbn) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
    }
    public Book(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return id+" | "+title + " | "+author + " | " + description + " | " + isbn;
    }

    public String toCSV() {
        return title + ","+author + "," + description + "," + isbn+"\n";
    }
}
