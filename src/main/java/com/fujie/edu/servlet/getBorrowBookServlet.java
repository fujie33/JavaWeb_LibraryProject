package com.fujie.edu.servlet;

import com.fujie.edu.service.BookService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName getBorrowBookServlet
 * @Description TODO
 * @Author 付洁
 * @Date 2021/5/25
 **/
@WebServlet(name="getBorrowBookServlet",urlPatterns = "/getborrowbooks")
public class getBorrowBookServlet extends HttpServlet {
    private BookService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final val userId =(int) req.getSession().getAttribute("userId");
        service =new BookService();
        final val borrowBooks = service.getBorrowBooks(String.valueOf(userId));
        if (borrowBooks.size()>0){
            req.getSession().setAttribute("BORROW_BOOKS",borrowBooks);
        }
    }
}
