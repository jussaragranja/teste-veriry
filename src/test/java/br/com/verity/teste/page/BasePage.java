package br.com.verity.teste.page;

import br.com.verity.teste.support.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;
import static br.com.verity.teste.support.Driver.driver;


/**
 * @author jussaragranja
 * Classe com ações genericas para as páginas
 */

public class BasePage {

    private static final int LOAD_TIMEOUT = 60;

    public BasePage(){
		PageFactory.initElements(Driver.driver, this);
    }

    public void aguardarElementoVisivel(WebElement element){
        try {
            WebDriverWait driverWait = new WebDriverWait(Driver.driver, LOAD_TIMEOUT);
            driverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            fail("Tempo excedido para aguardar elemento: "+element);
        }
    }
    public void click(WebElement element){
        try {
            aguardarElementoVisivel(element);
            element.click();
        } catch (Exception e) {
            fail("Nao foi possivel encontrar o elemento para clicar: "+element +". Pagina: " + Driver.driver.getTitle()+"\n "+e.getMessage());
        }
    }

    public void preencherCampo(WebElement element, String keysToSend){
        try {
            aguardarElementoVisivel(element);
            element.clear();
            element.sendKeys(keysToSend);
        } catch (WebDriverException e) {
            fail("Nao foi possivel encontrar o elemento para preencher: "+element +". Pagina: " + Driver.driver.getTitle()+"\n "+e.getMessage());

        }
    }

    public void scroll(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0," + element.getLocation().y + ")");
    }

}
