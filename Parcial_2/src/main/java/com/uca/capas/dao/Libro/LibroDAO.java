package com.uca.capas.dao.Libro;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Libro;

public interface LibroDAO {
	public List<Libro> getAll() throws DataAccessException;
	
	public void addOne(Libro libro) throws DataAccessException;
}
