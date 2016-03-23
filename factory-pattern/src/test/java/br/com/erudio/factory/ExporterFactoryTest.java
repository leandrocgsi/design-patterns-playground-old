package br.com.erudio.factory;

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
		System.out.println(exporterFactory.exportar("CSV"));
	}

}
