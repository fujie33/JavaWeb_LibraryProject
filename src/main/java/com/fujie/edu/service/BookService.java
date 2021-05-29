package com.fujie.edu.service;

import com.fujie.edu.dao.BookDao;
import com.fujie.edu.javabean.Book;
import com.fujie.edu.javabean.BorrowBook;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();

    public List<Book> searchAllBooks(String username, int pageNum,
                                     int pageSize) {

        List<Book> books = bookDao.selectAll(pageNum, pageSize);
        for (Book book : books) {
            book.setStore(isStore(username, book.getId()));
        }
        return books;
    }

    public int countNum() {
        return bookDao.count();
    }

    public boolean isStore(String username, String bookId) {
        return bookDao.selectStore(username, bookId);
    }

    public String storeBook(String username, String bookId) {
        int result = bookDao.insertStoreBook(username, bookId);
        if (result > 0) {
            return "借阅成功";
        } else {
            return "借阅失败";
        }
    }

    public ArrayList<BorrowBook> getBorrowBooks(String userid){
        final val borrowBooks = bookDao.getBorrowBooks(userid);
        return borrowBooks;
    }
}
