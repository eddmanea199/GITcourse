package com.sda.jr2.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reviewId")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="bookId")
    private Book book;
    @Column(name = "score")
    private Double score;
    @Column(name = "comment")
    private String comment;


    public Reviews(Book book, Double score, String comment) {
        this.book = book;
        this.score = score;
        this.comment = comment;
    }
    public Reviews(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return id+" | "+book + " | " + score + " | " + comment + " | ";
    }
}
