package cl3_valverde_quiroz_tony.demo.service;

import cl3_valverde_quiroz_tony.demo.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto guardarProducto(Producto empleado);

    Producto actualizarProducto(Producto empleado);

    void eliminarProducto(Long id);

    Producto obtenerProducto(Long id);

    List<Producto> listarTodosLosProductos();
}
