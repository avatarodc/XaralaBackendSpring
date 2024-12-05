package com.example.xarala.service;

import org.modelmapper.ModelMapper;
import com.example.xarala.dto.TransactionDTO;
import com.example.xarala.exception.ResourceNotFoundException;
import com.example.xarala.data.model.Transaction;
import com.example.xarala.data.model.TransactionType;
import com.example.xarala.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;
    private final ModelMapper mapper;

    public TransactionServiceImpl(TransactionRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Crée une nouvelle transaction.
     * @param dto Les données de la transaction à créer.
     * @return Le DTO de la transaction créée.
     */
    @Override
    public TransactionDTO create(TransactionDTO dto) {
        Transaction transaction = mapper.map(dto, Transaction.class);
        transaction = repository.save(transaction);
        return mapper.map(transaction, TransactionDTO.class);
    }

    /**
     * Récupère toutes les transactions.
     * @return La liste des DTO de transactions.
     */
    @Override
    public List<TransactionDTO> findAll() {
        return repository.findAll().stream()
                .map(t -> mapper.map(t, TransactionDTO.class))
                .toList();
    }

    /**
     * Récupère une transaction par son ID.
     * @param id L'ID de la transaction à récupérer.
     * @return Le DTO de la transaction.
     * @throws ResourceNotFoundException Si la transaction n'est pas trouvée.
     */
    @Override
    public TransactionDTO findById(String id) {
        Transaction transaction = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
        return mapper.map(transaction, TransactionDTO.class);
    }

    /**
     * Met à jour une transaction existante.
     * @param id L'ID de la transaction à mettre à jour.
     * @param dto Les données de transaction mises à jour.
     * @return Le DTO de la transaction mise à jour.
     * @throws ResourceNotFoundException Si la transaction n'est pas trouvée.
     */
    @Override
    public TransactionDTO update(String id, TransactionDTO dto) {
        Transaction transaction = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        mapper.map(dto, transaction);
        transaction = repository.save(transaction);
        return mapper.map(transaction, TransactionDTO.class);
    }

    /**
     * Supprime une transaction par son ID.
     * @param id L'ID de la transaction à supprimer.
     * @throws ResourceNotFoundException Si la transaction n'est pas trouvée.
     */
    @Override
    public void delete(String id) {
        repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
        repository.deleteById(UUID.fromString(id));
    }

    /**
     * Calcule le solde actuel.
     * @return Le solde actuel.
     */
    @Override
    public Double calculateBalance() {
        return repository.findAll().stream()
                .mapToDouble(t -> t.getType() == TransactionType.REVENU ? t.getAmount() : -t.getAmount())
                .sum();
    }
}