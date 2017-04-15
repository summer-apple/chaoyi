package com.drartisan.dao;

import com.drartisan.entity.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.lang.Object;


/**
 * Created by summer on 16-8-24.
 */
public interface IBaseDAO<T,ID extends Serializable> {


    //************************ 查询 *************************//

    // select one
    T getOneById(ID id);
    T getOneByKey(String key,Object value);


    // select count
    Integer getCountByKey(String key,Object value);
    Integer getCountByKeys(Map<String,Object> kvs);


    // select list
    Page<T> getAllByKey(String key,Object value,String sortKey,String sortType);
    Page<T> getALLByKeys(Map<String,Object> kvs,String sortKey,String sortType);
    Page<T> getPageByKey(String key,String value,int offset,int count,String sortKey,String sortType);
    Page<T> getPageByKeys(Map<String,Object> kvs,int offset,int count,String sortKey,String sortType);


    //************************ 保存 更新 *************************//


    //save or update
    Integer save(T t);

    Integer saveOrUpdate(T t);

    Integer update(T t);
    Integer updateKey(ID id,String key,Object value);
    Integer updateKeys(ID id,Map<String,Object> kvs);


    //************************ 删除 *************************//


    Integer delete(T t);
    Integer deleteById(ID id);
    Integer deleteByKey(ID id,String key,Object value);
    Integer deleteByKeys(ID id,Map<String,Object> kvs);



    //************************ SQL 直接操作 *************************//
    void executeSQL(String sql);
    T fetchOne(String sql);
    List<T> fetchMany(String sql);


}
