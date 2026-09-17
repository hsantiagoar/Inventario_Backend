package com.sena.Sistema_inventario.Controller;

// Importamos las clases necesarias de Spring
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

// Importamos List
import java.util.List;

// Importamos nuestro modelo Producto
import com.sena.Sistema_inventario.model.Producto;

// Importamos nuestro servicio
import com.sena.Sistema_inventario.service.ProductoService;

@CrossOrigin(origins = "*") 

// Indica que esta clase es un controlador REST
@RestController

// Ruta base del controlador
@RequestMapping("/productos")
public class ProductoController {

    // Variable que nos permite utilizar ProductoService
    private final ProductoService service;


    // Constructor
    public ProductoController(ProductoService service) {
        this.service = service;
    }


    // =====================================================
    // POST - REGISTRAR PRODUCTO
    // =====================================================

    // Recibe un producto enviado desde el frontend
    @PostMapping
    public Producto registrarProducto(
            @RequestBody Producto producto) {

        // Enviamos el producto al servicio
        return service.registrarProducto(producto);
    }

    // =====================================================
    // GET - LISTAR TODOS LOS PRODUCTOS
    // =====================================================

    // URL:
    // GET http://localhost:8081/productos
    @GetMapping
    public List<Producto> listarProductos() {

        // Solicitamos al servicio todos los productos
        return service.listarProductos();
    }

    // =====================================================
    // GET - BUSCAR PRODUCTO POR Nombre
    // =====================================================

    // URL:
    // GET http://localhost:8081/productos/1
    @GetMapping("/buscar/{nombre}")
    public List<Producto> buscarPorNombre(
            @PathVariable String nombre) {

        return service.buscarPorNombre(nombre);
    }


    // =====================================================
    // DELETE - ELIMINAR PRODUCTO
    // =====================================================

    // URL:
    // DELETE http://localhost:8081/productos/1
    @DeleteMapping("/{id}")
    public void eliminarProducto(
            @PathVariable Long id) {

        // Eliminamos el producto mediante su ID
        service.eliminarProducto(id);
    }


    // =====================================================
    // PUT - ACTUALIZAR PRODUCTO
    // =====================================================

    // URL:
    // PUT http://localhost:8081/productos/1
    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto) {

        // Actualizamos el producto
        return service.actualizarProducto(id, producto);
    }
}