#language: pt
#encoding UTF-8


Funcionalidade: Consultar caderneta

  Cenário: cadastrar nova aplicação
    Dado o usuário deverá fazer o preenchimento dos seguintes dados: nome da vacina, data de aplicação, dose, local, cidade
    Quando o usuário clicar em cadastrar nova aplicação, os dados deverão ser inseridos no banco de dados
    Então o programa deverá retornar "Aplicação cadastrada com sucesso"
  Cenário: cadastrar nova aplicação
    Dado o usuário deverá fazer o preenchimento dos seguintes dados: nome da vacina, data de aplicação, dose, local, cidade
    Quando o usuário clicar em cadastrar nova aplicação, os dados deverão ser inseridos no banco de dados
    Então o programa deverá retornar "Não foi possível cadastrar a aplicação, verifique as informações"
  Cenário: Editar aplicação já existente
    Dado o usuário deverá digitar o nome da vacina aplicada na barra de pesquisa
    Quando o usuário clicar em pesquisar, o programa deverá retornar as informações referentes a vacina pesquisada
    Então o programa deverá retornar os campos preenchidos para o usuário atualizar as informações desejadas e ao clicar em editar o programa deverá retornar a mensagem "Atualização feita com sucesso"
  Cenário: Editar aplicação já inexistente
    Dado o usuário deverá digitar o nome da vacina aplicada na barra de pesquisa
    Quando o usuário clicar em pesquisar, o programa deverá consultar o banco de dados se a aplicção é existente
    Então em caso de negativa o programa deverá retornar "Aplicação não encontrada"