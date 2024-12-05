package com.example.xarala.controller;

import com.example.xarala.dto.TransactionDTO;
import com.example.xarala.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionControllerImpl {
    private final TransactionService service;

    public TransactionControllerImpl(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> create(@RequestBody TransactionDTO transaction) {
        return ResponseEntity.ok(service.create(transaction));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(Map.of(
                "transactions", service.findAll(),
                "balance", service.calculateBalance()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> update(@PathVariable String id, @RequestBody TransactionDTO transaction) {
        return ResponseEntity.ok(service.update(id, transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> calculateBalance() {
        Double balance = service.calculateBalance();
        return ResponseEntity.ok(balance);
    }

}