package own.jadezhang.base.common.service;


import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.domain.BaseDomain;
import own.jadezhang.base.common.domain.BizData4Page;

import java.util.List;
import java.util.Map;

public interface IBaseService<D extends IBaseDAO, T extends BaseDomain> {
    D getDao();

    /**
     *
     * @param entity
     * @return
     */
    Integer add(T entity);

    /**
     *
     * @param entities
     * @return
     */
    Integer batchAdd(List<T> entities);

    /**
     *
     * @param entity
     * @return
     */
    Integer update(T entity);

    /**
     *
     * @param entity
     * @return
     */
    Integer updateNull(T entity);

    /**
     *
     * @param entityMap
     * @return
     */
    Integer updateMap(Map<String, Object> entityMap);

    /**
     *
     * @param update
     * @param condition
     * @return
     */
    Integer updateByCondition(Map<String, Object> update, Map<String, Object> condition);

    /**
     *
     * @param id
     * @return
     */
    Integer deleteById(Object id);

    /**
     *
     * @param ids
     * @return
     */
    Integer deleteByIds(List ids);

    /**
     *
     * @param property
     * @param value
     * @return
     */
    Integer deleteByProperty(String property, Object value);

    /**
     *
     * @param condition
     * @return
     */
    Integer deleteByCondition(Map<String, Object> condition);

    /**
     *
     * @param id
     * @return
     */
    T fetch(Object id);

    /**
     *
     * @param property
     * @param value
     * @param orderBy
     * @param sortBy
     * @return
     */
    T findOne(String property, Object value, String orderBy, String sortBy);

    /**
     *
     * @param property
     * @param value
     * @param orderBy
     * @param sortBy
     * @return
     */
    List<T> findList(String property, Object value, String orderBy, String sortBy);

    /**
     *
     * @return
     */
    List<T> findAll();

    /**
     *
     * @param orderBy
     * @param sortBy
     * @return
     */
    List<T> findAll(String orderBy, String sortBy);

    /**
     *
     * @param condition
     * @param orderBy
     * @param sortBy
     * @return
     */
    T queryOne(Map<String, Object> condition, String orderBy, String sortBy);

    /**
     *
     * @param condition
     * @param orderBy
     * @param sortBy
     * @return
     */
    List<T> queryList(Map<String, Object> condition, String orderBy, String sortBy);

    /**
     *
     * @param condition
     * @param orderBy
     * @param sortBy
     * @return
     */
    List<T> like(Map<String, Object> condition, String orderBy, String sortBy);

    /**
     *
     * @param condition
     * @return
     */
    Integer count(Map<String, Object> condition);

    /**
     *
     * @param condition
     * @param pageNo
     * @param pageSize
     * @return
     */
    BizData4Page paging(Map<String, Object> condition, Integer pageNo, Integer pageSize);

    /**
     *
     * @param condition
     * @param orderBy
     * @param sortBy
     * @param pageNo
     * @param pageSize
     * @return
     */
    BizData4Page paging(Map<String, Object> condition, String orderBy, String sortBy, Integer pageNo, Integer pageSize);
}

