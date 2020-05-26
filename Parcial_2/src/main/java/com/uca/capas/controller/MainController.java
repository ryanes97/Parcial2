package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	
	@Autowired
	private LibroService libroService;
	
	
	@RequestMapping("/inicio")
	public ModelAndView initmain() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		Categoria categoria = new Categoria();
		List<Categoria> listCategoria = null;
		
		try {
			listCategoria = libroService.getListCategoria();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		mav.addObject("libro", libro);
		mav.addObject("categorias", listCategoria);
		mav.addObject("categoria", categoria);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView guardarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			
			List<Categoria> listCategoria = null;
			
			try {
				listCategoria = libroService.getListCategoria();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("categorias",categoria);
			mav.setViewName("categoria");
			
		}else {
			
			libroService.addOneCat(categoria);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("/libro")
	public ModelAndView ingresarLibro() 
	{
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> listaDeCategoria = null;
		
		try {
			listaDeCategoria = libroService.getListCategoria();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		mav.addObject("libro", libro);
		mav.addObject("categorias", listaDeCategoria);
		mav.setViewName("libro");
		
		return mav;
	}
	
	@RequestMapping("/formlibro")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
			if(result.hasErrors()) {
				
				List<Categoria> listCategoria = null;
				
				try {
					listCategoria = libroService.getListCategoria();
				}
				catch(Exception e) {
					e.printStackTrace();
				
					
				mav.addObject("categorias", listCategoria);
				mav.setViewName("libro");
				
				}
			}else {
				
				libroService.addOne(libro);;
				mav.setViewName("index");
			}
			
			return mav;
		}
	
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		
		try {
			libros=libroService.getListLibro();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libros", libros);
		mav.setViewName("listado");
		
		return mav;
	}
}
