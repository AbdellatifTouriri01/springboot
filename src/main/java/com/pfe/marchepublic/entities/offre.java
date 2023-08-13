package com.pfe.marchepublic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Num;
    private Double caution;
    private Double estimation;
    @Column(name ="objet" , length=500 )
    private String objet;
    @Column(name ="objet_ar", length=500 )

    private String objet_ar;


}
