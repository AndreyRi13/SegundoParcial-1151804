package ufps.edu.co.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ufps.edu.co.entity.Cliente;
import ufps.edu.co.dao.ClienteDao;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		//response.getWriter().append("Hola mama"+action).append(request.getContextPath());
		switch(action) {
		case "login": request.getRequestDispatcher("vistas/login.jsp").forward(request, response);
			break;
		case "registro": request.getRequestDispatcher("vistas/registro.jsp").forward(request, response);
		break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		case "ingresar": 
			String email=request.getParameter("inputEmail");
			String password=request.getParameter("inputPassword");
			ClienteDao cliented=new ClienteDao();
			List<ufps.edu.co.entity.Cliente> lista=cliented.list();
			for(ufps.edu.co.entity.Cliente c:lista) {
				if(c.getEmail().equals(email) && c.getClave().equals(password)) {
					request.getRequestDispatcher("/Servicios?userid="+c.getId()).forward(request, response);
				}
			}
		break;
		}
		doGet(request, response);
	}

}
