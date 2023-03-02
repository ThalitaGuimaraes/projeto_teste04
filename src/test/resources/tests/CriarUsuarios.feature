#language: pt

Funcionalidade: Criar Usuários
	como um usuário do sistema
	eu quero cadastrar minha conta
	para que eu possa acessar o sistema
	
Cenário: Criação de conta de usuário com sucesso
	Dado Acessar a página de cadastro de usuário
	E Informar o nome do usuário "Sergio Mendes"
	E Informar o email do usuário "sergio.coti@gmail.com"
	E Informar a senha do usuário "@Admin123"
	E Confirmar a senha do usuário "@Admin123"
	Quando Solicitar a realização do cadastro
	Então Sistema cadastra o usuário com sucesso