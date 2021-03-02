# language: pt

Funcionalidade: Login

  Esquema do Cenário: Login Válido
    Quando preencho os dados de "<login>" e "<password>"
    E clico em Entre
    Entao devo entrar na tela de listagem de funcionarios

    Exemplos:
      | login       | password |
      | operacao143 | teste123 |





