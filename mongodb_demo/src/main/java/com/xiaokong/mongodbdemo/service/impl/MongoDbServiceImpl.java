package com.xiaokong.mongodbdemo.service.impl;/**
 * Created by xuebi on 2019/11/28.
 */

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.xiaokong.mongodbdemo.entity.Book;
import com.xiaokong.mongodbdemo.service.MongoDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName MongoDbServiceImpl
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/28 15:40
 * @Version 1.0
 */
@Service
public class MongoDbServiceImpl implements MongoDbService{

    private static final Logger logger = LoggerFactory.getLogger(MongoDbService.class);

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 保存对象
     * @return
     */
    public String saveObj(){
        Book book = new Book();
        logger.info("--------------------->[MongoDB save start]");
//        book.setId("123456");
        book.setName("姚明");
        book.setInfo("详细信息");
        book.setPrice(666);
        book.setPublish("发布");
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        Book demo = mongoTemplate.save(book, "demo");
        logger.info("--------------------->[MongoDB save end]"+demo);
        return "保存成功!";
    }


    /**
     *查询所有
     * @return
     */
    public List<Book> findAll(){
        logger.info("--------------------->[MongoDB findAll start]");
        List<Book> demo = mongoTemplate.findAll(Book.class, "demo");
        logger.info("--------------------->[MongoDB findAll end]"+demo);
        return demo;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Book getBookById(String id){
        logger.info("--------------------->[MongoDB queryBookById start]");
        Query query = new Query(Criteria.where("_id").is(id));
        Book demo = mongoTemplate.findOne(query, Book.class,"demo");
        logger.info("--------------------->[MongoDB queryBookById end]"+demo);
        return demo;
    }

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    public Book getBookByName(String name) {
        logger.info("--------------------->[MongoDB getBookByName start]");
        Query query = new Query(Criteria.where("name").is(name));
        Book demo = mongoTemplate.findOne(query, Book.class,"demo");
        logger.info("--------------------->[MongoDB getBookByName end]"+demo);
        return demo;
    }

    /**
     * 更新对象
     *
     * @param book
     * @return
     */
    public String updateBook(Book book) {
        logger.info("--------------------->[MongoDB update start]");
        Query query = new Query(Criteria.where("_id").is(book.getId()));
        Update update = new Update().set("publish", book.getPublish())
                .set("info", book.getInfo())
                .set("updateTime", new Date());
        //updateFirst 更新查询返回结果集的第一条
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Book.class,"demo");
        //updateMulti 更新查询返回结果集的全部
//        mongoTemplate.updateMulti(query,update,Book.class);
        //upsert 更新对象不存在则去添加
//        mongoTemplate.upsert(query,update,Book.class);
        logger.info("--------------------->[MongoDB update end]"+updateResult);
        return updateResult.toString();
    }

    /***
     * 删除对象
     * @param book
     * @return
     */
    public String deleteBook(Book book) {
        logger.info("--------------------->[MongoDB delete start]");
        DeleteResult remove = mongoTemplate.remove(book,"demo");
        logger.info("--------------------->[MongoDB delete end]"+remove);
        return remove.toString();
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public String deleteBookById(String id) {
        logger.info("--------------------->[MongoDB delete start]");
        //findOne
        Book book = getBookById(id);
        //delete
        deleteBook(book);
        return "success";
    }

}
