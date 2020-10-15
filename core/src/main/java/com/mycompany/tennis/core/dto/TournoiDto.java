package com.mycompany.tennis.core.dto;

import javax.persistence.*;
import java.util.Objects;

public class TournoiDto {
    private Long id;
    private String nom;
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournoiDto tournoi = (TournoiDto) o;
        return Objects.equals(id, tournoi.id) &&
                Objects.equals(nom, tournoi.nom) &&
                Objects.equals(code, tournoi.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, code);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}