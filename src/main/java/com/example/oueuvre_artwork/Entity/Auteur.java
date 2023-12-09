package com.example.oueuvre_artwork.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table
public class Auteur {

    public Auteur() {

    }
    public Auteur(List<Art> lista) {
        this.arts = lista;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    private String prenom;




    private LocalDate dateDeNaissance;
    private String LieuDeNaissance;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("auteur")
    private List<Art> arts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getLieuDeNaissance() {
        return LieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        LieuDeNaissance = lieuDeNaissance;
    }

    public List<Art> getArts() {
        return arts;
    }

    public void setArts(List<Art> arts) {
        this.arts = arts;
    }




}
