package com.xiaokong.mongodbdemo.dao;/**
 * Created by xuebi on 2019/12/19.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.Field;

/**
 * @ClassName MongoDbDao
 * @Description TODO
 * @Author kongdeqi
 * @Date 2019/12/19 16:40
 * @Version 1.0
 */
public abstract class MongoDbDao<T> {

    protected Logger logger = LoggerFactory.getLogger(MongoDbDao.class);

    /**
     * 反射获取类型
     * @return
     */
    protected abstract Class<T> getEntityClass();

    @Value("${spring.data.mongodb.collectionName}")
    private String collectionName;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存单个对象
     * @param t
     */
    public void save(T t){
        logger.info("-------------->MongoDB save start");
        this.mongoTemplate.save(t,collectionName);
    }

    /**
     * 根据id查询对象
     * @param id
     * @return
     */
    public T queryById(Integer id){
        logger.info("-------------->MongoDB queryById start");
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoTemplate.findOne(query,this.getEntityClass(),collectionName);
    }


    public Query getQueryByObject(Object object){
        Query query = new Query();
        Criteria criteria = new Criteria();
        Field[] fields = object.getClass().getDeclaredFields();
        for(int i = 0;i < fields.length;i++){

        }
        return null;
    }

}
