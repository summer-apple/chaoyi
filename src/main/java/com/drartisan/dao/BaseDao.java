package com.drartisan.dao;

import com.drartisan.entity.Page;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by summer on 16-8-24.
 */
public class BaseDao<T,ID extends Serializable> extends SqlSessionDaoSupport implements IBaseDAO<T,ID> {

    @Override
    public T getOneById(Serializable serializable) {
        return null;
    }

    @Override
    public T getOneByKey(String key, Object value) {
        return null;
    }

    @Override
    public Integer getCountByKey(String key, Object value) {
        return null;
    }

    @Override
    public Integer getCountByKeys(Map kvs) {
        return null;
    }

    @Override
    public Page<T> getAllByKey(String key, Object value, String sortKey, String sortType) {
        return null;
    }

    @Override
    public Page<T> getALLByKeys(Map kvs, String sortKey, String sortType) {
        return null;
    }

    @Override
    public Page<T> getPageByKey(String key, String value, int offset, int count, String sortKey, String sortType) {
        return null;
    }

    @Override
    public Page<T> getPageByKeys(Map kvs, int offset, int count, String sortKey, String sortType) {
        return null;
    }

    @Override
    public Integer save(Object o) {
        return null;
    }

    @Override
    public Integer saveOrUpdate(Object o) {
        return null;
    }

    @Override
    public Integer update(Object o) {
        return null;
    }

    @Override
    public Integer updateKey(Serializable serializable, String key, Object value) {
        return null;
    }

    @Override
    public Integer updateKeys(Serializable serializable, Map kvs) {
        return null;
    }

    @Override
    public Integer delete(Object o) {
        return null;
    }

    @Override
    public Integer deleteById(Serializable serializable) {
        return null;
    }

    @Override
    public Integer deleteByKey(Serializable serializable, String key, Object value) {
        return null;
    }

    @Override
    public Integer deleteByKeys(Serializable serializable, Map kvs) {
        return null;
    }

    @Override
    public void executeSQL(String sql) {

    }

    @Override
    public T fetchOne(String sql) {
        return null;
    }

    @Override
    public List<T> fetchMany(String sql) {
        return null;
    }
}
