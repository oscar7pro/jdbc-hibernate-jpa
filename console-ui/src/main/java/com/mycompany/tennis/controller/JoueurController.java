package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.service.JoueurService;

import java.util.Scanner;

public class JoueurController {

    private JoueurService joueurService;
    public JoueurController() {
        this.joueurService = new JoueurService();
    }

    public void afficheListJoueurs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez vous une liste  Homme(H) ou Femme(F) ?");
        char sexe = scanner.nextLine().charAt(0);
        for(JoueurDto dto : joueurService.getListJoueurs(sexe)) {
            System.out.println(dto.getPrenom()+ " " +dto.getNom());

        }

    }


    public void creerJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le nom du joueur");
        String nom = scanner.nextLine();
        System.out.println("Saisir le prennom du joueur");
        String prenom =  scanner.nextLine();
        System.out.println("Saisir le sexe du joueur");
        char sexe =  scanner.nextLine().charAt(0);

        Joueur joueur = new Joueur();
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setSexe(sexe);
        joueurService.createJoueur(joueur);

        System.out.println("Le joeur a été  créé son identifient est " +joueur.getId());
    }

    public void afficheDetailsJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du joeur dont vous voulez afficher les insformations");
        long identifient = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(identifient);
        System.out.println("Le joeur selectionné s'appel "+joueur.getPrenom()+ " " +joueur.getNom());

    }

    public void renommeJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du joeur dont vous voulez modifier");
        long identifient = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est le nouveau nom ?");
        String nom = scanner.nextLine();
        joueurService.renomme(identifient, nom);

    }


    public void supprimeJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du joeur dont vous voulez supprimer");
        long identifient = scanner.nextLong();
        joueurService.deleteJoueur(identifient);

    }

    public void changeSexe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifient du joeur dont vous voulez modifier le sexe");
        long identifient = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est le nouveau sexe ?");
        char sexe = scanner.nextLine().charAt(0);
        joueurService.changeSexe(identifient, sexe);

    }
}
