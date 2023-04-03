package com.example.chapter12db.controllers;

import com.example.chapter12db.models.Purchase;
import org.springframework.web.bind.annotation.*;
import com.example.chapter12db.repositories.PurchaseRepository;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(
            @RequestBody Purchase purchase
    ) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAllPurchases();
    }


}
