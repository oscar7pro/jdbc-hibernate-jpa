package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.ScoreFullDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.entity.Score;
import com.mycompany.tennis.core.service.ScoreService;

import java.util.Scanner;

public class ScoreController {
    private ScoreService scoreService;

    public ScoreController() {
        this.scoreService = new ScoreService();
    }

    public void supprimerScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du score dont vous voulez supprimer ?");
        long identifient = scanner.nextLong();
        scoreService.deleteScore(identifient);

    }

    public void afficheDetailsScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du score dont vous voulez afficher les insformations");
        long identifient = scanner.nextLong();
        ScoreFullDto score = scoreService.getScore(identifient);
        System.out.println("Le score selectionné  présente les details suivants "
                + "  "
                +score.getSet1()+ "  "
                +score.getSet2() + "  "
                );
        if(score.getSet3() != null) {
          System.out.println(score.getSet3() + "  ");
        }
        if(score.getSet4() != null) {
            System.out.println(+score.getSet4() + "  ");
        }
        if(score.getSet5() != null) {
            System.out.println(+score.getSet5()+ "  ");
        }

        System.out.println("il s'agit du tournoi " +score.getMatch().getEpreuve().getTournoi().getNom());
        System.out.println("L'épreuve s'est déroulé en  " +score.getMatch().getEpreuve().getAnnee()+ "et il s'agissait d'une épreuve " +(score.getMatch().getEpreuve().getTypeEpreuve().charValue()
        == 'H'? "HOMME" : "FEMME"));

    }

}
