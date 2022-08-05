package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {

    public ContinenteEntity MapperContinenteDTO2Entity(ContinenteDTO dto){
        ContinenteEntity entity = new ContinenteEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        return entity;
    }

    public ContinenteDTO MapperContinenteEntity2DTO(ContinenteEntity entity){
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }

    public List<ContinenteDTO> MapperListContinenteEntity2DTO(List<ContinenteEntity> continentes){
        List<ContinenteDTO> continentesDTO = new ArrayList();
        for(ContinenteEntity continente: continentes){
            continentesDTO.add(MapperContinenteEntity2DTO(continente));
        }
        return continentesDTO;
    }
}
