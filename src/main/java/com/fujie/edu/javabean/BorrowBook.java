package com.fujie.edu.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName BorrowBook
 * @Description TODO
 * @Author 付洁
 * @Date 2021/5/25
 **/
@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
public class BorrowBook {
    private String id;
    private String bookId;
    private String name;
    private String author;
    private String sort;
    private String description;
}
