package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import com.alkemy.icons.icons.mapper.PaisMapper;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private PaisMapper paisMapper;

    public PaisDTO save(PaisDTO dto) {
        PaisEntity paisEntity = paisMapper.paisDTO2Entity(dto);
        PaisEntity entitySaved = paisRepository.save(paisEntity);
        PaisDTO paisDTO = paisMapper.paisEntity2DTO(entitySaved, false);
        return paisDTO;
    }
    public List<PaisDTO> getAllPaises() {
        List<PaisEntity> paises = paisRepository.findAll();
        List<PaisDTO> paisesDTO = paisMapper.paisEntityList2DTOList(paises, false);
        return paisesDTO;
    }
}
