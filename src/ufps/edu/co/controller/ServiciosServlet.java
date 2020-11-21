package ufps.edu.co.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ufps.edu.co.dao.SeguirPKDao;
import ufps.edu.co.dao.TiendaDao;
import ufps.edu.co.entity.Seguir;
import ufps.edu.co.entity.SeguirPK;

/**
 * Servlet implementation class Servicios
 */
@WebServlet("/Servicios/*")
public class ServiciosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiciosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userid=request.getParameter("userid");
		SeguirPKDao seguir = new SeguirPKDao();
		List<SeguirPK> lista = seguir.list();
		for(SeguirPK sp: lista) {
			if(sp.getCliente()==Integer.parseInt(userid)) {
				TiendaDao t=new TiendaDao();
				request.getRequestDispatcher("vistas/servicios.jsp?tiendaid="+t.find(sp.getTienda()).getId()).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
