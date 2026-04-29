package com.example.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.example.model.User;
import com.example.util.HibernateUtil;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {

    @Override
    public User findByUsernameAndPassword(String username, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "FROM User WHERE username = :u AND password = :p";

            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("u", username);
            query.setParameter("p", password);

            return query.uniqueResult();

        } finally {
            session.close();
        }
    }
}