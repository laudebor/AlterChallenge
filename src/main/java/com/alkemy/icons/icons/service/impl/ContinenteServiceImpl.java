package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;

    @Autowired
    private ContinenteRepository continenteRepository;

    public ContinenteDTO save(ContinenteDTO dto) {
        ContinenteEntity continenteEntity = continenteMapper.MapperContinenteDTO2Entity(dto);
        ContinenteEntity entitySaved = continenteRepository.save(continenteEntity);
        ContinenteDTO continenteDTO = continenteMapper.MapperContinenteEntity2DTO(entitySaved);
        return continenteDTO;
    }

    public List<ContinenteDTO> getAllContinentes() {
        List<ContinenteEntity> continentes = continenteRepository.findAll();
        List<ContinenteDTO> continentesDTO = continenteMapper.MapperListContinenteEntity2DTO(continentes);
        return continentesDTO;
    }

    public void delete(Long id) {
        continenteRepository.deleteById(id);
    }
}
