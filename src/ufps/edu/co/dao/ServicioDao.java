package ufps.edu.co.dao;

import ufps.edu.co.entity.Servicio;
import ufps.edu.co.util.Conexion;

public class ServicioDao  extends Conexion<Servicio> implements GenericDao<Servicio>{

	public ServicioDao() {
		super(Servicio.class);
	}
	
}
