package own.jadezhang.base.common.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BizData4Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 当前页号
	 */
	private int pageNo = 1;
	/**
	 * 总页数
	 */
	private int totalPages = 0;
	/**
	 * 一页显示行数
	 */
	private int pageSize = 10;
	/**
	 * 总记录数
	 */
	private int recordCount = 0;
	/**
	 * 当前页面数据
	 */
	private List<T> rows;
	/**
	 * 分页查询的条件
	 */
	private Map<String, Object> conditions = new HashMap<String, Object>();
	/**
	 * 附带的数据
	 */
	private Map<String, Object> extraData;

	public BizData4Page() {
		super();
	}

	public BizData4Page(List<T> rows, int recordCount, int pageNo, int pageSize) {
		this.rows = rows;
		this.recordCount = recordCount;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		int total = recordCount / pageSize;
		int mod = recordCount % pageSize;
		if (mod > 0) {
			total++;
		}
		this.totalPages = total == 0 ? 1 : total;
	}

	public BizData4Page(List<T> rows, int recordCount, int pageNo,
			int pageSize, Map<String, Object> extraData) {
		this(rows, recordCount, pageNo, pageSize);
		this.extraData = extraData;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Map<String, Object> getConditions() {
		return conditions;
	}

	public void setConditions(Map<String, Object> conditions) {
		this.conditions = conditions;
	}

	public Map<String, Object> getExtraData() {
		return extraData;
	}

	public void setExtraData(Map<String, Object> extraData) {
		this.extraData = extraData;
	}

	// 静态工厂方法
	public static <T> BizData4Page<T> page(List<T> rows, int recordCount,
			int pageNo, int pageSize) {
		return new BizData4Page<T>(rows, recordCount, pageNo, pageSize);
	}

	public static <T> BizData4Page<T> pageWithExtraData(List<T> rows,
			int recordCount, int pageNo, int pageSize,
			Map<List, Object> extraData) {
		return new BizData4Page<T>(rows, recordCount, pageNo, pageSize);
	}

	public static BizData4Page forNoRecords(int pageSize) {
		return new BizData4Page(Collections.emptyList(), 0, 1, pageSize);
	}

}
