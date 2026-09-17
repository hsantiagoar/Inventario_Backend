package com.sena.Sistema_inventario.service;

import java.util.List;
import com.sena.Sistema_inventario.model.Producto;
import com.sena.Sistema_inventario.repository.ProductoRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    // Repositorio encargado de comunicarse con la base de datos
    private final ProductoRepository repository;

    // Constructor
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // =====================================================
    // LISTAR PRODUCTOS
    // =====================================================

    public List<Producto> listarProductos() {

        // Obtiene todos los productos de la base de datos
        return repository.findAll();
    }

    // =====================================================
    // REGISTRAR PRODUCTO
    // =====================================================

    public Producto registrarProducto(Producto producto) {

        // Guarda el producto en la base de datos
        return repository.save(producto);
    }

    // =====================================================
    // BUSCAR PRODUCTO POR Nombre
    // =====================================================

    public List<Producto> buscarPorNombre(String nombre) {

        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    // =====================================================
    // ELIMINAR PRODUCTO
    // =====================================================

    public void eliminarProducto(Long id) {

        // Elimina el producto por su ID
        repository.deleteById(id);
    }

    // =====================================================
    // ACTUALIZAR PRODUCTO
    // =====================================================

    public Producto actualizarProducto(
            Long id,
            Producto productoActualizado) {

        // Busca el producto que queremos actualizar
        return repository.findById(id).map(producto -> {

            // Actualizamos los datos
            producto.setCodigo(productoActualizado.getCodigo());
            producto.setNombre(productoActualizado.getNombre());
            producto.setCategoria(productoActualizado.getCategoria());
            producto.setProveedor(productoActualizado.getProveedor());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCantidad(productoActualizado.getCantidad());

            // Guardamos los cambios
            return repository.save(producto);

        }).orElse(null);
    }
}