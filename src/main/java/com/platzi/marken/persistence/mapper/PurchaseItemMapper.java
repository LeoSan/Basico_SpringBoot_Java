package com.platzi.marken.persistence.mapper;

import com.platzi.marken.domain.PurchaseItem;
import com.platzi.marken.persistence.entity.ComprasProducto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}) // Usamos el uses ya que estamos indicando que lo vamos a usar a pesar que vamos ingnorar ciertos valores
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);


}
