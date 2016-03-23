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
	public void testCSVFactory() {
		Assert.assertTrue(exporterFactory.getExporter("CSV").exportFile().equals("Exportando para .csv"));
		Assert.assertTrue(exporterFactory.getExporter("DOCX").exportFile().equals("Exportando para .docx")); 
		Assert.assertTrue(exporterFactory.getExporter("PDF").exportFile().equals("Exportando para .pdf")); 
		Assert.assertTrue(exporterFactory.getExporter("XLSX").exportFile().equals("Exportando para .xlsx")); 
		Assert.assertTrue(exporterFactory.getExporter("XML").exportFile().equals("Exportando para .xml")); 
	}

}
