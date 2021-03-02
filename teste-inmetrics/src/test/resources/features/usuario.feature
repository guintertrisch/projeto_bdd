# language: pt

Funcionalidade: Cadastro de Usuário

  Esquema do Cenário: Cadastrar Usuário
    Quando preencho os dados de cadastro "<login>" , "<password>", "<confirmpassword>"
    E clico em Cadastrar
    Entao devo voltar para tela de login

    Exemplos:
      | login       | password | confirmpassword |
      | operacao100 | teste123 | teste123        |