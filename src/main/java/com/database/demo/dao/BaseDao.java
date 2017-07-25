package com.database.demo.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public interface BaseDao<T> {
    int delete(Integer id);

    int update(Integer id, T t);

    List<Map<String, Object>> getDatas();

    int insert(T t);
}
