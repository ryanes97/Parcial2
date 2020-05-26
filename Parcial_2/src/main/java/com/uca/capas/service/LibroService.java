package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;

public interface LibroService {
	
	public List<Categoria> getListCategoria() throws DataAccessException;
	
	public List<Libro> getListLibro() throws DataAccessException;
	
	public void addOne(Libro libro) throws DataAccessException;
	
	public void addOneCat(Categoria c) throws DataAccessException;
}
