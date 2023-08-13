package com.pfe.marchepublic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "concurrents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class concurrents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private  offre offre;

    @ManyToOne
    private avis avis;
    @ManyToOne
    private concurent_list concurent_list;

    private String  gagnant;
    private String  Postuler;
    private String  Dossier_complet;
    private String  existe;
    private String  eliminerpvdeux;
    private String  eliminertrois;
    private String  eliminer;
    @Column(length = 1500)
    private String  Motif;
    private String  reserver;
    private String  objet_reserve;
    private String  Mantant_dactes;
    private float Mantant_dactes_apres_verification;
    private float Taux;
    private String observe;
    private Integer note_experience;
    private Integer N2_1_chef_projet;
    private Integer N2_2_technicien;
    private Integer N2_3_operateur;
    private Integer N3_1_note_materiel;
    private Integer N3_2_note_methodologie_materiel;




}
