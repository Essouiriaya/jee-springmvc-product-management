package com.example.dao;

import java.util.List;
import com.example.model.Produit;
import com.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ProduitImpl implements ProduitDAO {

    public void init() {
        System.out.println("Spring IOC est bien fonctionnée !");
    }

    @Override
    public void addProduit(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(p);

        tx.commit();
        session.close();
    }

    @Override
    public Produit getProduitById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Produit p = session.get(Produit.class, id);

        session.close();
        return p;
    }

    @Override
    public List<Produit> getAllProduits() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Produit> list = session
                .createQuery("from Produit", Produit.class)
                .list();

        session.close();
        return list;
    }

    @Override
    public void deleteProduit(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Produit p = session.get(Produit.class, id);
        if (p != null) {
            session.delete(p);
        }

        tx.commit();
        session.close();
    }

    @Override
    public void updateProduit(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(p);

        tx.commit();
        session.close();
    }
}