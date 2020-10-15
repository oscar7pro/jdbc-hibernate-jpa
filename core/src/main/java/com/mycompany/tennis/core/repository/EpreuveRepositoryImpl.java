package com.mycompany.tennis.core.repository;

import com.mycompany.tennis.core.EntityManagerHolder;
import com.mycompany.tennis.core.entity.Epreuve;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EpreuveRepositoryImpl {

    public List<Epreuve> list(String code) {
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Epreuve> query = em.createQuery("select e from Epreuve e join fetch e.tournoi where e.tournoi.code = ?0", Epreuve.class);
        //Query<Epreuve> query = session.createQuery("select e from Epreuve e join fetch e.tournoi where e.tournoi.code = ?0", Epreuve.class);
        query.setParameter(0,code);
        List<Epreuve> epreuves = query.getResultList();
        System.out.println("epreuves lu");
        return  epreuves;

    }

    public Epreuve getById(Long id) {
        EntityManager em = EntityManagerHolder.getCurrentEntityManager();
       // Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Epreuve epreuve = em.find(Epreuve.class, id);
        System.out.println("Epreuve lu");
        return  epreuve;
    }

}
