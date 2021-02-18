package com.platzi.marken.persistence.mapper;

import com.platzi.marken.domain.PurchaseItem;
import com.platzi.marken.persistence.entity.ComprasProducto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}) // Usamos el uses ya que estamos indicando que lo vamos a usar a pesar que vamos ingnorar ciertos valores
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target="productId"),
            @Mapping(source = "cantidad", target="quantity"),
            @Mapping(source = "total", target="total"),//No es necesario ya que es igual
            @Mapping(source = "estado", target="active"),

    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritConfiguration //Permite usar de manera inversa el mappin que se declaraon arriba
    @Mappings({
            @Mapping(target="compra", ignore = true),
            @Mapping(target="producto", ignore = true),
            @Mapping(target="id.idCompra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item );


}
