package br.com.verity.teste.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

/**
 * @author jussaragranja
 * Classe representa a página inicial da aplicação
 */

public class HomePage extends BasePage {

    @FindBy(tagName = "title")
    private WebElement titulo;

    @FindBy(id = "comp-kevyodnk7label")
    private WebElement linkContato;

    public void validarPaginaHome(){
        assertEquals("Home | Verity Digital - A Intensificação Digital Começa Aqui", titulo.getText());
    }

    public void clickLinkContato(){
        click(linkContato);
    }

}
