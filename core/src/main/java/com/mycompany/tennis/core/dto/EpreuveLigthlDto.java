package com.mycompany.tennis.core.dto;

import com.mycompany.tennis.core.entity.Tournoi;

public class EpreuveLigthlDto {
    private Long id;
    private Short annee;
    private Character TypeEpreuve;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAnnee() {
        return annee;
    }

    public void setAnnee(Short annee) {
        this.annee = annee;
    }

    public Character getTypeEpreuve() {
        return TypeEpreuve;
    }

    public void setTypeEpreuve(Character typeEpreuve) {
        TypeEpreuve = typeEpreuve;
    }
}
