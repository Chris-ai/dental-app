package com.example.dentalapp.controller;

import com.example.dentalapp.model.Position;
import com.example.dentalapp.model.dto.PositionDto;
import com.example.dentalapp.model.dto.PositionDtoMapper;
import com.example.dentalapp.service.PositionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/positions")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<PositionDto> getPositions(){
        return PositionDtoMapper.mapToPositionDtos(positionService.getPositions());
    }

    @GetMapping("/positions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PositionDto getSinglePosition(@PathVariable long id){
        return PositionDtoMapper.mapToPositionDto(positionService.getSinglePosition(id));
    }


    @PostMapping("/positions")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Position createPosition(@RequestBody Position position){
        return positionService.createPosition(position);
    }

    @PutMapping("/positions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Position editPosition(@PathVariable long id, @RequestBody Position position ){
        return positionService.editPosition(position,id);
    }

    @DeleteMapping("/positions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deletePosition(@PathVariable long id){
        positionService.deletePosition(id);
    }
}
