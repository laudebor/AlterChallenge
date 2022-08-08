package com.alkemy.icons.icons.controller;


import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon){
        IconDTO iconGuardado = iconService.save(icon);
        //TODO: how to handle LocalDate and how to associate an icon to countries
        return ResponseEntity.status(HttpStatus.CREATED).body(iconGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
