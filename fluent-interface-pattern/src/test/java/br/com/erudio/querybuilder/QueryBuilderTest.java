package br.com.erudio.querybuilder;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class QueryBuilderTest {

	QueryBuilder queryBuilder = new QueryBuilder();
	
	@Before
	public void setup() {
	}
	
	@Test
	public void getBaseSelectTest() {
		String baseSelect = "select p from Person p ";
		assertEquals(queryBuilder.getBaseSelect("p", "Person"), baseSelect);
	}
	
	@Test
	public void getStartTest() {
		assertEquals(queryBuilder.withStart(), (Integer)0);
	}
	
	@Test
	public void getBaseSelectCount() {
		String baseSelect = "select count(*) from Person p ";
		assertEquals(queryBuilder.getBaseSelectCount("p", "Person"), baseSelect);
	}
	
	@Test
	public void getWhereAndParametersTest() {
		String whereClause = " where p.phone = :phone and p.name = :name and p.email = :email and 1 = 1 ";
		assertEquals(whereClause, queryBuilder.getWhereAndParameters("p"));
	}
	
	@Test
	public void getWhereAndParametersWithBlankStringKeyTest() {
		Map<String, Object> filters = mockFilters();
		filters.put("", "LEANDRO");
		queryBuilder.withFilters(filters);
		String whereClause = " where p.phone = :phone and p.name = :name and p.email = :email and 1 = 1 ";
		assertEquals(queryBuilder.getWhereAndParameters("p"), whereClause);
	}

	@Test
	@Ignore
	public void getWhereAndParametersWithBlankStringValueTest() {
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put("name", "");
		queryBuilder.withFilters(filters);
		String whereClause = " where 1 = 1 ";
		assertEquals(queryBuilder.getWhereAndParameters("p"), whereClause);
	}
	
	@Test
	public void getHQLQueryTest() {
		String selectWithParameters = "select p from Person p"
				+ "  where p.phone = :phone and"
				+ " p.name = :name and"
				+ " p.email = :email and 1 = 1 "
				+ " order by p.name asc";
		assertEquals(selectWithParameters, queryBuilder.getHQLQuery("p", "Person"));
	}
	
	@Test
	public void getOrderByTest() {
		assertEquals(queryBuilder.getOrderBy("p"), " order by p.name asc");
	}
	
	@Test
	@Ignore
	public void getPageSizeTest() {
		assertEquals(queryBuilder.winthPageSize(), (Integer)10);
	}
	
	@Test
	public void getCurrentPageTest() {
		assertEquals(queryBuilder.inCurrentPage(), (Integer)1);
	}
	
	@Test
	public void getPageSizeNullTest() {
		//queryBuilder.setPageSize(null);
		assertEquals(queryBuilder.winthPageSize(), (Integer)0);
	}
	
	@Test
	public void getCurrentPageNullTest() {
		//queryBuilder.setCurrentPage(null);
		assertEquals(queryBuilder.getCurrentPage(), (Integer)0);
	}
	
	public QueryBuilder mockDTO(){
		queryBuilder.withCurrentPage(1);
		queryBuilder.withPageSize(10);
		queryBuilder.withSortFields("name");
		queryBuilder.withSortDirections("asc");
		queryBuilder.withFilters(mockFilters());
		return queryBuilder;
	}

	private Map<String, Object> mockFilters() {
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put("name", "LEANDRO");
		filters.put("email", "a@b.c");
		filters.put("phone", "12345678998");
		filters.put("cpf", null);
		filters.put("religion", null);
		filters.put("cpf", null);
		filters.put(null, "COSTA");
		return filters;
	}

}
