package ufps.edu.co.dao;

import ufps.edu.co.entity.SeguirPK;
import ufps.edu.co.util.Conexion;

public class SeguirPKDao  extends Conexion<SeguirPK> implements GenericDao<SeguirPK>{

			public SeguirPKDao() {
				super(SeguirPK.class);
			}
			
		}