package com.alkemy.disney.disney.service.implement;

import com.alkemy.disney.disney.dto.PersonajeDTO;
import com.alkemy.disney.disney.entity.PersonajeEntity;
import com.alkemy.disney.disney.mapper.PersonajeMapper;
import com.alkemy.disney.disney.repository.PersonajeRepository;
import com.alkemy.disney.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonajeServiceImp implements PersonajeService {
    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity= personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity entitySaved= personajeRepository.save(entity);
        PersonajeDTO result= personajeMapper.personajeEntity2DTO(entitySaved);
        return result;
    }

    public PersonajeDTO update(PersonajeDTO dto,Long id) {
        Optional<PersonajeEntity> entity= personajeRepository.findById(id);
        if (entity.isPresent()){
            this.personajeMapper.personajeEntityRefreshValues(entity.get());
            PersonajeEntity entitySaved= this.personajeRepository.save(entity.get());
            PersonajeDTO result= this.personajeMapper.personajeEntity2DTO(entitySaved);
            return result;
        }else {
            return null;
        }

    }

    public void delete(Long id){
        personajeRepository.deleteById(id);
    }
}
