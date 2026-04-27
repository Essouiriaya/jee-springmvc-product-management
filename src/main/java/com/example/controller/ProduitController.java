package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.Produit;
import com.example.services.ProduitMetier;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitMetier services;

    @GetMapping("/index")
    public String pageIndex(Model model) {
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam(required = false) Long idProduit, Model model) {

        List<Produit> liste = new java.util.ArrayList<>();

        if (idProduit != null) {
            Produit p = services.getProduitById(idProduit);

            if (p != null) {
                liste.add(p);
            }
        } else {
            liste = services.getAllProduits();
        }

        model.addAttribute("listeProduit", liste);

        return "produits";
    }

    @PostMapping("/add")
    public String addProduit(Produit p) {
        services.addProduit(p);
        return "redirect:/produits/index";
    }

    @GetMapping("/delete")
    public String deleteProduit(@RequestParam Long id) {
        services.deleteProduit(id);
        return "redirect:/produits/index";
    }
 
    @GetMapping("/edit")
    public String editProduit(@RequestParam Long id, Model model) {

        Produit p = services.getProduitById(id);

        if (p == null) {
            return "redirect:/produits/index";
        }

        model.addAttribute("produitEdit", p);
        model.addAttribute("listeProduit", services.getAllProduits());

        return "produits";
    }

    @PostMapping("/update")
    public String updateProduit(Produit p) {
        services.updateProduit(p);
        return "redirect:/produits/index";
    }
}