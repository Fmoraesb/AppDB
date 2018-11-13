package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import negocio.Usuario;

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("usuarioDetalhe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tela = null;

		Usuario usuario = new Usuario();
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		if("login".equals(request.getParameter("tela"))) {
			
			usuario = UsuarioDao.validarAcesso(usuario);
			
			if(usuario != null) {
				tela = "contaLista.jsp";
				request.setAttribute("userLogado", usuario);
			} else {
				tela = "login.jsp";
				request.setAttribute("msg", "As informações de acesso estão inválidas");
			}
			
		} else {
			tela = "login.jsp";
			
			usuario.setNome(request.getParameter("nome"));
			usuario.setIdade(Integer.valueOf(request.getParameter("idade")));
			
			UsuarioDao.incluir(usuario);			
		}
		
		request.getRequestDispatcher(tela).forward(request, response);
	}
}