package com.sda.jr2.ui;

import com.sda.jr2.model.Author;
import com.sda.jr2.model.Book;
import com.sda.jr2.model.Reviews;
import com.sda.jr2.repository.AuthorRepository;
import com.sda.jr2.repository.BookRepository;
import com.sda.jr2.repository.ReviewsRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Application {

    private AuthorRepository authorRepository = new AuthorRepository();

    private BookRepository bookRepository=new BookRepository();

    private ReviewsRepository reviewsRepository=new ReviewsRepository();

    public void showCLI() {
        while (true) {
            System.out.println("1 Insert new author");
            System.out.println("2 Update author");
            System.out.println("3 Delete author");
            System.out.println("4 Display all authors");
            System.out.println("5 Exit application");
            System.out.println("6 Export Authors");
            System.out.println("7 Import Authors");
            System.out.println("8 Insert new book");
            System.out.println("9 Update book");
            System.out.println("10 Delete book");
            System.out.println("11 Display books");
            System.out.println("12 Insert new review");
            System.out.println("13 Update review");
            System.out.println("14 Delete review");
            System.out.println("15 Display all reviews");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    insertNewAuthor();
                    break;
                case 2:
                    updateAuthor();
                    break;
                case 3:
                    deleteAuthor();
                    break;
                case 4:
                    displayAuthors();
                    break;
                case 5:
                    return;
                case 6:
                    exportToCSV();
                    break;
                case 7:
                    importAuthors();
                    break;
                case 8:
                    insertNewBook();
                    break;
                case 9:
                    updateBook();
                    break;
                case 10:
                    deleteBook();
                    break;
                case 11:
                    displayBooks();
                    break;
                case 12:
                    insertNewReview();
                    break;
                case 13:
                    updateReview();
                    break;
                case 14:
                    deleteReview();
                    break;
                case 15:
                    displayReviews();
                default:
                    System.out.println("Invalid option");

            }
        }
    }

    private void exportToCSV() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert path");
        String path = scanner.next();
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            authorRepository.findAll().stream().map(Author::toCSV).forEach(csv -> {
                try {
                    bufferedWriter.write(csv);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importAuthors() {
        System.out.println("Insert path");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                Author author=new Author();
                author.setFirstName(tokens[0]);
                author.setLastName(tokens[1]);
                author.setCountry(tokens[2]);
                author.setDateOfBirth(LocalDate.parse(tokens[3]));
                if(authorRepository.findByAuthor(author).isPresent())
                {authorRepository.save(author);}
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateAuthor() {
        System.out.println("Updating author");
        System.out.println("Insert Author ID");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        Author author = new Author();
        System.out.println("Insert firstName");
        String firstName = scanner.next();
        author.setFirstName(firstName);
        System.out.println("Insert lastName");
        String lastName = scanner.next();
        author.setLastName(lastName);
        System.out.println("Insert Country");
        String country = scanner.next();
        author.setCountry(country);
        System.out.println("Insert dateOfBirth");
        LocalDate dateOfBirth = LocalDate.parse(scanner.next());
        author.setDateOfBirth(dateOfBirth);
        authorRepository.update(author);

    }

    private void insertNewAuthor() {
        System.out.println("Inserting new author");
        Author author = new Author();
        System.out.println("Insert firstName");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        author.setFirstName(firstName);
        System.out.println("Insert lastName");
        String lastName = scanner.next();
        author.setLastName(lastName);
        System.out.println("Insert Country");
        String country = scanner.next();
        author.setCountry(country);
        System.out.println("Insert dateOfBirth");
        LocalDate dateOfBirth = LocalDate.parse(scanner.next());
        author.setDateOfBirth(dateOfBirth);
        authorRepository.save(author);
    }

    private void deleteAuthor() {
        System.out.println("Deleting author");
        System.out.println("Insert ID");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        authorRepository.delete(authorRepository.findById(id));

    }

    private void insertNewBook(){
        System.out.println("Insert new book");
        Book book=new Book();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Insert title");
        String title=scanner.nextLine();
        book.setTitle(title);
        System.out.println("Insert author");
        Author author= authorRepository.findById(6);
        book.setAuthor(author);
        System.out.println("Insert description");
        String description=scanner.nextLine();
        book.setDescription(description);
        System.out.println("Insert isbn");
        String isbn=scanner.next();
        book.setIsbn(isbn);
        bookRepository.save(book);
    }

    private void updateBook(){
        System.out.println("Update book");
        System.out.println("Insert Book ID");
        Book book=new Book();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Insert title");
        String title=scanner.nextLine();
        book.setTitle(title);
        System.out.println("Insert author");
        Author author= authorRepository.findById(6);
        book.setAuthor(author);
        System.out.println("Insert description");
        String description=scanner.nextLine();
        book.setDescription(description);
        String isbn=scanner.next();
        book.setIsbn(isbn);
        bookRepository.update(book);
    }

    private void deleteBook(){
        System.out.println("Delete book");
        System.out.println("Insert Book ID");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        bookRepository.delete(bookRepository.findById(id));
    }

    private void insertNewReview(){
        System.out.println("Insert new review");
        Reviews reviews=new Reviews();
        Scanner scanner=new Scanner(System.in);
        Book book= bookRepository.findById(6);
        reviews.setBook(book);
        System.out.println("Insert score");
        Double score=scanner.nextDouble();
        reviews.setScore(score);
        System.out.println("Insert comment");
        String comment=scanner.nextLine();
        reviews.setComment(comment);
        reviewsRepository.save(reviews);
    }

    private void updateReview(){
        System.out.println("Update review");
        Reviews reviews=new Reviews();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Insert new book");
        Book book= bookRepository.findById(6);
        reviews.setBook(book);
        System.out.println("Insert score");
        Double score=scanner.nextDouble();
        reviews.setScore(score);
        System.out.println("Insert comment");
        String comment=scanner.nextLine();
        reviews.setComment(comment);
        reviewsRepository.update(reviews);

    }

    private void deleteReview(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Delete book");
        System.out.println("Insert book ID");
        int Id=scanner.nextInt();
        reviewsRepository.delete(reviewsRepository.findById(Id));
    }

    private void displayAuthors() {
        System.out.println("Displaying all authors");
        authorRepository.findAll().stream().map(Author::toString).forEach(System.out::println);
    }

    private void displayBooks(){
        System.out.println("Displaying all books");
        bookRepository.findAll().stream().map(Book::toString).forEach(System.out::println);
    }

    private void displayReviews(){
        System.out.println("Displaying all reviews");
        reviewsRepository.findAll().stream().map(Reviews::toString).forEach(System.out::println);
    }

    
    public static void main(String[] args) {
        Application application = new Application();
        application.showCLI();

    }

}