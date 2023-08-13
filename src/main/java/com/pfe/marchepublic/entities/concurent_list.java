package com.pfe.marchepublic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "concurent_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class concurent_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    private String Nom_gerant;
    private String qualiter;
    private String Num_cnss;
    private long capital_social;
    private String registre;
    private String RIB;
    private String banque;
    private String adresse;


}
