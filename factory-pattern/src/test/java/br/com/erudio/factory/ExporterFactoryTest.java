package br.com.erudio.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExporterFactoryTest {

	ExporterFactory exporterFactory;

	@Before
	public void setUp() {
		exporterFactory = new ExporterFactory();
	}

	@Test
	public void testCSVFactory() throws Exception {
		Assert.assertTrue(exporterFactory.getExporter("CSV").exportFile().equals("Exportando para .csv"));
	}
	
	@Test
	public void testDOCXFactory() throws Exception {
		Assert.assertTrue(exporterFactory.getExporter("DOCX").exportFile().equals("Exportando para .docx")); 
	}
	
	@Test
	public void testPDFFactory() throws Exception {
		Assert.assertTrue(exporterFactory.getExporter("PDF").exportFile().equals("Exportando para .pdf")); 
	}
	
	@Test
	public void testXLSXFactory() throws Exception {
		Assert.assertTrue(exporterFactory.getExporter("XLSX").exportFile().equals("Exportando para .xlsx")); 
	}
	
	@Test
	public void testXMLFactory() throws Exception {
		Assert.assertTrue(exporterFactory.getExporter("XML").exportFile().equals("Exportando para .xml")); 
	}
	
	@Test(expected = Exception.class) 
	public void testUnsuportedFactory() throws Exception {
		exporterFactory.getExporter("XYZ"); 
	}

}
