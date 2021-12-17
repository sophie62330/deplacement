package com.example.deplacement_bis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deplacement {
    @Id
    private String id;
    private String idInfirmier;
    private String idPatient;
    private float cout;
    private Date date;
}
