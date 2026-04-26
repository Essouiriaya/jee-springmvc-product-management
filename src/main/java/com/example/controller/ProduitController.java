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

	
	
}