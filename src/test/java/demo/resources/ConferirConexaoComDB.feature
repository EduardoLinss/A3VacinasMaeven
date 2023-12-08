#language: pt
#encoding UTF-8


Funcionalidade: conferir conexão com DB

  Cenário: verificar conexão com banco DbConnection com sucesso
    Dado o <URL> o <User> e a <Senha>
    E chamar a openDatabase
    E os dados estiverem corretos
    Quando chamara função verificarStatus
    Então recebe "true" para conexão
    E apresenta a mensagem "Conectado com sucesso em: "

  Cenário: verificar conexão DbConnection reportando erro
    Dado o <URL> o <User> e a <Senha>
    E chamar a openDatabase
    E os dados estiverem divergente
    Quando chamara função verificarStatus
    Então recebe "false" para conexão
    E apresenta a mensagem"Error on connect: "

