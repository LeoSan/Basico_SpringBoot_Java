package com.platzi.marken.persistence.mapper;

import com.platzi.marken.domain.Category;
import com.platzi.marken.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({

            /*                  Fuente(sourse) es la Id de la tabla categoria  */
            /*                  Etiqueta (Target) la Id de la clase Domain categoria  */
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado"     , target = "active"),

    })
    Category toCategory(Categoria categoria);

    /**Configuracion externa /
     *Mapeo inverso es una depencia directa del metodo toCategory la ventaja de usar esta anotación
     * es un mapeo inverso
     */

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);


}
