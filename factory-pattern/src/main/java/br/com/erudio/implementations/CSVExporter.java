package br.com.erudio.implementations;

import br.com.erudio.interfaces.Exporter;

public class CSVExporter implements Exporter{

	public String exportFile() {
		return "Exportando para .csv";
	}
}
