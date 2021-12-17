package com.example.deplacement_bis.controller;

import com.example.deplacement_bis.entities.Deplacement;
import com.example.deplacement_bis.entities.DeplacementInfirmierPatient;
import com.example.deplacement_bis.service.DeplacementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deplacements")
public class DeplacementController {
    private DeplacementService service;

    @GetMapping()
    public List<Deplacement> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id]")
    public Deplacement findOne(String id) {
        return service.findOne(id);
    }

    @PutMapping()
    public Deplacement update(@RequestBody Deplacement deplacement) {
        return service.save(deplacement);
    }

    @PostMapping()
    public Deplacement create(@RequestBody Deplacement deplacement) {
        return service.save(deplacement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("deplacement supprimé");
    }

    @GetMapping("/next")
    public List<Deplacement> findNext() {
        return service.findNext();
    }


    @GetMapping("/infirmier/{idInfirmier}")
    public List<Deplacement> findByInfirmier(@PathVariable String idInfirmier) {
        return service.findByInfirmier(idInfirmier);
    }

    @GetMapping("/patient/{idPatient}")
    public List<Deplacement> findByPatient(@PathVariable String idPatient) {
        return service.findByPatient(idPatient);
    }

    @GetMapping("/detail/{id}")
    public DeplacementInfirmierPatient getDetail(@PathVariable String id) {
        return service.getDetail(id);
    }

}
