#language: pt
#encoding UTF-8

Funcionalidade: Consultar pontos de localização

  Cenário: Consultar pontos de aplicação de vacinas
    Quando o usuário clicar em Consulta em UBS
    E o programa deverá consultar o banco de dados
    Então deverá retornar a lista dos pontos de aplicação
    Mas se a consulta ao banco de dados falhar o programa deverá consultar o banco de dados
    Então o programa deverá "Não foi possível fazer a a conexão"