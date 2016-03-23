package br.com.erudio.implementations;

import br.com.erudio.interfaces.Exporter;

public class XLSXExporter implements Exporter{

	public String exportFile() {
		return "Exportando para .xlsx";
	}
}
