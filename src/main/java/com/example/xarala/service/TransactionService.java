package com.example.xarala.service;

import com.example.xarala.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    /**
     * Crée une nouvelle transaction.
     * @param dto Les données de la transaction à créer.
     * @return Le DTO de la transaction créée.
     */
    TransactionDTO create(TransactionDTO dto);

    /**
     * Récupère toutes les transactions.
     * @return La liste des DTO de transactions.
     */
    List<TransactionDTO> findAll();

    /**
     * Récupère une transaction par son ID.
     * @param id L'ID de la transaction à récupérer.
     * @return Le DTO de la transaction.
     */
    TransactionDTO findById(String id);

    /**
     * Met à jour une transaction existante.
     * @param id L'ID de la transaction à mettre à jour.
     * @param dto Les données de transaction mises à jour.
     * @return Le DTO de la transaction mise à jour.
     */
    TransactionDTO update(String id, TransactionDTO dto);

    /**
     * Supprime une transaction par son ID.
     * @param id L'ID de la transaction à supprimer.
     */
    void delete(String id);

    /**
     * Calcule le solde actuel.
     * @return Le solde actuel.
     */
    Double calculateBalance();
}