package ufps.edu.co.dao;

import ufps.edu.co.util.Conexion;
import ufps.edu.co.entity.Tienda;

public class TiendaDao  extends Conexion<Tienda> implements GenericDao<Tienda>{

	public TiendaDao() {
		super(Tienda.class);
	}
	
}