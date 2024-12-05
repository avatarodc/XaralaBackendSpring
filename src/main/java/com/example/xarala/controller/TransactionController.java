package com.example.xarala.controller;

import com.example.xarala.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface TransactionController {
    /**
     * Crée une nouvelle transaction
     * @param transaction DTO contenant les données de la transaction
     * @return la transaction créée
     */
    ResponseEntity<TransactionDTO> create(TransactionDTO transaction);

    /**
     * Récupère toutes les transactions et le solde
     * @return Map contenant la liste des transactions et le solde
     */
    ResponseEntity<?> findAll();

    /**
     * Récupère une transaction par son ID
     * @param id identifiant de la transaction
     * @return la transaction trouvée
     */
    ResponseEntity<TransactionDTO> findById(String id);

    /**
     * Met à jour une transaction existante
     * @param id identifiant de la transaction à modifier
     * @param transaction nouvelles données de la transaction
     * @return la transaction mise à jour
     */
    ResponseEntity<TransactionDTO> update(String id, TransactionDTO transaction);

    /**
     * Supprime une transaction
     * @param id identifiant de la transaction à supprimer
     * @return réponse vide avec statut 204
     */
    ResponseEntity<Void> delete(String id);

    /**
     * Calcule le solde total
     * @return le solde calculé
     */
    ResponseEntity<Double> calculateBalance();
}