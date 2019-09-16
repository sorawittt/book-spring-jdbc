package Dao;

import java.util.List;

public interface BookDao {
    void insert(Book book);
    void update(int id, Book book);
    void delete(int id);
    Book getOne(int id);
    List<Book> getAll();

}

