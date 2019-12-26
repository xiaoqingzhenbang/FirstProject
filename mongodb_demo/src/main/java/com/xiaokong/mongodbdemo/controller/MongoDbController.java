package com.xiaokong.mongodbdemo.controller;/**
 * Created by xuebi on 2019/11/28.
 */

import com.xiaokong.mongodbdemo.entity.Book;
import com.xiaokong.mongodbdemo.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MongoDbController
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/28 15:40
 * @Version 1.0
 */

@RestController
@RequestMapping(method = RequestMethod.POST)
public class MongoDbController {
    @Autowired
    private MongoDbService mongoDbService;

    @RequestMapping("/mongo/save")
    public String saveObj() {return mongoDbService.saveObj();}

    @RequestMapping("/mongo/findAll")
    public List<Book> findAll() {return mongoDbService.findAll();}

    @RequestMapping("/mongo/findOne")
    public Book findOne(@RequestParam String id) {return mongoDbService.getBookById(id);}

    @RequestMapping("/mongo/findOneByName")
    public Book findOneByName(@RequestParam String name) {return mongoDbService.getBookByName(name);}

    @RequestMapping("/mongo/update")
    public String update(@RequestBody Book book) {return mongoDbService.updateBook(book);}

    @RequestMapping("/mongo/delOne")
    public String delOne(@RequestBody Book book) {return mongoDbService.deleteBook(book);}

    @RequestMapping("/mongo/delById")
    public String delById(@RequestParam String id) {return mongoDbService.deleteBookById(id);}

}
