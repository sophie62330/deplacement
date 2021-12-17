package com.example.deplacement_bis.service;

import com.example.deplacement_bis.entities.Deplacement;
import com.example.deplacement_bis.entities.DeplacementInfirmierPatient;
import com.example.deplacement_bis.entities.Infirmier;
import com.example.deplacement_bis.entities.Patient;
import com.example.deplacement_bis.repository.DeplacementRepository;
import com.example.deplacement_bis.repository.InfirmierRepository;
import com.example.deplacement_bis.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeplacementService {

    @Autowired
    DeplacementRepository repository;

    InfirmierRepository infirmierRepository;

    PatientRepository patientRepository;

    public List<Deplacement> findAll() {
        return repository.findAll();
    }

    public Deplacement findOne(String id) {
        // récupérer un infirmier
        Optional<Deplacement> deplacement = repository.findById(id);

        Deplacement deplacement1 = null;
        if (deplacement.isPresent()) {
            deplacement1 = deplacement.get();
        }

        return deplacement1;
    }

    public Deplacement save(Deplacement deplacement) {
        return repository.save(deplacement);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Deplacement> findNext() {
        return repository.findDeplacementsByDateAfter(LocalDate.now());
    }

    public List<Deplacement> findByInfirmier(String idInfirmier) {
        return repository.findDeplacementsByIdInfirmierAndDateAfter(idInfirmier, LocalDate.now());
    }

    public List<Deplacement> findByPatient(String idPatient) {
        return repository.findDeplacementsByIdPatientAndDateAfter(idPatient, LocalDate.now());
    }

    public DeplacementInfirmierPatient getDetail(String id) {
        Optional<Deplacement> deplacement = repository.findById(id);
        Deplacement deplacement1 = null;
        DeplacementInfirmierPatient deplacementInfirmierPatient = null;

        if (deplacement.isPresent()) {
            deplacement1 = deplacement.get();
            String idPatient = deplacement1.getIdPatient();
            String idInfirmier = deplacement1.getIdInfirmier();

            Infirmier infirmier = infirmierRepository.getInfirmierById(idInfirmier).block();
            Patient patient = patientRepository.getPatientById(idPatient).block();

            deplacementInfirmierPatient = new DeplacementInfirmierPatient(deplacement1, infirmier, patient);
        }

        return deplacementInfirmierPatient;
    }
}
