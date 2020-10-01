package br.com.verity.teste.steps;

import br.com.verity.teste.page.BasePage;
import br.com.verity.teste.support.Driver;
import br.com.verity.teste.support.Property;
import io.cucumber.java.After;
import io.cucumber.java.Before;


/**
 * @author jussaragranja
 * Métodos a serem executados antes e depois dos testes
 */

public class Hooks extends BasePage {
	
	@Before
    public void before() {
		Driver.driver = Driver.getDriver();
		Driver.driver.navigate().to(Property.URL);
    }
	  
	 @After
	 public void after() {
		 if(Driver.driver != null){
			 Driver.driver.quit();
		 }
		 Driver.driver = null;
	  }

}
