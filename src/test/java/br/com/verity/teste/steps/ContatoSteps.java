package br.com.verity.teste.steps;

import br.com.verity.teste.page.BasePage;
import br.com.verity.teste.page.ContatoPage;
import br.com.verity.teste.page.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

/**
 * @author jussaragranja
 * Steps de teste
 */

public class ContatoSteps extends BasePage {

    ContatoPage contatoPage = new ContatoPage();
    HomePage homePage = new HomePage();


    @Dado("que eu acessei a home page da Verity")
    public void que_eu_acessei_a_home_page_da_verity() {
        homePage.validarPaginaHome();
    }

    @Quando("eu clicar na opção de menu Contato")
    public void eu_clicar_na_opção_de_menu_contato(){
        homePage.clickLinkContato();
    }

    @Quando("preencher os campos Nome Completo {string}, Empresa {string}, Email {string}, Fone {string} e Mensagem {string}")
    public void preencher_os_campos_nome_completo_empresa_email_fone_e_mensagem(String nome, String empresa, String email, String fone, String mensagem) throws InterruptedException {
        contatoPage.inserirDadosDeContato(nome, empresa, email, fone, mensagem);
    }

    @Quando("clicar no botão Enviar")
    public void clicar_no_botão_enviar() {
        contatoPage.clickBotaoEnviar();
    }

    @Então("o site irá registrar o envio apresentando uma mensagem de sucesso {string}")
    public void o_site_irá_registrar_o_envio_apresentando_uma_mensagem_de_sucesso(String string) throws InterruptedException {
        contatoPage.validarMensagemDeSucesso();
    }

}
