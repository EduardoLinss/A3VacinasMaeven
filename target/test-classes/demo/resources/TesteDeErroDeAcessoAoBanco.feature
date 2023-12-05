#encoding UTF-8
#language: pt_BR

  Funcionalidade: conferir conexão com DB

    Cenário: verificar conexão com banco DbConnection reportando erro
      Dado usuário o software chamou DbConnection
      Quando chamara função verificarStatus
      Então recebe ‘false’ para conexão
    Cenário: verificar conexão com banco DbConnection com sucesso
      Dado usuário chamou DbConnection
      Quando chamar a função verificarStatus
      Então recebe ‘true’ para conexão

  Funcionalidade: validar credenciais

    Cenário: verificar as credencias do usuário
      Dado email e senha do usuário
      Quando o usuário clica em login o programa deverá fazer a validação do usuário
      Então o programa retorna a mensagem 'login válido'
    Cenário: verificação incorreta das credenciais do usuário
      Dado email e senha do usuário
      Quando o usuário clica em login o programa deverá fazer a validação do usuário
      Então o programa retorna a mensagem 'login inválido, verique as informações'

  Funcionalidade: Cadastrar usuário

    Cenário: cadastrar o usuário no banco de dados
      Dado o usuário deverá fazer o preenchimento dos seguintes dados: nome, senha, email, cpf e data de nascimento
      Quando o usuário clicar em cadastrar, os dados do usuário deverão ser inseridos no banco de dados
      Então o programa retorna a mensagem 'Cadastro realizado com sucesso'
    Cenário: cadastrar o usuário no banco de dados
      Dado o usuário deverá fazer o preenchimento dos seguintes dados: nome, senha, email, cpf e data de nascimento
      Quando o usuário clicar em cadastrar, os dados do usuário deverão ser inseridos no banco de dados
      Então o programa retorna a mensagem 'Não foi possível realizar o cadastro, verifique as informações'

  Funcionalidade: Consultar caderneta

    Cenário: cadastrar nova aplicação
      Dado o usuário deverá fazer o prenchimento dos segunites dados: nome da vacina, data de aplicação, dose, local, cidade
      Quando o usuário clicar em cadastrar nova aplicação, os dados deverão ser inseridos no banco de dados
      Então o programa deverá retornar "Aplicação cadastrada com sucesso"
    Cenário: cadastrar nova aplicação
      Dado o usuário deverá fazer o prenchimento dos segunites dados: nome da vacina, data de aplicação, dose, local, cidade
      Quando o usuário clicar em cadastrar nova aplicação, os dados deverão ser inseridos no banco de dados
      Então o programa deverá retornar "Não foi possível cadastrar a aplicação, verifique as informações"
    Cenário: Editar aplicação já existente
      Dado o usuário deverá digitar o nome da vacina aplicada na barra de pesquisa
      Quando o usuário clicar em pesquisar, o programa deverá retornar as informações referentes a vacina pesquisada
      Então o programa deverá retornar os campos preenchidos para o usuário atualizar as informações desejadas e ao clicar em editar o programa deverá retornar a mensagem 'atualização feita com sucesso'
    Cenário: Editar aplicação já inexistente
      Dado o usuário deverá digitar o nome da vacina aplicada na barra de pesquisa
      Quando o usuário clicar em pesquisar, o programa deverá consultar o banco de dados se a aplicção é existente
      Então em caso de negativa o programa deverá retornar 'Aplicação não encontrada'

  Funcionalidade: Consultar pontos de localização

      Cenário: Consultar possíveis pontos de aplicação de vacinas
        Quando o usuário clicar em Consulta em UBS o programa deverá consultar o banco de dados
        Então o programa deverá retornar a lista dos pontos de aplicação
      Cenário: Falha ao comunicar com o banco de dados para ponsultar possíveis pontos de aplicação de vacinas
        Quando o usuário clicar em Consulta em UBS o programa deverá consultar o banco de dados
        Então o programa deverá 'Não foi possível fazer a a conexão'

