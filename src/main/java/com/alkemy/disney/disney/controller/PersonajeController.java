package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personaje")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje){
        PersonajeDTO personajeGdo= personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGdo);
    }
    
    /*
    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(@RequestBody PersonajeDTO personaje, @PathVariable Long id){
        PersonajeDTO personajeDTO= personajeService.update(personaje, id);
        return ResponseEntity.ok().body(personajeDTO);
    } */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
