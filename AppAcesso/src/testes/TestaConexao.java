package testes;

import conexao.Conexao;
import dao.UsuarioDao;
import negocio.Usuario;

public class TestaConexao {
	
	public static void main(String[] args) {
		
		if (Conexao.obterConexao() != null){
			System.out.println("Sucesso na conexão!!!");
			
			//instancie um objeto do tipo Usuario
			Usuario usuario = new Usuario();
			
			//preencha o email e a senha
			usuario.setEmail("elberth.moraes@gmail.com");
			usuario.setSenha("123456");
			
			//passe esse objeto como parâmetro para o UsuarioDao
			//e exiba uma mensagem de existe ou de não existe
			if(UsuarioDao.validarAcesso(usuario) != null) {
				System.out.println("Usuário existente na base de dados!");
			} else {
				System.out.println("Informações incorretas!");
			}
			
		} else {
			System.out.println("Erro na conexão!!!");
		}
	}
}