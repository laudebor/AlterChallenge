package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.entity.IconPais;
import com.alkemy.icons.icons.entity.PaisEntity;
import com.alkemy.icons.icons.mapper.PaisMapper;
import com.alkemy.icons.icons.repository.IconPaisRepository;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private IconRepository iconRepository;

    @Autowired
    private PaisMapper paisMapper;

    @Autowired
    private IconPaisRepository iconPaisRepository;

    public PaisDTO save(PaisDTO dto) {
        PaisEntity paisEntity = paisMapper.paisDTO2Entity(dto);
        PaisEntity entitySaved = paisRepository.save(paisEntity);
        if(dto.getIcons().size()>0) {
            dto.getIcons().forEach(e -> {
                var icon = iconRepository.findById(e.getId());
                if(icon.isPresent()){
                    iconPaisRepository.insertRelation(e.getId(), entitySaved.getId());
                }
            });
        }

        PaisDTO paisDTO = paisMapper.paisEntity2DTO(entitySaved, true);
        return paisDTO;
    }
    public List<PaisDTO> getAllPaises() {
        List<PaisEntity> paises = paisRepository.findAll();
        List<PaisDTO> paisesDTO = paisMapper.paisEntityList2DTOList(paises, false);
        return paisesDTO;
    }

    public void delete(Long id) {
        paisRepository.deleteById(id);
    }
}
