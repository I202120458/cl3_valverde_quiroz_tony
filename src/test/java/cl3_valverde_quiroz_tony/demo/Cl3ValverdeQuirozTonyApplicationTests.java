package cl3_valverde_quiroz_tony.demo;

import cl3_valverde_quiroz_tony.demo.model.Categoria;
import cl3_valverde_quiroz_tony.demo.model.Producto;
import cl3_valverde_quiroz_tony.demo.repository.CategoriaRepository;
import cl3_valverde_quiroz_tony.demo.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class Cl3ValverdeQuirozTonyApplicationTests {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProductoRepository productoRepository;

	@Test
	void insertarCategoria() {
		Categoria categoria = new Categoria();
		categoria.setDescripcion("Abarrotes");
		categoriaRepository.save(categoria);
	}

	@Test
	void insertarProducto() {
		// Primero, asegúrate de tener una categoría válida en tu base de datos
		Categoria categoria = new Categoria();
		// Configura los atributos de la categoría según tus necesidades
		categoria.setDescripcion("Alimentos");
		// Guarda la categoría en la base de datos
		categoriaRepository.save(categoria);

		// Ahora, crea un nuevo Producto y asócialo a la categoría que acabas de crear
		Producto producto = new Producto();
		producto.setDescripcion("Arroz");
		producto.setPrecio(new BigDecimal("1.5"));
		producto.setStock(100L);
		producto.setEstado((byte) 1);

		// Asocia el producto con la categoría
		producto.setCategoria(categoria);

		// Guarda el producto en la base de datos
		productoRepository.save(producto);
	}

}
