package com.ebaycloud.rigger.framework.object;



import java.util.List;

/**
 *
 * @author 悟空
 * @description //TODO 
 * @date 23:18 2021/4/2
 * @param null
 * @return null
 */
public interface AbstractService<T,PK> {

    /**
     * 插入
     * @author 悟空
     * @description //TODO
     * @date 23:07 2021/4/2
     * @param entity
     * @return T
     */
    T insert(T entity);


    /**
     * 默认插入集合实现
     * @author 悟空
     * @description //TODO
     * @date 22:46 2021/4/2
     * @param entities
     * @return void
     */
    default void insertList(List<T> entities) {

    }


    /**
     * 根据主键删除
     * @author 悟空
     * @description //TODO
     * @date 22:46 2021/4/2
     * @param primaryKey
     * @return boolean
     */
    boolean removeByPrimaryKey(PK primaryKey);

    /**
     * 更新
     * @author 悟空
     * @description //TODO
     * @date 22:47 2021/4/2
     * @param entity
     * @return boolean
     */
    boolean updateSelective(T entity);


    /**
     * 根据主键获取
     * @author 悟空
     * @description //TODO 
     * @date 23:14 2021/4/2
     * @param primaryKey
     * @return T
     */
    T getByPrimaryKey(PK primaryKey);


    /**
     * 默认获取所有
     * @author 悟空
     * @description //TODO
     * @date 22:47 2021/4/2
     * @param
     * @return java.util.List<T>
     */
    default List<T> listAll() {
        return null;
    }
}
