package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class IconMapper {

    @Autowired
    private PaisMapper paisMapper;

    public IconEntity iconDTO2Entity(IconDTO dto){
        IconEntity entity = new IconEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setAltura(dto.getAltura());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setHistoria(dto.getHistoria());
        return entity;
    }

    public IconBasicDTO iconEntity2BasicDTO(IconEntity iconEntity){
        IconBasicDTO basicIcon = new IconBasicDTO();
        basicIcon.setId(iconEntity.getId());
        basicIcon.setDenominacion(iconEntity.getDenominacion());
        basicIcon.setImagen(iconEntity.getImagen());
        return basicIcon;
    }

    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadPaises){
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        dto.setFechaCreacion(entity.getFechaCreacion());
        if(loadPaises){
            //List<PaisDTO> paisesDTO = paisMapper.paisEntityList2DTOList(entity.getPaises(), false);
            //dto.setPaises(paisesDTO);
        }
        return dto;
    }

    public List<IconDTO> iconSetEntity2DTO(Set<IconEntity> icons, boolean loadPaises){
        List<IconDTO> dtos = new ArrayList<>();
        for(IconEntity aux : icons){
            dtos.add(iconEntity2DTO(aux, loadPaises));
        }
        return dtos;
    }

    public Set<IconEntity> iconListDTO2Entity(List<IconDTO> dtos){
        Set<IconEntity> icons = new HashSet();
        for(IconDTO aux : dtos){
            icons.add(iconDTO2Entity(aux));
        }
        return icons;
    }

    public List<IconBasicDTO> iconBasicList(List<IconEntity> icons){
        List<IconBasicDTO> basicIcons = new ArrayList<>();
        for(IconEntity aux : icons){
            basicIcons.add(iconEntity2BasicDTO(aux));
        }
        return basicIcons;
    }


}
