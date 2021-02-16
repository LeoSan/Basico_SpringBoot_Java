package com.platzi.marken.persistence;

import com.platzi.marken.domain.Product;
import com.platzi.marken.domain.repository.ProductRepository;
import com.platzi.marken.persistence.crud.ProductoCrudRepository;
import com.platzi.marken.persistence.entity.Producto;
import com.platzi.marken.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;

    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos =  (List<Producto>)productoCrudRepository.findAll();
        return mapper.toProducts(productos);

    }

    /*Guardo un nuevo producto*/
    @Override
    public void delete(int idProducto){
         productoCrudRepository.deleteById(idProducto);

    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombre(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    /*Nota: Usamos map para convertir los opcional en una lista */
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prods->mapper.toProducts(prods));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProducts(productoCrudRepository.save(producto));

    }

}
