package com.example.xarala.controller;

import com.example.xarala.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;

public interface TransactionController {
    /**
     * Crée une nouvelle transaction.
     * @param transaction Les données de transaction.
     * @return La transaction créée.
     */
    ResponseEntity<TransactionDTO> create(TransactionDTO transaction);

    /**
     * Récupère toutes les transactions et le solde.
     * @return Carte avec transactions et solde.
     */
    ResponseEntity<?> findAll();

    /**
     * Récupère une transaction par son ID.
     * @param id ID de la transaction.
     * @return La transaction.
     */
    ResponseEntity<TransactionDTO> findById(String id);

    /**
     * Met à jour une transaction.
     * @param id ID de la transaction.
     * @param transaction Données mises à jour.
     * @return La transaction mise à jour.
     */
    ResponseEntity<TransactionDTO> update(String id, TransactionDTO transaction);

    /**
     * Supprime une transaction.
     * @param id ID de la transaction.
     * @return Réponse sans contenu.
     */
    ResponseEntity<Void> delete(String id);

    /**
     * Calcule le solde actuel.
     * @return Le solde actuel.
     */
    ResponseEntity<Double> calculateBalance();
}