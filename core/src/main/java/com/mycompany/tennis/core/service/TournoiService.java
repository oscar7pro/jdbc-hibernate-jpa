package com.mycompany.tennis.core.service;

import com.mycompany.tennis.core.EntityManagerHolder;
import com.mycompany.tennis.core.dto.TournoiDto;
import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.repository.TournoiRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class TournoiService {
    private TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
        this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public TournoiDto getTournoi(Long id) {
       // Session session = null;
        EntityTransaction txt = null;
        Tournoi tournoi = null;
        TournoiDto  tournoiDto = null;
        EntityManager em = null;
        try {
           // session = HibernateUtil.getSessionFactory().getCurrentSession();

             em =new EntityManagerHolder().getCurrentEntityManager();
            txt = em.getTransaction();
            txt.begin();
          //  txt = session.beginTransaction();
            tournoi = tournoiRepository.getById(id);
            tournoiDto = new TournoiDto();
            tournoiDto.setId(tournoi.getId());
            tournoiDto.setNom(tournoi.getNom());
            tournoiDto.setCode(tournoi.getCode());
            txt.commit();
        } catch (Exception e) {
            if(txt!=null) {
                txt.rollback();
            }
            e.printStackTrace();
        }finally {
            if (em != null) {
                em.close();
            }
        }
        return tournoiDto;
    }

    public void createTournoi(TournoiDto dto) {
        EntityManager em = null;
        EntityTransaction txt = null;
        //Session session = null;
        //Transaction txt = null;
        try {
            em =new EntityManagerHolder().getCurrentEntityManager();
            txt = em.getTransaction();
            txt.begin();
           /* session = HibernateUtil.getSessionFactory().getCurrentSession();
            txt = session.beginTransaction();*/
            Tournoi tournoi = new Tournoi();
            tournoi.setId(dto.getId());
            tournoi.setCode(dto.getCode());
            tournoi.setNom(dto.getNom());
            tournoiRepository.create(tournoi);
            txt.commit();
        } catch (Exception e) {
            if(txt!=null) {
                txt.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteTournoi(Long id) {
       /* Session session = null;
        Transaction txt = null;*/
        EntityManager em = null;
        EntityTransaction txt = null;

        try {
            em =new EntityManagerHolder().getCurrentEntityManager();
            txt = em.getTransaction();
            txt.begin();
            /*session = HibernateUtil.getSessionFactory().getCurrentSession();
            txt = session.beginTransaction();*/
            tournoiRepository.delete(id);
            txt.commit();
        } catch (Exception e) {
            if(txt!=null) {
                txt.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
