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
//		queryBuilder.withCurrentPage(1).withPageSize(10).withSortFields("name").withSortDirections("asc").withFilters(mockFilters());
	}
	
	@Test
	public void getBaseSelectTest() {
		String baseSelect = "select p from Person p ";
		assertEquals(queryBuilder.getBaseSelect("p", "Person"), baseSelect);
	}
	
	@Test
	public void getStartTest() {
		assertEquals((Integer)1, queryBuilder.withStart());
	}
	
	@Test
	public void getBaseSelectCount() {
		String baseSelect = "select count(*) from Person p ";
		assertEquals(queryBuilder.getBaseSelectCount("p", "Person"), baseSelect);
	}
	
	@Test
	@Ignore
	public void getWhereAndParametersTest() {
		String whereClause = " where p.phone = :phone and p.name = :name and p.email = :email and 1 = 1 ";
		assertEquals(whereClause, queryBuilder.withCurrentPage(1).withPageSize(10).withSortFields("name").withSortDirections("asc").withFilters(mockFilters()).getWhereAndParameters("p"));
	}
	
	@Test
	@Ignore
	public void getWhereAndParametersWithBlankStringKeyTest() {
		Map<String, Object> filters = mockFilters();
		filters.put("", "LEANDRO");
		String whereClause = " where p.phone = :phone and p.name = :name and p.email = :email and 1 = 1 ";
		assertEquals(queryBuilder.withFilters(filters).getWhereAndParameters("p"), whereClause);
	}

	@Test
	public void getWhereAndParametersWithBlankStringValueTest() {
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put("name", "");
		String whereClause = " where 1 = 1 ";
		assertEquals(queryBuilder.withFilters(filters).getWhereAndParameters("p"), whereClause);
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
	@Ignore
	public void getOrderByTest() {
		assertEquals(" order by p.name asc", queryBuilder.withCurrentPage(1).withPageSize(10).withSortFields("name").withSortDirections("asc").withFilters(mockFilters()).getOrderBy("p"));
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
		assertEquals(queryBuilder.withCurrentPage(null).getCurrentPage(), (Integer)0);
	}
	
	public QueryBuilder mockDTO(){
		queryBuilder.withCurrentPage(1).withPageSize(10).withSortFields("name").withSortDirections("asc").withFilters(mockFilters());
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
