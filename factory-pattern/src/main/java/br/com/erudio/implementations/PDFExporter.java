package br.com.erudio.implementations;

import br.com.erudio.interfaces.Exporter;

public class PDFExporter implements Exporter{

	public String exportFile() {
		return "Exportando para .pdf";
	}
}
