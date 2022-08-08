package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;

import java.util.List;

public interface IconService {

    IconDTO save(IconDTO dto);
    List<IconBasicDTO> getAllBasicIcons();

    void delete(Long id);

}
