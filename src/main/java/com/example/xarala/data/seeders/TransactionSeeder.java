package com.example.xarala.data.seeders;


import com.example.xarala.data.model.Transaction;
import com.example.xarala.data.model.TransactionType;
import com.example.xarala.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionSeeder implements CommandLineRunner {
    private final TransactionRepository transactionRepository;

    public TransactionSeeder(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) {
        if (transactionRepository.count() == 0) {
            List<Transaction> transactions = new ArrayList<>();

            transactions.add(createTransaction("Salaire Janvier", TransactionType.REVENU, 2500.0));
            transactions.add(createTransaction("Loyer Janvier", TransactionType.DEPENSE, 800.0));
            transactions.add(createTransaction("Prime", TransactionType.REVENU, 500.0));
            transactions.add(createTransaction("Courses Alimentaires", TransactionType.DEPENSE, 300.0));
            transactions.add(createTransaction("Freelance Project", TransactionType.REVENU, 1500.0));
            transactions.add(createTransaction("Facture Électricité", TransactionType.DEPENSE, 150.0));
            transactions.add(createTransaction("Consultation", TransactionType.REVENU, 800.0));
            transactions.add(createTransaction("Transport", TransactionType.DEPENSE, 100.0));
            transactions.add(createTransaction("Vente en ligne", TransactionType.REVENU, 450.0));
            transactions.add(createTransaction("Assurance", TransactionType.DEPENSE, 200.0));

            transactionRepository.saveAll(transactions);
        }
    }

    private Transaction createTransaction(String description, TransactionType type, Double amount) {
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setDate(LocalDateTime.now());
        return transaction;
    }
}