package com.gestionProductos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


/**
 * Clase que representa la entidad Producto en la base de datos.
 */

@Entity
@Table(name = "producto") // Define el nombre de la tabla en la base de datos.
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 60)
	private String nombre;

	@Column(nullable = false, length = 60)
	private String descripcion;

	@Column(nullable = false)
	private float precio;

	@Column(nullable = false)
	private int cantidad;

	
	//Constructor con parámetros para inicializar un objeto Producto.
	
	public Producto(Long id, String nombre, String descripcion, float precio, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	 // Métodos getter y setter para acceder y modificar los atributos del producto.
	
	
	public Producto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
