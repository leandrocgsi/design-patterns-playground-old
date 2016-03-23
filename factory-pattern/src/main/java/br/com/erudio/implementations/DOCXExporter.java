package br.com.erudio.implementations;

import br.com.erudio.interfaces.Exporter;

public class DOCXExporter implements Exporter{

	public String exportFile() {
		return "Exportando para .docx";
	}
}
