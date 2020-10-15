package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.EpreuveFullDto;
import com.mycompany.tennis.core.dto.EpreuveLigthlDto;
import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.entity.Epreuve;
import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.service.EpreuveService;
import com.mycompany.tennis.core.service.TournoiService;

import java.util.Scanner;

public class EpreuveControlleur {

    private EpreuveService epreuveService;
    public EpreuveControlleur() {
        this.epreuveService = new EpreuveService();
    }



    public void afficheDetailsEpreuve() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient de l'épreuve dont vous voulez afficher les insformations ?");
        long identifient = scanner.nextLong();

        EpreuveFullDto epreuve = epreuveService.getEpreuveDetaillee(identifient);
        System.out.println("L'épreuve selectionné porte le nom de "+epreuve.getTournoi().getNom()+ " " );

        System.out.println("*************LES PARTICIPANTS********************");
        for(JoueurDto joueurDto : epreuve.getParticipants()) {
            System.out.println(joueurDto.getNom()+" " +joueurDto.getPrenom());
        }

    }

    public void afficheRollandGarros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient de l'épreuve dont vous voulez afficher les insformations");
        long identifient = scanner.nextLong();
        EpreuveLigthlDto epreuve = epreuveService.getEpreuveSansTournoi(identifient);
    }

    public void afficheListEpreuves() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le code du tournoi?");
        String code = scanner.nextLine();
        for(EpreuveFullDto dto : epreuveService.getListJEpreuves(code)) {
            System.out.println(dto.getId()+ " " +dto.getAnnee()+" "+dto.getTypeEpreuve() +" "+dto.getTournoi().getNom());

        }

    }

}
