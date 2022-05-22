package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.PersonajeDTO;

public interface PersonajeService {
    PersonajeDTO save(PersonajeDTO dto);
    //PersonajeDTO update(PersonajeDTO dto,Long id);
    void delete(Long id);
}
