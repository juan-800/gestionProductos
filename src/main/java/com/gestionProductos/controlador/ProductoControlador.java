package com.gestionProductos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestionProductos.entidades.Producto;
import com.gestionProductos.servicio.ProductoServicio;

@Controller
public class ProductoControlador {
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping("/")
	public String verPaginaDeinicio(Model modelo,@Param("palabraClave") String palabraClave ) {
		List<Producto> listaProductos = productoServicio.listaAll(palabraClave);
		
		modelo.addAttribute("listaProductos", listaProductos); 
		modelo.addAttribute("palabraClave", palabraClave); 
		return "index"; 
	}
	@GetMapping("/nuevo")
	public String mostrarFormularioDeRegistrarProducto(Model modelo){
		Producto producto = new Producto();
		modelo.addAttribute("producto",producto);
		return "nuevo_producto"; 
	}
	
	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute("Producto") Producto producto){
	    productoServicio.save(producto);
	    return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable Long id) {
	    ModelAndView modelo = new ModelAndView("editar_producto");
	    Producto producto = productoServicio.get(id);
	    modelo.addObject("producto", producto); 
	    return modelo;
	}
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productoServicio.delete(id);
		return "redirect:/";
	}

}
