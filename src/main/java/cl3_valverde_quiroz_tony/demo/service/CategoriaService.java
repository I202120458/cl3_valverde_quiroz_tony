package cl3_valverde_quiroz_tony.demo.service;

import cl3_valverde_quiroz_tony.demo.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria guardarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);

    Categoria obtenerCategoria(Long id);

    List<Categoria> listarTodasLasCategorias();
}

