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

/**
* Controlador para gestionar productos en la aplicación.
*/

@Controller
public class ProductoControlador {
	
	  // Inyección del servicio de productos para manejar la lógica de negocio.
	@Autowired
	private ProductoServicio productoServicio;
	
	// Método para mostrar la página de inicio con la lista de productos.
	@GetMapping("/")
	public String verPaginaDeinicio(Model modelo,@Param("palabraClave") String palabraClave ) {
		List<Producto> listaProductos = productoServicio.listaAll(palabraClave);
		
		modelo.addAttribute("listaProductos", listaProductos); 
		modelo.addAttribute("palabraClave", palabraClave); 
		return "index"; 
	}
	
	//Método para mostrar el formulario de registro de un nuevo producto.
	@GetMapping("/nuevo")
	public String mostrarFormularioDeRegistrarProducto(Model modelo){
		Producto producto = new Producto();
		modelo.addAttribute("producto",producto);
		return "nuevo_producto"; 
	}
	
	
	//Método para guardar un nuevo producto en la base de datos.
	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute("Producto") Producto producto){
	    productoServicio.save(producto);
	    return "redirect:/";
	}
	
	
	//Método para mostrar el formulario de edición de un producto existente.
	@GetMapping("/editar/{id}")
	public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable Long id) {
	    ModelAndView modelo = new ModelAndView("editar_producto");
	    Producto producto = productoServicio.get(id);
	    modelo.addObject("producto", producto); 
	    return modelo;
	}
	
	// Método para eliminar un producto de la base de datos.
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productoServicio.delete(id);
		return "redirect:/";
	}

}
