  
package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Usuario.BancoUsuario;
import Usuario.DadosUsuario;

/**
 * Servlet implementation class Consulta
 * @param <Usuario>
 */
@WebServlet("/Consulta")
public class Consulta<Usuario> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		
		DadosUsuario du = new DadosUsuario();
		
		BancoUsuario.listaUsuario.add(du);

		
		for (DadosUsuario u: BancoUsuario.listaUsuario) {
			
			if(u.getNome().equals(nome)) {
				
				RequestDispatcher rd = req.getRequestDispatcher("/consultaErro.jsp");
				req.setAttribute("nome", du);
				rd.forward(req, resp);
				
			}else {
				
				RequestDispatcher rd = req.getRequestDispatcher("/consultaSucesso.jsp");
				req.setAttribute("usuario", du);
				req.setAttribute("lista", BancoUsuario.listaUsuario);
				rd.forward(req, resp);
				
				}
			
		}
		
	}

}