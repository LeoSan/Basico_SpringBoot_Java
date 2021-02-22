package com.platzi.marken.persistence;

import com.platzi.marken.domain.Purchase;
import com.platzi.marken.domain.PurchaseItem;
import com.platzi.marken.domain.repository.PurchaseRepository;
import com.platzi.marken.persistence.crud.CompraCrudRepository;
import com.platzi.marken.persistence.entity.Compra;
import com.platzi.marken.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases( (List<Compra>)compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clienteId) {

        //compras -> Esto se llama funcion landa
        return compraCrudRepository.findByIdCliente(clienteId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        //Validar la informaci{on en cascada tenemos que estar seguro que compra conoce los productos esto viene de la realacion entre las tablas
        compra.getProductos().forEach(producto -> producto.setCompra(compra) );

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
