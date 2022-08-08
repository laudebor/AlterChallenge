package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PaisMapper {

    @Autowired
    private IconMapper iconMapper;

    public PaisEntity paisDTO2Entity(PaisDTO dto){
        PaisEntity pais = new PaisEntity();
        pais.setImagen(dto.getImagen());
        pais.setDenominacion(dto.getDenominacion());
        pais.setCantidadHabitantes(dto.getCantidadHabitantes());
        pais.setContinenteId(dto.getContinenteId());
        pais.setSuperficie(dto.getSuperficie());
        Set<IconEntity> icons = new HashSet<>(iconMapper.iconListDTO2Entity(dto.getIcons()));
        pais.setIcons(icons);
        return pais;
    }

    public PaisDTO paisEntity2DTO(PaisEntity paisEntity, boolean loadIcons){
        PaisDTO dto = new PaisDTO();
        dto.setId(paisEntity.getId());
        dto.setImagen(paisEntity.getImagen());
        dto.setDenominacion(paisEntity.getDenominacion());
        dto.setContinenteId(paisEntity.getContinenteId());
        dto.setSuperficie(paisEntity.getSuperficie());
        dto.setCantidadHabitantes(paisEntity.getCantidadHabitantes());
        if(loadIcons){
            List<IconDTO> iconDTOs = iconMapper.iconSetEntity2DTO(paisEntity.getIcons(), false);
            dto.setIcons(iconDTOs);
        }
        return dto;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> paises, boolean loadIcons){
        List<PaisDTO> dtos = new ArrayList<>();
        for(PaisEntity aux : paises){
            dtos.add(paisEntity2DTO(aux, loadIcons));
        }
        return dtos;
    }
}
