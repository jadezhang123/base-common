package own.jadezhang.base.common.service;


import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.domain.BaseDomain;
import own.jadezhang.base.common.domain.BizData4Page;

import java.util.List;
import java.util.Map;

public interface IBaseService<D extends IBaseDAO, T extends BaseDomain> {
    D getDao();

    Integer add(T entity);

    Integer batchAdd(List<T> entities);

    Integer update(T entity);
    
    Integer updateNull(T entity);

    Integer updateMap(Map<String, Object> entityMap);

    Integer deleteById(Object id);

    Integer deleteByIds(List ids);

    Integer deleteByProperty(String property, Object value);

    Integer deleteByCondition(Map<String, Object> condition);

    T fetch(Object id);

    T findOne(String property, Object value, String orderBy, String sortBy);

    List<T> findList(String property, Object value, String orderBy, String sortBy);

    List<T> findAll();

    List<T> findAll(String orderBy, String sortBy);

    T queryOne(Map<String, Object> condition, String orderBy, String sortBy);

    List<T> queryList(Map<String, Object> condition, String orderBy, String sortBy);

    List<T> like(Map<String, Object> condition, String orderBy, String sortBy);

    Integer count(Map<String, Object> condition);

    BizData4Page paging(Map<String, Object> condition, Integer pageNo, Integer pageSize);

    BizData4Page paging(Map<String, Object> condition, String orderBy, String sortBy, Integer pageNo, Integer pageSize);
}

