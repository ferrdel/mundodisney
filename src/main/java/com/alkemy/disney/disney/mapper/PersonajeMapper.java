package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.PersonajeEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonajeMapper {
    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto) {
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity) {
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        return dto;
    }
/*
    public PersonajeDTO personajeEntityRefreshValues(PersonajeEntity entity){
        PersonajeDTO dtoS = new PersonajeDTO();
        dtoS.setNombre(entity.getNombre());
        dtoS.setImagen(entity.getImagen());
        dtoS.setEdad(entity.getEdad());
        dtoS.setPeso(entity.getPeso());
        dtoS.setHistoria(entity.getHistoria());
        return dtoS;
    } */
}
