package br.com.erudio.querybuilder;

import java.util.Map;

public class QueryBuilder {
	
	private Map<String, Object> filters;
	private String sortDirections;
	private String sortFields;
	private int pageSize;
	private int currentPage;
	
	public String getOrderBy(String alias) {
		return " order by p.name asc";
	}
	
	public String getWhereAndParameters(String alias) {
		return " where p.phone = :phone and p.name = :name and p.email = :email and 1 = 1 ";
	}

	public String getHQLQuery(String string, String string2) {
		return "select p from Person p"
				+ "  where p.phone = :phone and"
				+ " p.name = :name and"
				+ " p.email = :email and 1 = 1 "
				+ " order by p.name asc";
	}
	
	public Map<String, Object> withFilters(Map<String, Object> filters) {
		this.filters = filters;
		return filters;
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

	public QueryBuilder withCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		return this;
	}

	public QueryBuilder withPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public QueryBuilder withSortFields(String sortFields) {
		this.sortFields = sortFields;
		return this;
	}

	public QueryBuilder withSortDirections(String sortDirections) {
		this.sortDirections = sortDirections;
		return this;
	}

	public Integer inCurrentPage() {
		return (Integer)1;
	}

	public Integer withStart() {
		return (Integer)0;
	}
}
