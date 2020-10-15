package com.mycompany.tennis.core.service;

import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.repository.TournoiRepositoryImpl;

public class OLD_TournoiService {
    private TournoiRepositoryImpl tournoiRepository;

    public OLD_TournoiService() {
        this.tournoiRepository = new TournoiRepositoryImpl();
    }
    public Tournoi getTournoi(Long id) {
        return  tournoiRepository.getById(id);
    }

    public void createTournoi(Tournoi tournoi) {
        tournoiRepository.create(tournoi);
    }
}
