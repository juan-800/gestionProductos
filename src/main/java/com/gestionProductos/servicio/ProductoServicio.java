package com.gestionProductos.servicio;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionProductos.entidades.Producto;
import com.gestionProductos.repositorio.ProductoRepositorio;

/**
 * Clase servicio la cual  gestiona la lógica de negocio relacionada con los productos.
 */


@Service
public class ProductoServicio {
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public List<Producto> listaAll(String palabraClave){
		if(palabraClave != null) {
			return productoRepositorio.findAll(palabraClave);// Busca productos filtrando por palabra clave.
		}
		return productoRepositorio.findAll();  // Devuelve todos los productos si no hay filtro.
	}
	
	public void save(Producto producto) {
		productoRepositorio.save(producto); //Guarda un nuevo producto o actualiza uno existente en la base de datos.
	}
	
	public Producto get(Long id) {
		return productoRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		productoRepositorio.deleteById(id);
	}
}
