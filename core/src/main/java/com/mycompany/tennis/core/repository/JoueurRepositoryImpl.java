package com.mycompany.tennis.core.repository;

import com.mycompany.tennis.core.DataSourceProvider;
import com.mycompany.tennis.core.EntityManagerHolder;
import com.mycompany.tennis.core.HibernateUtil;
import com.mycompany.tennis.core.entity.Joueur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoueurRepositoryImpl {
/*
    public  void renomme(Long id, String nouveauNom){
        Joueur joueur = null;
        Session session =  null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            joueur = session.get(Joueur.class, id);
            joueur.setNom(nouveauNom);
            transaction.commit();

            System.out.println("Nom de Joueur/se modifié(e)");

        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session !=null) {
                session.close();
            }
        }

    }
*/
    public void create(Joueur joueur) {

        Session session = HibernateUtil.getSessionFactory().openSession();
           session.persist(joueur);
            System.out.println("Joueur créé");
    }

    public void updateJ(Joueur joueur) {

        Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn =dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE JOUEUR  SET NOM=?, PRENOM=?, SEXE=? WHERE ID=?");

            preparedStatement.setString(1, joueur.getNom());
            preparedStatement.setString(2, joueur.getPrenom());
            preparedStatement.setString(3, joueur.getSexe().toString());
            preparedStatement.setLong(4, joueur.getId());
            preparedStatement.executeUpdate();

            System.out.println("Joueur modifié");

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn!=null) {
                    conn.rollback();

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void delete(Long id) {
        Joueur joueur = getById(id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(joueur);
            System.out.println("Joueur supprimé");


    }

    /* retourne la liste des joueursliste
    public List<Joueur> list() {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Joueur> query = session.createQuery("select j from Joueur j", Joueur.class);
        List<Joueur> joueurs = query.getResultList();
        System.out.println("Joueur lu");
        return  joueurs;
    }*/

   /*
   retourne la lise avec pareametre sexe
    */
    public List<Joueur> list(char sexe) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        TypedQuery<Joueur> query = em.createNamedQuery("given_sexe", Joueur.class);
        query.setParameter(0,sexe);
        List<Joueur> joueurs = query.getResultList();
        System.out.println("Joueur lu");
        return  joueurs;

    }


    public Joueur getById(Long id) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Joueur joueur = null;
        Session session =  null;
           //  session = HibernateUtil.getSessionFactory().getCurrentSession();
             //joueur = session.get(Joueur.class, id);
             joueur = em.find(Joueur.class, id);
            System.out.println("Joueur lu");
        return  joueur;
    }

}
