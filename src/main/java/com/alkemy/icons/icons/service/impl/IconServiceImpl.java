package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconRepository iconRepository;

    @Autowired
    private IconMapper iconMapper;

    public IconDTO save(IconDTO dto){
        IconEntity entity = iconMapper.iconDTO2Entity(dto);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDTO iconDTO = iconMapper.iconEntity2DTO(entitySaved, false);
        return iconDTO;
    }
    public List<IconBasicDTO> getAllBasicIcons(){
        List<IconBasicDTO> icons = iconMapper.iconBasicList(iconRepository.findAll());
        return icons;
    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }


}
