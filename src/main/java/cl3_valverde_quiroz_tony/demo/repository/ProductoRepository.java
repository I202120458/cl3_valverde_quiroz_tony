package cl3_valverde_quiroz_tony.demo.repository;

import cl3_valverde_quiroz_tony.demo.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

    List<Producto> findByDescripcion(String descripcion);

    List<Producto> findByDescripcionContaining(String cadena);

    List<Producto> findByDescripcionStartingWith(String cadena);

    List<Producto> findById(BigDecimal id);


}
