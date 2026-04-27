package com.example.services;

import java.util.List;
import com.example.model.Produit;
import com.example.dao.ProduitDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitImplMetier implements ProduitMetier {

    @Autowired
    private ProduitDAO dao;

    @Override
    public void addProduit(Produit p) {
        dao.addProduit(p);
    }

    @Override
    public void deleteProduit(Long id) {
        dao.deleteProduit(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return dao.getAllProduits();
    }

    @Override
    public Produit getProduitById(Long id) {
        return dao.getProduitById(id);
    }

    @Override
    public void updateProduit(Produit p) {
        dao.updateProduit(p);
    }
}