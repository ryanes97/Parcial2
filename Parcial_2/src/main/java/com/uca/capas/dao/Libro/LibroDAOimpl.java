package com.uca.capas.dao.Libro;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOimpl implements LibroDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> getAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> resulset = query.getResultList();
		
		return resulset;
		
	}

	@Override
	@Transactional
	public void addOne(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		
		if(libro.getC_libro()==null) {
			
			long millis=System.currentTimeMillis();  
			libro.setF_ingreso(new Date(millis));
			
			entityManager.persist(libro);
		}else {
			
			entityManager.merge(libro);
			
		}
		
	}

}
