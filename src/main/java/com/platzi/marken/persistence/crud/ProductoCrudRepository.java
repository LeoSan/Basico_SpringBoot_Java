package com.platzi.marken.persistence.crud;

import com.platzi.marken.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Forma Nativa
    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ? ", nativeQuery = true)

    //Esto es un Query Metodo
    List<Producto> findByIdCategoriaOrderByNombre(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, Boolean estado);

}
