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
@Table(name = "pv_deux")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class pv_deux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private offre offre;
    @ManyToOne
    private avis avis;
    @OneToOne
    private pv_un pv_un;


}
