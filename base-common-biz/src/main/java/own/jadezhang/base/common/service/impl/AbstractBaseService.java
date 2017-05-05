package own.jadezhang.base.common.service.impl;

import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.domain.BaseDomain;
import own.jadezhang.base.common.domain.BizData4Page;
import own.jadezhang.base.common.service.IBaseService;

import java.util.List;
import java.util.Map;

public abstract class AbstractBaseService<D extends IBaseDAO, T extends BaseDomain> implements IBaseService<D, T> {
	@Override
    public Integer add(T entity) {
        return getDao().insert(entity);
    }

    @Override
    public Integer batchAdd(List<T> entities) {
        if (entities != null && entities.size() > 0) {
            return getDao().batchInsert(entities);
        }
        return 0;
    }

    @Override
    public Integer updateNull(T entity) {
        return getDao().updateNull(entity);
    }

    @Override
    public Integer update(T entity) {
        return getDao().update(entity);
    }

    @Override
    public Integer updateMap(Map<String, Object> entityMap) {
        return getDao().updateMap(entityMap);
    }

    @Override
    public Integer deleteById(Object id) {
        return getDao().deleteById(id);
    }

    @Override
    public Integer deleteByIds(List ids) {
        return getDao().deleteByIds(ids);
    }

    @Override
    public Integer deleteByProperty(String property, Object value) {
        return getDao().deleteByProperty(property, value);
    }

    @Override
    public Integer deleteByCondition(Map<String, Object> condition) {
        return getDao().deleteByCondition(condition);
    }

    @Override
    public T fetch(Object id) {
        return (T) getDao().fetch(id);
    }

    @Override
    public T findOne(String property, Object value, String orderBy, String sortBy) {
        return (T) getDao().findOne(property, value, orderBy, sortBy);
    }

    @Override
    public List<T> findList(String property, Object value, String orderBy, String sortBy) {
        return getDao().findList(property, value, orderBy, sortBy);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll(null, null);
    }

    @Override
    public List<T> findAll(String orderBy, String sortBy) {
        return getDao().findAll(orderBy, sortBy);
    }

    @Override
    public T queryOne(Map<String, Object> condition, String orderBy, String sortBy) {
        return (T) getDao().queryOne(condition, orderBy, sortBy);
    }

    @Override
    public List<T> queryList(Map<String, Object> condition, String orderBy, String sortBy) {
        return getDao().queryList(condition, orderBy, sortBy);
    }

    @Override
    public List<T> like(Map<String, Object> condition, String orderBy, String sortBy) {
        return getDao().like(condition, orderBy, sortBy);
    }

    @Override
    public Integer count(Map<String, Object> condition) {
        return getDao().count(condition);
    }

    @Override
    public BizData4Page queryForPage(Map<String, Object> condition, Integer pageNo, Integer pageSize) {
        return paging(condition, null, null, pageNo, pageSize);
    }

    @Override
    public BizData4Page queryForPage(Map<String, Object> condition, String orderBy, String sortBy, Integer pageNo, Integer pageSize) {
        return paging(condition, sortBy, orderBy, pageNo, pageSize);
    }

    private BizData4Page paging(Map<String, Object> condition, String orderBy, String sortBy, Integer pageNo, Integer pageSize){
        Integer count = getDao().count(condition);
        List list = getDao().queryForPage(condition, orderBy, sortBy, (pageNo - 1) * pageSize, pageSize);
        return BizData4Page.page(list, count, pageNo, pageSize);
    }
}
