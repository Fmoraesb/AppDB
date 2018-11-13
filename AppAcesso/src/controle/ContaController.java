package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaDao;
import negocio.Conta;

public class ContaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContaController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("idLogado", request.getParameter("idLogado"));
		
		request.getRequestDispatcher("contaDetalhe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conta conta = new Conta();
		conta.setDescricao(request.getParameter("descricao"));
		conta.setValor(Float.valueOf(request.getParameter("valor")));
		conta.setDebito("D".equals(request.getParameter("tipo")));
		
		ContaDao.incluir(conta);
		
		request.setAttribute("listaContas", ContaDao.obterLista());
		
		Long id = Long.valueOf(request.getParameter("idLogado"));
		
		request.setAttribute("userLogado", id);
		
		request.getRequestDispatcher("contaLista.jsp").forward(request, response);		
	}
}