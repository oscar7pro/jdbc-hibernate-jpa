package com.mycompany.tennis;

import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.repository.JoueurRepositoryImpl;
import com.mycompany.tennis.core.repository.TournoiRepositoryImpl;
import com.mycompany.tennis.core.service.JoueurService;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.List;

public class TestDeConnection {
    public static void main(String... args){
     /*  JoueurRepositoryImpl joueurRepository = new JoueurRepositoryImpl();
        JoueurService joueurService = new JoueurService();
       Joueur bartoli =  joueurRepository.getById(21L);
       System.out.println(bartoli.getPrenom() + " "+bartoli.getNom());

        Joueur noah =  new Joueur();
        noah.setNom("Noah");
        noah.setPrenom("Janice");
        noah.setSexe('F');
        joueurService.createJoueur(noah);
        joueurService.getJoueur(21L);

       Joueur noah1 = joueurRepository.getById(62L);
        noah1.setPrenom("Yannick");
       joueurRepository.updateJ(noah1);

        joueurRepository.delete(65L);
       List<Joueur> liste =  joueurRepository.list();
       for (Joueur joueur: liste) {
           System.out.println(joueur.getPrenom()+" "+joueur.getNom());
       }
        Joueur noah2 =  new Joueur();
        noah2.setNom("Noah");
        noah2.setPrenom("Yannick");
        noah2.setSexe('H');
        joueurRepository.create(noah2);
        System.out.println("L'identifiant du joueur créé est :" +noah2.getId());
*/
    }
}
