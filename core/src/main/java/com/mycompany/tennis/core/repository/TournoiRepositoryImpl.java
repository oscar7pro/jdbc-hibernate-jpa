package com.mycompany.tennis.core.repository;

import com.mycompany.tennis.core.DataSourceProvider;
import com.mycompany.tennis.core.EntityManagerHolder;
import com.mycompany.tennis.core.HibernateUtil;
import com.mycompany.tennis.core.entity.Tournoi;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TournoiRepositoryImpl {

    public void create(Tournoi tournoi) {
        /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();;
        session.persist(tournoi);*/
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        em.persist(tournoi);
        System.out.println("Tournoi créé");
    }

    public void updateJ(Tournoi tournoi) {

        Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn =dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE TOURNOI  SET NOM=?, CODE=? WHERE ID=?");

            preparedStatement.setString(1, tournoi.getNom());
            preparedStatement.setString(2, tournoi.getCode());
            preparedStatement.setLong(3, tournoi.getId());
            preparedStatement.executeUpdate();

            System.out.println("Tournoi modifié");

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
        Tournoi tournoi = getById(id);
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
       // Tournoi tournoi = em.find(Tournoi.class, id);
    em.remove(tournoi);
    System.out.println("Tournoi supprimé");




    }

    public List<Tournoi> list() {
        List<Tournoi> tournois = new ArrayList<>();
        Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn =dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NOM,CODE FROM TOURNOI ");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Tournoi tournoi = new Tournoi();
                tournoi.setId(resultSet.getLong("ID"));
                tournoi.setNom(resultSet.getString("NOM"));
                tournoi.setCode(resultSet.getString("CODE"));
                tournois.add(tournoi);
            }

            System.out.println("Tounois lus");

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
        return  tournois;

    }

    public Tournoi getById(Long id) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        Tournoi tournoi = em.find(Tournoi.class, id);
/*
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Tournoi tournoi = session.get(Tournoi.class, id);*/
        System.out.println("Tournoi lu");
        return  tournoi;
    }

}
