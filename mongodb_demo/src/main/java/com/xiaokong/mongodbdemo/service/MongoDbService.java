package com.xiaokong.mongodbdemo.service;

import com.xiaokong.mongodbdemo.entity.Book;

import java.util.List;

/**
 * Created by xuebi on 2019/11/28.
 */
public interface MongoDbService {
    String saveObj();

    List<Book> findAll();

    Book getBookById(String id);

    Book getBookByName(String name);

    String updateBook(Book book);

    String deleteBook(Book book);

    String deleteBookById(String id);
}
