#language: pt
Funcionalidade: Mensagem para contato
  Enviar mensagem de contato e validar mensagem de sucesso

  Esquema do Cenário: Enviar mensagem de contato
    Dado que eu acessei a home page da Verity
    Quando eu clicar na opção de menu Contato
    E preencher os campos Nome Completo "<nome>", Empresa "<empresa>", Email "<email>", Fone "<fone>" e Mensagem "<mensagem>"
    E clicar no botão Enviar
    Então o site irá registrar o envio apresentando uma mensagem de sucesso "<mensagem>"

    Exemplos:
      |nome         |empresa        |email            |fone           |mensagem                       |
      |Nome Teste   |Empresa Teste  |teste@teste.com  |99 99999-9999  |Mensagem enviada com sucesso!  |