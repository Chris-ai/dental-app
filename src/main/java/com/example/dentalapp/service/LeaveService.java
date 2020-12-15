package com.example.dentalapp.service;

import com.example.dentalapp.model.Leave;
import com.example.dentalapp.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    @Autowired
    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public List<Leave> getLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getSingleLeave(long id) {
        return leaveRepository.findById(id);
    }

    public Leave createLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Transactional
    public Leave editLeave(Leave leave,long leaveId) {
        Leave leaveEdited = leaveRepository.findById(leaveId);

        leaveEdited.setPayed(leave.getIsPayed());
        leaveEdited.setType(leave.getType());

        return leaveEdited;
    }

    public void deleteLeave(long id) {
        leaveRepository.deleteById(id);
    }
}
