package ufps.edu.co.dao;


import ufps.edu.co.entity.Cliente;
import ufps.edu.co.util.Conexion;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente>{

	public ClienteDao() {
		super(Cliente.class);
	}
	
}

