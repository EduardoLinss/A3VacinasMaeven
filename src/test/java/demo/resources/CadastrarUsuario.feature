#language: pt
#encoding UTF-8

Funcionalidade: Cadastrar usuário

  Cenário: cadastrar o usuário no banco de dados
    Dado os dados solicitados ao usuário
      | username | password | email          | cpf         | dataDeNascimento
      | test     | 123456   | test@test.com  | 00000000000 | 23/08/1979
      | test2    | 789101   | test2@test.com | 11111111111 | 27/01/2001
    Quando o usuário clicar em cadastrar
    E os dados forem inseridos no banco de dados
    Então o programa retorna a mensagem "Cadastro realizado com sucesso"

  Cenário: erro ao cadastrar o usuário
    Dado os dados solicitados ao usuário
    Quando o usuário clicar em cadastrar
    E os dados forem validados no banco de dados
    Mas os dados não estiverem de acordo com o solicitado
    Então o programa retorna a mensagem "Não foi possível realizar o cadastro, verifique as informações"