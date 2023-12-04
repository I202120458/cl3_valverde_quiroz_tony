package cl3_valverde_quiroz_tony.demo.service.impl;

import cl3_valverde_quiroz_tony.demo.model.Producto;
import cl3_valverde_quiroz_tony.demo.repository.ProductoRepository;
import cl3_valverde_quiroz_tony.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        validarEmpleado(producto);
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        validarEmpleado(producto);
        if (!productoRepository.existsById(producto.getId())) {
            throw new IllegalArgumentException("El empleado con el ID especificado no existe.");
        }
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new IllegalArgumentException("El empleado con el ID especificado no existe.");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public Producto obtenerProducto(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty()) {
            throw new IllegalArgumentException("El empleado con el ID especificado no existe.");
        }
        return producto.get();
    }

    @Override
    public List<Producto> listarTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    private void validarEmpleado(Producto producto) {
        if (producto.getDescripcion() == null || producto.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del Producto no puede estar vacío.");
        }
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }

        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        if (producto.getEstado() == null || producto.getEstado() < 0) {
            throw new IllegalArgumentException("El estado no puede ser negativo.");
        }
        if (producto.getCategoria() == null || producto.getCategoria().getId() == null) {
            throw new IllegalArgumentException("La categoria  asignada no es válida.");
        }
    }
}

