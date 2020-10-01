package br.com.verity.teste.page;

import br.com.verity.teste.support.Browser;
import br.com.verity.teste.support.Property;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static br.com.verity.teste.support.Driver.driver;

/**
 * @author jussaragranja
 * Classe representa a página de contato do site
 */

public class ContatoPage extends BasePage {

    @FindBy(id = "comp-kex026e31input")
    private WebElement inputNomeCompleto;

    @FindBy(id = "comp-kex026ecinput")
    private WebElement inputEmpresa;

    @FindBy(id = "comp-kex026eeinput")
    private WebElement inputEmail;

    @FindBy(id = "comp-kex026eginput")
    private WebElement inputFone;

    @FindBy(id = "comp-kex026eitextarea")
    private WebElement inputMensagem;

    @FindBy(id = "comp-kex026eq2label")
    private WebElement botaoEnviar;

    @FindBy(xpath = "//span[@style='font-family:wfont_49da48_88f437f0230e4edf826d185a5f782a1e,wf_88f437f0230e4edf826d185a5,orig_nexa_book;']")
    private WebElement mensagemDeSucesso;

    public void inserirDadosDeContato(String nome, String empresa, String email, String fone, String mensagem) throws InterruptedException {
        Thread.sleep(2000);
        scroll(inputNomeCompleto);
        preencherCampo(inputNomeCompleto, nome);
        preencherCampo(inputEmpresa, empresa);
        preencherCampo(inputEmail, email);
        preencherCampo(inputFone, fone);
        preencherCampo(inputMensagem, mensagem);
    }

    public void clickBotaoEnviar(){
        click(botaoEnviar);
    }

    public void validarMensagemDeSucesso() throws InterruptedException {
        if(Browser.REMOTECHROME.equals(Property.BROWSER_NAME)) {
            Thread.sleep(1500);
        }
        aguardarElementoVisivel(mensagemDeSucesso);
        assertEquals("Mensagem enviada com sucesso!", mensagemDeSucesso.getText());
    }

}
