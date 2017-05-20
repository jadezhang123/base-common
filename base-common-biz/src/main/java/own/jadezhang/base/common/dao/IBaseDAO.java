package own.jadezhang.base.common.dao;

import org.apache.ibatis.annotations.Param;
import own.jadezhang.base.common.domain.BaseDomain;

import java.util.List;
import java.util.Map;

public interface IBaseDAO<T extends BaseDomain> {
	
	Integer insert(T entity);

	Integer batchInsert(List<T> entities);
    
    /**
     * 更新对象,如果属性为null，则不会进行对应的属性值更新,如果有属性要更新为null，请参看{@link #updateNull(T)}
     * @param entity
     * @return
     */
	Integer update(T entity);

	Integer updateMap(@Param("update") Map<String, Object> entityMap);
    /**
     * 更新对象,如果属性为null，会进行对应的属性值更新,如果有属性不想更新为null，请参看{@link #update(T)}
     * @param entity
     * @return
     */
	Integer updateNull(T entity);

    Integer deleteById(@Param("id") Object id);

    Integer deleteByIds(@Param("ids") List ids);

    Integer deleteByProperty(@Param("property") String property, @Param("value") Object value);

    Integer deleteByCondition(Map<String, Object> condition);

    T fetch(Object id);

    T findOne(@Param("property") String property, @Param("value") Object value, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    List<T> findList(@Param("property") String property, @Param("value") Object value, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    List<T> findAll(@Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    T queryOne(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    List<T> queryList(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    Integer count(@Param("condition") Map<String, Object> condition);

    List<T> paging(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy,
                         @Param("offset") Integer offset, @Param("rows") Integer rows);

    List<T> like(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

}
