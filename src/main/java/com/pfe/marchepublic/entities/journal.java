package com.pfe.marchepublic.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "journal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private journales_list journales_list;
    @ManyToOne
    private offre offre;
     @ManyToOne
     private avis avis;
     private long numero_journal;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate   date;
    private int Page_num;
    private String etat;


}
