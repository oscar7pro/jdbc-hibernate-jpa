package com.mycompany.tennis.core.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQuery(query = "select j from Joueur j where j.sexe = ?0", name = "given_sexe")
@NamedQuery(query = "select j from Joueur j where j.sexe = ?0", name = "given_nom")
@Entity
@Table(name = "JOUEUR")
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private  Character sexe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(id, joueur.id) &&
                Objects.equals(nom, joueur.nom) &&
                Objects.equals(prenom, joueur.prenom) &&
                Objects.equals(sexe, joueur.sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, sexe);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }
}
