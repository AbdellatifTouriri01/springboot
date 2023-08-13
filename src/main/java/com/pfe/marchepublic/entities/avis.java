package com.pfe.marchepublic.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "avis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String num_avis;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date_avis;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date_ouverture;
    @Column(length = 10)
    private String heure;
    @OneToMany
    @JoinColumn(name = "avis_id")
    private List<offre> offre;


}
