package ufps.edu.co.dao;


import ufps.edu.co.entity.Seguir;
import ufps.edu.co.util.Conexion;

public class SeguirDao  extends Conexion<Seguir> implements GenericDao<Seguir>{

		public SeguirDao() {
			super(Seguir.class);
		}
		
	}