package com.sena.Sistema_inventario.repository;
import com.sena.Sistema_inventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}