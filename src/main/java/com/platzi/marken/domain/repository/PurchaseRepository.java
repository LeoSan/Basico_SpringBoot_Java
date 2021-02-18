package com.platzi.marken.domain.repository;

import com.platzi.marken.domain.Purchase;
import com.platzi.marken.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<PurchaseItem>> getByClient(String clienteId);

    Purchase save(Purchase purchase);

}
