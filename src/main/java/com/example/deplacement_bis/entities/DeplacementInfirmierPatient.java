package com.example.deplacement_bis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeplacementInfirmierPatient {
    private Deplacement deplacement;
    private Infirmier infirmier;
    private Patient patient;
}
