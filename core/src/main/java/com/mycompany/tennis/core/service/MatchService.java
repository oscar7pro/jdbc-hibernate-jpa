package com.mycompany.tennis.core.service;

import com.mycompany.tennis.core.HibernateUtil;
import com.mycompany.tennis.core.dto.*;
import com.mycompany.tennis.core.entity.Epreuve;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.entity.Match;
import com.mycompany.tennis.core.entity.Score;
import com.mycompany.tennis.core.repository.EpreuveRepositoryImpl;
import com.mycompany.tennis.core.repository.JoueurRepositoryImpl;
import com.mycompany.tennis.core.repository.MatchRepositoryImpl;
import com.mycompany.tennis.core.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MatchService {
    private ScoreRepositoryImpl scoreRepository;
    private MatchRepositoryImpl matchRepository;
    private EpreuveRepositoryImpl epreuveRepository;
    private JoueurRepositoryImpl joueurRepository;

    public MatchService() {
        this.scoreRepository = new ScoreRepositoryImpl();
        this.matchRepository = new MatchRepositoryImpl();
        this.epreuveRepository = new EpreuveRepositoryImpl();
        this.joueurRepository = new JoueurRepositoryImpl();
    }

 public  void createMatch(MatchDto dto) {
        Session session = null;
        Transaction transaction = null;
        Match match = null;
        try {
               session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            match = new Match();
            match.setEpreuve(epreuveRepository.getById(dto.getEpreuve().getId()));
            match.setVainqueur(joueurRepository.getById(dto.getVainqueur().getId()));
            match.setFinaliste(joueurRepository.getById(dto.getFinaliste().getId()));
            Score score = new Score();
            score.setMatch(match);
            match.setScore(score);
            score.setSet1(dto.getScore().getSet1());
            score.setSet2(dto.getScore().getSet2());
            score.setSet3(dto.getScore().getSet3());
            score.setSet4(dto.getScore().getSet4());
            score.setSet5(dto.getScore().getSet5());

            matchRepository.create(match);
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
    }

    public MatchDto getMatch(Long id) {
        Session session = null;
        Transaction transaction = null;
        Match match = null;
        MatchDto dto = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            match = matchRepository.getById(id);

            dto = new MatchDto();
            dto.setId(match.getId());

            JoueurDto finaliste = new JoueurDto();
            finaliste.setId(match.getFinaliste().getId());
            finaliste.setNom(match.getFinaliste().getNom());
            finaliste.setPrenom(match.getFinaliste().getPrenom());
            finaliste.setSexe(match.getFinaliste().getSexe());
            dto.setFinaliste(finaliste);

            JoueurDto vainqueur = new JoueurDto();
            vainqueur.setId(match.getVainqueur().getId());
            vainqueur.setNom(match.getVainqueur().getNom());
            vainqueur.setPrenom(match.getVainqueur().getPrenom());
            vainqueur.setSexe(match.getVainqueur().getSexe());
            dto.setVainqueur(vainqueur);

            EpreuveFullDto epreuveDto   = new EpreuveFullDto();
            epreuveDto.setId(match.getEpreuve().getId());
            epreuveDto.setAnnee(match.getEpreuve().getAnnee());
            epreuveDto.setTypeEpreuve(match.getEpreuve().getTypeEpreuve());

            TournoiDto  tournoiDto = new TournoiDto();
            tournoiDto.setId(match.getEpreuve().getTournoi().getId());
            tournoiDto.setNom(match.getEpreuve().getTournoi().getNom());
            tournoiDto.setCode(match.getEpreuve().getTournoi().getCode());
            epreuveDto.setTournoi(tournoiDto);
            dto.setEpreuve(epreuveDto);
            ScoreFullDto scoreFullDto = new ScoreFullDto();
            scoreFullDto.setId(match.getScore().getId());
            scoreFullDto.setSet1(match.getScore().getSet1());
            scoreFullDto.setSet2(match.getScore().getSet2());
            scoreFullDto.setSet3(match.getScore().getSet3());
            scoreFullDto.setSet4(match.getScore().getSet4());
            scoreFullDto.setSet5(match.getScore().getSet5());
            dto.setScore(scoreFullDto);
            scoreFullDto.setMatch(dto);

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

    public void enregistrerNouveauMatch(Match match) {
        matchRepository.create(match);
        scoreRepository.create(match.getScore());
    }

    public  void tapisVert(Long id) {
        Session session = null;
        Transaction transaction = null;
        Match match = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            match = matchRepository.getById(id);
            Joueur ancienVainqueur = match.getVainqueur();
            match.setVainqueur(match.getFinaliste());
            match.setFinaliste(match.getVainqueur());
            match.getScore().setSet1((byte)0);
            match.getScore().setSet2((byte)0);
            match.getScore().setSet3((byte)0);
            match.getScore().setSet4((byte)0);
            match.getScore().setSet5((byte)0);

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
    }

    public  void deleteMatch(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
             matchRepository.delete(id);

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
    }

}
