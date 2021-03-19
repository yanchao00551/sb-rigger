package com.ebaycloud.rigger.framework.object;


/*
 * @Author 悟空
 * @Description //TODO 
 * @Date 19:51 2021/3/18
 * @Param 
 * @return 
 **/

import java.util.List;

public interface AbstractService<T,PK> {
    T insert(T entity);

    default void insertList(List<T> entities) {

    }

    boolean removeByPrimaryKey(PK primaryKey);

    boolean updateSelective(T entity);

    T getByPrimaryKey(PK primaryKey);

    default List<T> listAll() {
        return null;
    }
}
