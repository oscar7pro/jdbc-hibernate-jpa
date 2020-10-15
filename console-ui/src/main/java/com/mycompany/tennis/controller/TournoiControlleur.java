package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.TournoiDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.service.JoueurService;
import com.mycompany.tennis.core.service.TournoiService;

import java.util.Scanner;

public class TournoiControlleur {

    private TournoiService tournoiService;
    public TournoiControlleur() {
        this.tournoiService = new TournoiService();
    }

    public void creerTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir le nom du tournoi");
        String nom = scanner.nextLine();
        System.out.println("Saisir le code du tournoi");
        String code =  scanner.nextLine();
        TournoiDto tournoi = new TournoiDto();
        tournoi.setNom(nom);
        tournoi.setCode(code);

        tournoiService.createTournoi(tournoi);
        System.out.println("Le tournoi a été  créé  " );
    }

    public void afficheDetailsTournoi() {
        Scanner scanner = new Scanner(System.in);
        TournoiDto tournoi = new TournoiDto();
        System.out.println("Quel est l'identifient du tournoi dont vous voulez afficher les insformations");
        long identifient = scanner.nextLong();

         tournoi = tournoiService.getTournoi(identifient);
        System.out.println("Le tournoi selectionné est  "+tournoi.getNom()+ " " +tournoi.getCode());

    }
    public void supprimerTournoi() {
        Scanner scanner = new Scanner(System.in);
        Tournoi tournoi = new Tournoi();
        System.out.println("Quel est l'identifient du tournoi dont vous voulez supprimer");
        long identifient = scanner.nextLong();
         tournoiService.deleteTournoi(identifient);
    }
}
