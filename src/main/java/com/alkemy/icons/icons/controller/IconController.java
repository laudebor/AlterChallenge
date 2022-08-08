package com.alkemy.icons.icons.controller;


import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping
    public ResponseEntity<List<IconBasicDTO>> getAllBasic(){
        List<IconBasicDTO> icons = iconService.getAllBasicIcons();
        return ResponseEntity.ok().body(icons);
    }
}
