package com.platzi.marken.persistence.mapper;

import com.platzi.marken.domain.Category;
import com.platzi.marken.domain.Product;
import com.platzi.marken.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            /*                  Fuente(sourse) es la Id de la tabla producto  */
            /*                  Etiqueta (Target) la Id de la clase Domain categoria  */
            @Mapping(source = "idProducto", target="productId" ),
            @Mapping(source = "nombre", target="name" ),
            @Mapping(source = "idCategoria", target="categoryId" ),
            @Mapping(source = "precioVenta", target="price" ),
            @Mapping(source = "cantidadStock", target="stock" ),
            @Mapping(source = "estado", target="active" ),
            @Mapping(source = "categoria", target="category" ),

    })
    Product toProducts(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);


}
