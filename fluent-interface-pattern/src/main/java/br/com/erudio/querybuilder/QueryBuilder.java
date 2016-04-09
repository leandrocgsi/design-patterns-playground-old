package br.com.erudio.querybuilder;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class QueryBuilder {
	
	private Map<String, Object> filters;
	private String sortDirections;
	private String sortFields;
	private Integer pageSize;
	private Integer currentPage;
	private Object alias;
	private String entity;
	
	public String getOrderBy(String alias) {
		return " order by " + alias + "." + sortFields + " " + sortDirections;
	}
	
	public String getWhereAndParameters(String alias) {
		String query = " where ";
		if(filters == null) return query + "1 = 1 ";
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
		return k != null && v != null && !StringUtils.isEmpty(k) && !StringUtils.isEmpty(v.toString());
	}
	
	public String getHQLQuery(String string, String string2) {
		return "select p from Person p"
				+ "  where p.phone = :phone and"
				+ " p.name = :name and"
				+ " p.email = :email and 1 = 1 "
				+ " order by p.name asc";
	}
	
	public QueryBuilder withFilters(Map<String, Object> filters) {
		filters = filters;
		return this;
	}

	public String getBaseSelectCount(String string, String string2) {
		return "select count(*) from Person p ";
	}

	public String getBaseSelect(String string, String string2) {
		return "select p from Person p ";
	}

	public Integer winthPageSize() {
		return (Integer)0;
	}

	public Integer getCurrentPage() {
		return (Integer)0;
	}

	public QueryBuilder withCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		return this;
	}

	public QueryBuilder withPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public QueryBuilder withSortFields(String sortFields) {
		sortFields = sortFields;
		return this;
	}

	public QueryBuilder withSortDirections(String sortDirections) {
		sortDirections = sortDirections;
		return this;
	}
	
	public QueryBuilder withEntity(String entity) {
		entity = entity;
		return this;
	}
	
	public QueryBuilder withAlias(String to) {
		alias = alias;
		return this;
	}
	
	public Integer inCurrentPage() {
		if (currentPage == null) return 1;
		return currentPage;
	}

	public Integer withStart() {
		if (pageSize == null) return 1;
		return pageSize;
	}
}
