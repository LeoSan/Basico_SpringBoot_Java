package com.platzi.marken.persistence.mapper;

import com.platzi.marken.domain.Purchase;
import com.platzi.marken.domain.PurchaseItem;
import com.platzi.marken.persistence.entity.Compra;
import com.platzi.marken.persistence.entity.ComprasProducto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target ="purchaseId"),
            @Mapping(source = "idCliente", target ="clienteId"),
            @Mapping(source = "fecha", target ="date"),
            @Mapping(source = "medioPago", target ="paymentMethod"),
            @Mapping(source = "comentario", target ="comment"),
            @Mapping(source = "estado", target ="state"),
            @Mapping(source = "productos", target ="item"),
    })
    Purchase toPurchase(Compra compra);

    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping( target = "cliente", ignore = true) //Siempre hay que ignorar si no se va usar.
    Compra toCompra(Purchase purchase);


}
