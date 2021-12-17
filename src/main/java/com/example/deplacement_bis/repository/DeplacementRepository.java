package com.example.deplacement_bis.repository;

import com.example.deplacement_bis.entities.Deplacement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface DeplacementRepository extends MongoRepository<Deplacement,String> {
    public List<Deplacement> findDeplacementsByDateAfter(LocalDate date);

    public List<Deplacement> findDeplacementsByIdInfirmierAndDateAfter(String idInfirmier,LocalDate date);

    public List<Deplacement> findDeplacementsByIdPatientAndDateAfter(String idPatient,LocalDate date);
}
