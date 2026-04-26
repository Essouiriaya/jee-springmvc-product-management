package com.example.services;

import java.util.List; 
import com.example.model.Produit;

public interface ProduitMetier{
	public void addProduit(Produit p);
	public void deleteProduit(Long id);
	public List<Produit> getAllProduits();
	public Produit getProduitById(Long id);
	public void updateProduit(Produit p);
}