package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.*;
import com.mycompany.tennis.core.service.EpreuveService;
import com.mycompany.tennis.core.service.MatchService;

import java.util.Scanner;

public class MatchControlleur {

    private MatchService matchService;
    public MatchControlleur() {
        this.matchService = new MatchService();
    }

    public void ajouterMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient de l'épreuve ?");
        long epreuveID = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'identifient de vainqueur ?");
        long vainqueurID = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'identifient de finaliste ?");
        long finalisteID = scanner.nextLong();
        scanner.nextLine();

        MatchDto dto = new MatchDto();
        dto.setEpreuve(new EpreuveFullDto());
        dto.getEpreuve().setId(epreuveID);

        dto.setFinaliste(new JoueurDto());
        dto.getFinaliste().setId(finalisteID);

        dto.setVainqueur(new JoueurDto());
        dto.getVainqueur().setId(vainqueurID);

        System.out.println("Quel est la valeur du 1er set ?");
        byte set1 = scanner.nextByte();
        scanner.nextLine();

        System.out.println("Quel est la valeur du 2e set ?");
        byte set2 = scanner.nextByte();
        scanner.nextLine();

        System.out.println("Quel est la valeur du 3e set ?");
        byte set3 = scanner.nextByte();
        scanner.nextLine();

        System.out.println("Quel est la valeur du 4e set ?");
        byte set4 = scanner.nextByte();
        scanner.nextLine();

        System.out.println("Quel est la valeur du 5e set ?");
        byte set5 = scanner.nextByte();
        scanner.nextLine();

        ScoreFullDto scoreFullDto = new ScoreFullDto();
        scoreFullDto.setSet1(set1);
        scoreFullDto.setSet2(set2);
        scoreFullDto.setSet3(set3);
        scoreFullDto.setSet4(set4);
        scoreFullDto.setSet5(set5);

        dto.setScore(scoreFullDto);
        scoreFullDto.setMatch(dto);
        matchService.createMatch(dto);
    }

    public void tapisVert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du match dont vous voulez annuler les insformations ?");
        long identifient = scanner.nextLong();
        matchService.tapisVert(identifient);

    }

    public void supprimerMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du match dont vous voulez supprimer ?");
        long identifient = scanner.nextLong();
        matchService.deleteMatch(identifient);

    }



    public void afficheDetailMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du match dont vous voulez afficher les insformations ?");
        long identifient = scanner.nextLong();

        MatchDto matchDto = matchService.getMatch(identifient);
        System.out.println("Il s'agit d'un match de "+matchDto.getEpreuve().getAnnee() + " qui s'est deroulé" +matchDto.getEpreuve().getTournoi().getNom());
        System.out.println("Le finaliste   porte le nom de "+matchDto.getFinaliste().getNom()+ " " +matchDto.getFinaliste().getPrenom());
        System.out.println("Le vainqueur est  "+matchDto.getVainqueur().getNom()+ " "+matchDto.getVainqueur().getPrenom());

        System.out.println("Le score selectionné  présente les details suivants "
                + "  "
                +matchDto.getScore().getSet1()+ "  "
                +matchDto.getScore().getSet2() + "  "
        );
        if(matchDto.getScore().getSet3() != null) {
            System.out.println(matchDto.getScore().getSet3() + "  ");
        }
        if(matchDto.getScore().getSet4() != null) {
            System.out.println(+matchDto.getScore().getSet4() + "  ");
        }
        if(matchDto.getScore().getSet5() != null) {
            System.out.println(+matchDto.getScore().getSet5()+ "  ");
        }
    }



}
