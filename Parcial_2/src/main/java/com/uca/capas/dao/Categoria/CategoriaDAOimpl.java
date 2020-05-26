package com.uca.capas.dao.Categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Categoria;

@Repository
public class CategoriaDAOimpl implements CategoriaDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> resulset = query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void addOne(Categoria c) throws DataAccessException {
		// TODO Auto-generated method stub
		if(c.getC_categoria()==null) {
			entityManager.persist(c);
		}else {
			entityManager.merge(c);
		}
		
	}
}
