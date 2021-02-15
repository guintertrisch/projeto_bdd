# language: pt

Funcionalidade: Cadastrar Usuário

  Cenario: Cadastrar um usuário válido
    Dado que eu acesse o link Cadastre-se
    Quando preencho os dados de usuário com valor "usuario"
    E a senha com valor "teste123"
    E confirme a senha com o valor "teste123"
    E clico em Cadastrar
    Entao devo retornar para tela de "Login"



