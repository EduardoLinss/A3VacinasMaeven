#language: pt
#encoding UTF-8

Funcionalidade: Validar Credenciais

  Cenário: verificar as credencias do usuário
    Dado email e senha do usuário
    Quando o usuário clica em login
    E os dados conferire com o BD
    Então o programa retorna a mensagem "Login válido"
    Mas os dados não conferirem com o BD
    Então o programa retorna a mensagem "login inválido, verifique as informações"