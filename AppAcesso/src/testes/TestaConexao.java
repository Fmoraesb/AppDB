package testes;

import conexao.Conexao;
import dao.UsuarioDao;
import negocio.Usuario;

public class TestaConexao {
	
	public static void main(String[] args) {
		
		if (Conexao.obterConexao() != null){
			System.out.println("Sucesso na conex�o!!!");
			
			//instancie um objeto do tipo Usuario
			Usuario usuario = new Usuario();
			
			//preencha o email e a senha
			usuario.setEmail("elberth.moraes@gmail.com");
			usuario.setSenha("123456");
			
			//passe esse objeto como par�metro para o UsuarioDao
			//e exiba uma mensagem de existe ou de n�o existe
			if(UsuarioDao.validarAcesso(usuario) != null) {
				System.out.println("Usu�rio existente na base de dados!");
			} else {
				System.out.println("Informa��es incorretas!");
			}
			
		} else {
			System.out.println("Erro na conex�o!!!");
		}
	}
}