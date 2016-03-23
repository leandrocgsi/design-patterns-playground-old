package br.com.erudio.implementations;

import br.com.erudio.interfaces.Exporter;

public class XMLExporter implements Exporter{

	public String exportFile() {
		return "Exportando para .xml";
	}
}
