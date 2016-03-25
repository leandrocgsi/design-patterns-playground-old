package br.com.erudio;

import org.junit.Test;

public class EmailUtilsTest {
	
	EmailUtils emailUtils = new EmailUtils();

	@Test
	public void test() {
		emailUtils.from("leandrocgsi@gmail.com").withSsl(true);
	}

}
