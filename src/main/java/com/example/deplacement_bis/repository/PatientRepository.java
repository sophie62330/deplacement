package com.example.deplacement_bis.repository;

import com.example.deplacement_bis.entities.Infirmier;
import com.example.deplacement_bis.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class PatientRepository {

    @Autowired
    private WebClient webClient;
    public Mono<Patient> getPatientById(String idPatient){
        Mono<Patient> patient =webClient.get()
                .uri("http://localhost:8081/patient/"+ idPatient)
                .retrieve()
                .bodyToMono(Patient.class);
        return patient;
    }
}
