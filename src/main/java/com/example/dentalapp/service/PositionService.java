package com.example.dentalapp.service;

import com.example.dentalapp.model.Position;
import com.example.dentalapp.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getPositions() {
        return positionRepository.findAll();
    }

    public Position getSinglePosition(long id) {
        return positionRepository.findById(id);
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    @Transactional
    public Position editPosition(Position position, long id) {
        Position positionEdited = positionRepository.findById(id);
        positionEdited.setName(position.getName());
        positionEdited.setEmployees(position.getEmployees());

        return positionEdited;
    }

    public void deletePosition(long id) {
        positionRepository.deleteById(id);
    }

}
