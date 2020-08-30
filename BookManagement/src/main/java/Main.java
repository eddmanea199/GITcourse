import com.sda.jr2.model.Author;
import com.sda.jr2.model.Book;
import com.sda.jr2.model.Reviews;
import com.sda.jr2.repository.AuthorRepository;
import com.sda.jr2.repository.BookRepository;
import com.sda.jr2.repository.ReviewsRepository;
import javafx.scene.control.Labeled;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[]args) throws ParseException {
        AuthorRepository ar=new AuthorRepository();
        LocalDate localDate=LocalDate.parse("1885-09-27");
        Author author=new Author("Liviu","Rebreanu","ROMANIA",localDate);
        //ar.save(author);
        //Author author=ar.findById(5);
        //ar.update(author);
        //ar.delete(ar.findById(5));
        //ar.findAll().forEach(System.out::println);
        BookRepository br=new BookRepository();
        author=ar.findById(5);
        Book book=new Book("Ion",author,"Ion este un roman social, obiectiv, realist și modern","9789731180717");
        //br.save(book);
        //br.delete(br.findById(5));
        //br.findAll().forEach(System.out::println);
        ReviewsRepository rp=new ReviewsRepository();
        //Book book=br.findById(4);
        //book.setTitle("Tender is the Night");
        //br.update(book);
        //br.delete(br.findById(5));
        book=br.findById(5);
        Reviews reviews=new Reviews(book,50.50,"It was very interesting");
        reviews=rp.findById(5);
        //rp.save(reviews);
        //reviews.setScore(80.99);
        //rp.update(reviews);
        //rp.delete(rp.findById(5));
        //rp.findAll().forEach(System.out::println);
    }
}
