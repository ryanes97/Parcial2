package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
	private Integer c_libro;
	
	@Column(name="s_titulo")
	@NotEmpty(message="No puede estar vacio")
	private String s_titulo;
	
	@Column(name="s_autor")
	@NotEmpty(message="No puede estar vacio")
	private String s_autor;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Categoria c_categoria;
	
	@Column(name="f_ingreso")
	private Date f_ingreso;
	
	@Column(name="b_estado")
	private boolean estado;
	
	@Column(name="s_isbn")
	@NotEmpty(message="No puede estar vacio")
	private String s_isbn;
	
	
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getC_libro() {
		return c_libro;
	}
	
	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}
	
	public String getS_titulo() {
		return s_titulo;
	}
	
	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}
	
	public String getS_autor() {
		return s_autor;
	}
	
	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}
	
	public Categoria getC_categoria() {
		return c_categoria;
	}
	
	public void setC_categoria(Categoria c_categoria) {
		this.c_categoria = c_categoria;
	}
	
	public String getF_ingresoDelegate() {
		if(this.f_ingreso == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String shortdate = sdf.format(this.f_ingreso.getTime());
			return shortdate;
		}
	}
	
	public Date getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String delegateEstado() {
		return estado ? "Activo":"Inactivo";
	}
	
	public String getS_isbn() {
		return s_isbn;
	}
	
	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}
	
	
}
