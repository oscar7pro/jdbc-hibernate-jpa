package com.mycompany.tennis.core.service;

import com.mycompany.tennis.core.EntityManagerHolder;
import com.mycompany.tennis.core.HibernateUtil;
import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.repository.JoueurRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JoueurService {
    private JoueurRepositoryImpl joueurRepository;

    public JoueurService() {
        this.joueurRepository = new JoueurRepositoryImpl();
    }

    public List<JoueurDto> getListJoueurs(char sexe) {
        EntityManager em =null;
        EntityTransaction transaction = null;
        /*Session session =  null;
        Transaction transaction = null;*/
        List<JoueurDto> dtos =  new ArrayList<>();
        try {

          //  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tennis_unit");

                em = EntityManagerHolder.getCurrentEntityManager();
                transaction = em.getTransaction();
                transaction.begin();

            /*session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();*/
            List<Joueur> joueurs =  joueurRepository.list(sexe);

            for (Joueur joueur : joueurs) {
                final JoueurDto dto = new JoueurDto();
                dto.setId(joueur.getId());
                dto.setNom(joueur.getNom());
                dto.setPrenom(joueur.getPrenom());
                dto.setSexe(joueur.getSexe());
                dtos.add(dto);
            }
            transaction.commit();

        }catch (Exception exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if(em != null) {
                em.close();
            }

        }
        return  dtos;
    }

    public void createJoueur(Joueur joueur) {
        Session session =  null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
             joueurRepository.create(joueur);
            transaction.commit();

        }catch (Exception exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }

        }
    }

    public void renomme(Long id, String nouveauNom) {
        Joueur joueur = getJoueur(id);
        Session session =  null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            //  Joueur joueur = joueurRepository.getById(id);
            joueur.setNom(nouveauNom);
            session.merge(joueur);
            transaction.commit();

        }catch (Exception exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }

        }
    }

    public void changeSexe(Long id, char nouveauSexe) {
        Joueur joueur = getJoueur(id);
        Session session =  null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            //  Joueur joueur = joueurRepository.getById(id);
            joueur.setSexe(nouveauSexe);
            session.merge(joueur);
            transaction.commit();

        }catch (Exception exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }

        }
    }


    public Joueur getJoueur(Long id ) {
        Session session =  null;
        Transaction transaction = null;
        Joueur joueur = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

             joueur = joueurRepository.getById(id);
            transaction.commit();

        }catch (Exception exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }

        }
        return  joueur;
    }

    public void deleteJoueur(Long id ) {
        Session session =  null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            joueurRepository.delete(id);
            transaction.commit();

        }catch (Exception exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }

        }
    }
}
