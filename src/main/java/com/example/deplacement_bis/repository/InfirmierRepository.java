package com.example.deplacement_bis.repository;


import com.example.deplacement_bis.entities.Infirmier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class InfirmierRepository {

    @Autowired
    private WebClient webClient;
    public Mono<Infirmier> getInfirmierById(String idInfirmier){
        Mono<Infirmier> infirmier =webClient.get()
                .uri("http://localhost:8080/infirmier/"+ idInfirmier)
                .retrieve()
                .bodyToMono(Infirmier.class);
        return infirmier;
    }
}
