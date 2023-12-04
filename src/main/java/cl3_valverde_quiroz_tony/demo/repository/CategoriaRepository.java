package cl3_valverde_quiroz_tony.demo.repository;

import cl3_valverde_quiroz_tony.demo.model.Categoria;
import cl3_valverde_quiroz_tony.demo.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    List<Categoria> findById(BigDecimal id);
    List<Categoria> findByDescripcion(String descripcion);

    List<Categoria> findByDescripcionContaining(String cadena);

    List<Categoria> findByDescripcionStartingWith(String cadena);
}

