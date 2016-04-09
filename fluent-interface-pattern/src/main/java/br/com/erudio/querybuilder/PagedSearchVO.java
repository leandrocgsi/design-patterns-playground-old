package br.com.erudio.querybuilder;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PagedSearchVO<T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalResults;
	private String sortFields;
	private String sortDirections;
	private Map<String, Object> filters;
	private List<T> list;

	public PagedSearchVO() {}

	public PagedSearchVO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
	}

	public PagedSearchVO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections, Map<String, Object> filters) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
		this.filters = filters;
	}
	
	public PagedSearchVO(Integer currentPage, String sortFields, String sortDirections) {
		this(currentPage, Integer.valueOf(10), sortFields, sortDirections);
	}
	
	public Integer getCurrentPage(){
		if (currentPage == null) return 0;
		return currentPage;
	}
	
	public Integer getPageSize(){
		if (pageSize == null) return 0;
		return pageSize;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public String getSortFields() {
		return sortFields;
	}

	public void setSortFields(String sortFields) {
		this.sortFields = sortFields;
	}

	public String getSortDirections() {
		return sortDirections;
	}

	public void setSortDirections(String sortDirections) {
		this.sortDirections = sortDirections;
	}

	public Map<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}