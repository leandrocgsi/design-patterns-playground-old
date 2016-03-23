package br.com.erudio.factory;

import br.com.erudio.implementations.CSVExporter;
import br.com.erudio.implementations.DOCXExporter;
import br.com.erudio.implementations.PDFExporter;
import br.com.erudio.implementations.XLSXExporter;
import br.com.erudio.implementations.XMLExporter;
import br.com.erudio.interfaces.Exporter;

public class ExporterFactory {

	public Exporter getExporter(String readerType) {
		Exporter exporter = null;
		if (readerType.equalsIgnoreCase("CSV")) {
			exporter = new CSVExporter();
		} else if (readerType.equalsIgnoreCase("DOCX")) {
			exporter = new DOCXExporter();
		} else if (readerType.equalsIgnoreCase("PDF")) {
			exporter = new PDFExporter();
		} else if (readerType.equalsIgnoreCase("XLSX")) {
			exporter = new XLSXExporter();
		} else if (readerType.equalsIgnoreCase("XML")) {
			exporter = new XMLExporter();
		}
		return exporter;
	}

}
