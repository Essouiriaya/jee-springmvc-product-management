package com.example.controller;

import java.util.ArrayList; 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
 
import com.example.model.Produit; 
import com.example.services.ProduitMetier;

/** 
 * Controller Spring MVC charge de gerer les requêtes HTTP 
 * liées aux produits (affichage, ajout, modification, suppression). 
*/ 

@Controller
public class ProduitController {
	
	@Autowired 
    ProduitMetier services; 
	
	@RequestMapping(value="/index")
	public  String pageIndex (Model model){
		model.addAttribute("listeProduit", services.getAllProduits());
		return "produits";
	}
	
	@RequestMapping(value="/searchProduct")
	public String searchProduct(Model model,@RequestParam(value ="idProduit") Long id){
		List<Produit> liste = new ArrayList<Produit> ();
		
		liste.add(services.getProduitById(id)); 
		
		 model.addAttribute("listeProduit", liste); 
	     model.addAttribute("idProduit", id);
	     
	     return "produits";
	}
	
	@RequestMapping(value="/addProduct")
	public String addProduit(Model model, Produit p) {
		services.addProduit(p);
		
		 model.addAttribute("listeProduit", services.getAllProduits());
		 
		 return "produits";
	}
	
	@RequestMapping(value="/deleteProduit") 
    public String supprimerProduit(Model model,@RequestParam Long id){ 
         
        // Appel du service pour supprimer le produit 
        services.deleteProduit(id); 
         
        // Mise à jour de la liste 
        model.addAttribute("listeProduit", services.getAllProduits()); 
         
        return "produits"; 
    }
	
	@RequestMapping(value="/editProduit", method=RequestMethod.GET) 
    public String editProduit(Model model, @RequestParam Long id) { 
         
        // Récupérer le produit à éditer 
        Produit p = services.getProduitById(id); 
         
        // Envoyer le produit à la vue pour pré-remplir le formulaire 
        model.addAttribute("produitEdit", p); 
         
        // Afficher aussi la liste complète 
        model.addAttribute("listeProduit", services.getAllProduits()); 
         
        return "produits"; 
    }
	
	 @RequestMapping(value="/updateProduit", method=RequestMethod.POST) 
	 public String updateProduitPost(Model model, 
						             @RequestParam Long idProduit, 
						             @RequestParam String nom, 
						             @RequestParam String description, 
						             @RequestParam Double prix) { 
		
		// Création d'un objet produit avec les nouvelles valeurs 
		Produit p = new Produit(); 
		p.setIdProduit(idProduit); 
		p.setNom(nom); 
		p.setDescription(description); 
		p.setPrix(prix); 
		
		// Appel de la couche service pour effectuer la mise à jour 
		services.updateProduit(p); 
		
		// Rafraîchir la liste des produits pour l'affichage 
		model.addAttribute("listeProduit", services.getAllProduits()); 
		
		return "produits"; 
	}
}
























