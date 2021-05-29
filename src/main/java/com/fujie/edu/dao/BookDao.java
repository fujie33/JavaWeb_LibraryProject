package com.fujie.edu.dao;

import com.fujie.edu.db.JDBCUtil;
import com.fujie.edu.javabean.Book;
import com.fujie.edu.javabean.BorrowBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> selectAll(int pageNum, int pageSize) {
        String sql = "select books.*, book_sort.name as sort " +
                "from books, book_sort where " +
                "books.sort_id=book_sort.id limit ?,?";

        List<Book> books = new ArrayList<>();
        try (ResultSet rs =
                     JDBCUtil.getInstance().executeQueryRS(sql,
                             new Object[]{(pageNum - 1) * pageSize,
                                     pageSize})) {

            while (rs.next()) {
                Book book = new Book(rs.getInt("id") + "",
                        rs.getString(
                                "name"),
                        rs.getString("author"),
                        rs.getString("sort"),
                        rs.getString("description"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public int count() {
        String sql = "select count(*) as countNum from books";
        try (ResultSet rs =
                     JDBCUtil.getInstance().executeQueryRS(sql,
                             new Object[]{})) {

            while (rs.next()) {
                int count = rs.getInt("countNum");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean selectStore(String username, String bookId) {
        String sql1 = "select EXISTS( SELECT 1 from borrow_books " +
                "where book_id=? and card_id=?) as store";
        try (ResultSet rs =
                     JDBCUtil.getInstance().executeQueryRS(sql1,
                             new Object[]{
                                     bookId, username
                             });) {

            while (rs.next()) {
                return rs.getBoolean("store");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int insertStoreBook(String username, String bookId) {
        String sql = "insert into borrow_books(book_id, card_id, " +
                "borrow_date) values(?,?,?)";
        int result = JDBCUtil.getInstance().executeUpdate(sql,
                new Object[]{
                        bookId, username,
                        new Date(System.currentTimeMillis())
                });
        return result;
    }
    public ArrayList<Book> get_HistoryListInfo2(int status){
        ArrayList<Book> tag_Array = new ArrayList<Book>();
        Connection conn = JDBCUtil.getInstance().getConnection();
//        String sql = "select * from history where status='"+status+"'";
        String sql = "";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                Book tag = new Book();
                tag.setId(rs.getString("id"));
                tag.setName(rs.getString("name"));
                tag.setAuthor(rs.getString("author"));
                tag.setSort(rs.getString("sort"));
                tag.setDescription(rs.getString("description"));
                tag.setStore(rs.getBoolean("store"));
                tag_Array.add(tag);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
//            DBUtil.CloseDB(rs, stm, conn);
        }
        return tag_Array;
    }
    public ArrayList<BorrowBook> getBorrowBooks(String userid){
        ArrayList<BorrowBook> borrowBookList = new ArrayList<>();
        Connection conn = JDBCUtil.getInstance().getConnection();
        String sql = "select borrow_books.id as id,books.id as bookId,books.name as name,books.author as author,books.sort_id as sort,books.description as description from books inner join borrow_books on books.id = borrow_books.book_id where borrow_books.card_id=1";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                BorrowBook tag = new BorrowBook();
                tag.setId(rs.getString("id"));
                tag.setBookId(rs.getString("bookId"));
                tag.setName(rs.getString("name"));
                tag.setAuthor(rs.getString("author"));
                tag.setSort(rs.getString("sort"));
                tag.setDescription(rs.getString("description"));
                borrowBookList.add(tag);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
//            DBUtil.CloseDB(rs, stm, conn);
        }
        return borrowBookList;
    }
}
