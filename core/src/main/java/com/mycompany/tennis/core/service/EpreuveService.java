package com.mycompany.tennis.core.service;

import com.mycompany.tennis.core.EntityManagerHolder;
import com.mycompany.tennis.core.HibernateUtil;
import com.mycompany.tennis.core.dto.*;
import com.mycompany.tennis.core.entity.Epreuve;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.repository.EpreuveRepositoryImpl;
import com.mycompany.tennis.core.repository.TournoiRepositoryImpl;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EpreuveService {
    private EpreuveRepositoryImpl epreuveRepository;

    public EpreuveService() {
        this.epreuveRepository = new EpreuveRepositoryImpl();
    }

    public List<EpreuveFullDto> getListJEpreuves(String codeTournoi) {
        EntityManager em =null;
        EntityTransaction transaction = null;
        /*Session session =  null;
        Transaction transaction = null;*/
        List<EpreuveFullDto> dtos =  new ArrayList<>();
        try {
            em = EntityManagerHolder.getCurrentEntityManager();
            transaction = em.getTransaction();
            //txt.beginTransaction();
            List<Epreuve> epreuves =  epreuveRepository.list(codeTournoi);

            for (Epreuve epreuve : epreuves) {
                final EpreuveFullDto dto = new EpreuveFullDto();
                dto.setId(epreuve.getId());
                dto.setAnnee(epreuve.getAnnee());
                dto.setTypeEpreuve(epreuve.getTypeEpreuve());
                TournoiDto  tournoiDto = new TournoiDto();
                tournoiDto.setId(epreuve.getId());
                tournoiDto.setNom(epreuve.getTournoi().getNom());
                tournoiDto.setCode(tournoiDto.getCode());
                dto.setTournoi(tournoiDto);
                dto.setTournoi(tournoiDto);
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

    public EpreuveFullDto getEpreuveDetaillee(Long id) {
        Session session = null;
        Transaction transaction = null;
        Epreuve epreuve = null;
        EpreuveFullDto dto = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            epreuve = epreuveRepository.getById(id);

            dto = new EpreuveFullDto();
            dto.setId(epreuve.getId());
            dto.setAnnee(epreuve.getAnnee());
            dto.setTypeEpreuve(epreuve.getTypeEpreuve());

            TournoiDto  tournoiDto = new TournoiDto();
            tournoiDto.setId(epreuve.getId());
            tournoiDto.setNom(epreuve.getTournoi().getNom());
            tournoiDto.setCode(tournoiDto.getCode());
            dto.setTournoi(tournoiDto);

           dto.setParticipants(new HashSet<>());
            for(Joueur joueur:epreuve.getParticipants()) {
                final JoueurDto joueurDto = new JoueurDto();
                joueurDto.setId(joueur.getId());
                joueurDto.setPrenom(joueur.getPrenom());
                joueurDto.setNom(joueur.getNom());
                joueurDto.setSexe(joueur.getSexe());
                dto.getParticipants().add(joueurDto);

            }
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }

        }
        return dto;
    }

    public EpreuveLigthlDto getEpreuveSansTournoi(Long id) {
        Session session = null;
        Transaction transaction = null;
        Epreuve epreuve = null;
        EpreuveLigthlDto dto = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            epreuve = epreuveRepository.getById(id);



             dto = new EpreuveLigthlDto();
            dto.setId(epreuve.getId());
            dto.setAnnee(epreuve.getAnnee());
            dto.setTypeEpreuve(epreuve.getTypeEpreuve());
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }

        }
        return dto;
    }


}
