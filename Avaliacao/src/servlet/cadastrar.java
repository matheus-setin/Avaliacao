package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import Usuario.BancoUsuario;
import Usuario.DadosUsuario;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/Cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");
	
		DadosUsuario du = new DadosUsuario(); 
		
		du.setNome(nome);
		du.setEmail(email);
		du.setTelefone(telefone);
		
		Usuario.BancoUsuario.listaUsuario.add(du);
		
		for (DadosUsuario u: BancoUsuario.listaUsuario) {
			
			u.getEmail();
			
			if (u.getEmail().equals(email)) {
				
				RequestDispatcher rd = req.getRequestDispatcher("/cadastroErro.jsp");
				req.setAttribute("email", du);
				rd.forward(req, resp);
				
			}else {
			
			RequestDispatcher rd = req.getRequestDispatcher("/cadastroSucesso.jsp");
			req.setAttribute("usuario", du);
			req.setAttribute("lista", Usuario.BancoUsuario.listaUsuario);
			rd.forward(req, resp);
			
			}
		}	
		
	}

}