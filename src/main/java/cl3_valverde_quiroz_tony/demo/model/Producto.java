package cl3_valverde_quiroz_tony.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "tbl_producto")
@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    private Long stock;

    @Column(columnDefinition = "TINYINT")
    private Byte estado;

    @ManyToOne(fetch = FetchType.EAGER)

    private Categoria categoria;
}
