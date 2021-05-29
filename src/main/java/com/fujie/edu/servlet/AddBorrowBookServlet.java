package com.fujie.edu.servlet;

import com.alibaba.fastjson.JSON;
import com.fujie.edu.service.BookService;
import lombok.val;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName AddBorrowBookServlet
 * @Description TODO
 * @Author 付洁
 * @Date 2021/5/25 "/add-borrow-book"
 **/
@WebServlet(name = "AddBorrowBookServlet",urlPatterns="/add-borrow-book")
public class AddBorrowBookServlet extends HttpServlet {
    private BookService service;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String bookId = (String) parseObject.get("bookId");
        String userId = (String) parseObject.get("userId");
        service = new BookService();
        final val s = service.storeBook(userId, bookId);
        if ("借阅成功".equals(s)) {
            resp.sendRedirect("/searchBooks.jsp");
        }
    }
}
