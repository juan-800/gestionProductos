package com.gestionProductos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionProductos.entidades.Producto;
import com.gestionProductos.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public List<Producto> listaAll(String palabraClave){
		if(palabraClave != null) {
			return productoRepositorio.findAll(palabraClave);
		}
		return productoRepositorio.findAll();
	}
	
	public void save(Producto producto) {
		productoRepositorio.save(producto);
	}
	
	public Producto get(Long id) {
		return productoRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		productoRepositorio.deleteById(id);
	}
}
