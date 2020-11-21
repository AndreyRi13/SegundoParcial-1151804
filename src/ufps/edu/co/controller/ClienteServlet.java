package ufps.edu.co.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.crud.controller.RequestDispatcher;
import co.edu.ufps.crud.controller.Servlet;
import co.edu.ufps.crud.controller.ServletConfig;
import ufps.edu.co.dao.ClienteDao;
import ufps.edu.co.entity.Cliente;




/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.clienteDao = new ClienteDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		switch(action) {
		
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			insertarCliente(request, response);
			break;
		case "/delete":
			 eliminarCliente(request, response);
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/update":
			actualizarCliente(request,response);
			break;

		default:
			listCliente(request,response);
			break;
		}
		  }
		catch(SQLException e) {
			throw new ServletException(e);
		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		dispatcher.forward(request, response);
	}
	
private void insertarCliente(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, SQLException, IOException {
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		
		Cliente cliente = new Cliente (marca,modelo,color);
		clienteDao.insert(cliente);
		
		response.sendRedirect("listAutos");
		
				
	}

private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        clienteDao.delete(id);
	        response.sendRedirect("listAutos");

	    }

private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Cliente autoActual = clienteDao.select(id);
	        request.setAttribute("auto", autoActual);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
	        dispatcher.forward(request, response);

	    }

private void actualizarCliente(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
	String marca = request.getParameter("marca");
	String modelo = request.getParameter("modelo");
	String color = request.getParameter("color");
	
	Auto auto = new Auto (id,marca,modelo,color);
	autoDao.update(auto);
	
	response.sendRedirect("listAutos");
	       
	    }

private void listCliente(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	        List < Cliente > clientes = clienteDao.selectAll();
	        request.setAttribute("clientes", clientes);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
	    }




}