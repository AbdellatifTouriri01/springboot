package com.pfe.marchepublic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "jury")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class jury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Nom ;
    private String profession ;
    private String qualiter ;

}
