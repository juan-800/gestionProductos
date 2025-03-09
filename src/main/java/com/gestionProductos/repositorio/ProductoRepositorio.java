package com.gestionProductos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestionProductos.entidades.Producto;
@Repository

/**
 Interfaz que actúa como repositorio para la entidad Producto.
  Extiende JpaRepository para proporcionar métodos CRUD y poder hacer consultas personalizadas.
 */

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE " +
           "LOWER(CONCAT(p.descripcion, ' ', p.nombre, ' ')) " +
           "LIKE LOWER(CONCAT('%', :palabraClave, '%'))")
    List<Producto> findAll(@Param("palabraClave") String palabraClave);
}
