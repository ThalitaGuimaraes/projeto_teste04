#language: pt

Funcionalidade: Autenticar Usuários
	como um usuário cadastrado no sistema
	eu quero acessar minha conta
	para que eu possa utilizar os recursos do sistema
	
Cenário: Autenticação de usuário com sucesso
	Dado Acessar a página de autenticação
	E Informar o email "admin@gmail.com"
	E Informar a senha "@Admin123"
	Quando Solicitar a realização do acesso
	Então Sistema autentica o usuário com sucesso