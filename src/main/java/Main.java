import Dao.Book;
import Dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BookDao bookDao = context.getBean("bookDaoImp", BookDao.class);

        // ---- insert book ----
        Book newBook = new Book(4, "Tree", 259);
        bookDao.insert(newBook);

        // ---- select book ----
        Book spring = bookDao.getOne(2);
        System.out.println("---getOne: " + spring);

        List<Book> bookList = bookDao.getAll();
        for (Book book : bookList) {
            System.out.println(book);
        }

        // ---- update book ----
        newBook.setPrice(200);
        bookDao.update(4, newBook);

        spring = bookDao.getOne(1);
        System.out.println("---getOne: " + spring);

       // ---- delete book ----
        bookDao.delete(5);

        bookList = bookDao.getAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
