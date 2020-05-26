package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.Categoria.CategoriaDAO;
import com.uca.capas.dao.Libro.LibroDAO;
import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDAO libroDAO;
	
	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> getListCategoria() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDAO.findAll();
	}

	@Override
	public List<Libro> getListLibro() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.getAll();
	}

	@Override
	@Transactional
	public void addOne(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.addOne(libro);
	}

	@Override
	public void addOneCat(Categoria c) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDAO.addOne(c);
	}
	
	
}
