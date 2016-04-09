package br.com.erudio.querybuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class PagedSearchDTO<T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalResults;
	private String sortFields;
	private String sortDirections;
	private Map<String, Object> filters;
	private List<T> list;

	public PagedSearchDTO() {}

	public PagedSearchDTO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
	}

	public PagedSearchDTO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections, Map<String, Object> filters) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
		this.filters = filters;
	}
	
	public PagedSearchDTO(Integer currentPage, String sortFields, String sortDirections) {
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

	public Integer getStart() {
		return Integer.valueOf((getCurrentPage() - 1) * getPageSize());
	}
	
	private String getOrderBy(String alias) {
		return " order by " + alias + "." + sortFields + " " + sortDirections + "";
	}
	
	private String getWhereAndParameters(String alias) {
		String query = " where ";
		
		for (Map.Entry<String, Object> entry : filters.entrySet()){
		    String k = entry.getKey();
			Object v = entry.getValue();
		    if (entryIsEmpty(k, v)) {
				query = query + alias + "." + k + " = :" + k + " and ";
			}
		}
		return query + "1 = 1 ";
	}

	private boolean entryIsEmpty(String k, Object v) {
		return !StringUtils.isEmpty(k) && !StringUtils.isEmpty(v.toString());
	}
	
	/*void setParameters(Query query) {
		for (Map.Entry<String, Object> entry : filters.entrySet()){
		    String k = entry.getKey();
			Object v = entry.getValue();
		    if (entryIsEmpty(k, v)) {
		    	query.setParameter(k, v);
			}
		}
	}*/
	
	public String getHQLQuery(String alias, String entityName) {
		return getBaseSelect(alias, entityName) + getWhereAndParameters(alias) + getOrderBy(alias);
	}

	public String getBaseSelect(String alias, String entityName) {
		return "select " + alias + " from " + entityName + " " + alias + " ";
	}

	public String getBaseSelectCount(String alias, String entityName) {
		return "select count(*) from " + entityName + " " + alias + " ";
	}
	
	/* public Long getTotal(EntityManager entityManager, String alias, String entityName) {
		String select = getBaseSelectCount(alias, entityName) + getWhereAndParameters(alias);
		Query query = entityManager.createQuery(select);
		setParameters(query);
		(Long)query.getSingleResult();
	}
	
	public Query getSearchQuery(EntityManager entityManager, String alias, String entityName) {
		Query query = entityManager.createQuery(getHQLQuery(alias, entityName));
		setParameters(query);
		query.setFirstResult((getCurrentPage() - 1) * getPageSize());
		query.setMaxResults(getPageSize());
	}
	
	public PagedSearchDTO<T> getPagedSearch(EntityManager entityManager, String alias, String entityName) {
		Query searchQuery = getSearchQuery(entityManager, alias, entityName);
		setList(searchQuery.getResultList());
		setTotalResults(getTotal(entityManager, alias, entityName).intValue());
		return this;
	}*/
}