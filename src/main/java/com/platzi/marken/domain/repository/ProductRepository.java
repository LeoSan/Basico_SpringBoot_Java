package com.platzi.marken.domain.repository;

import com.platzi.marken.domain.Product;

import java.util.List;
import java.util.Optional;


/*Mi duda es si esta clase sus metodos son los que se definieron en el ProductoRepository de la capa Persistence*/
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProduct(int quantity);
    Optional <Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);

}
