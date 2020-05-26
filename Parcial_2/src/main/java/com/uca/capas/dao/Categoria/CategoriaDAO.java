package com.uca.capas.dao.Categoria;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Categoria;

public interface CategoriaDAO {
	public List<Categoria> findAll() throws DataAccessException;
	
	public void addOne(Categoria c) throws DataAccessException;
}
