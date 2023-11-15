package com.hostelmanagement.service;

import com.hostelmanagement.model.Complaint;
import com.hostelmanagement.model.Hostel;
import com.hostelmanagement.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    private  ComplaintRepository complaintRepository;

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }

    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public Complaint updateComplaint(Long id, Complaint updatedComplaint) {
        return complaintRepository.findById(id)
                .map(complaint -> {
                    complaint.setDate(updatedComplaint.getDate());
                    complaint.setDescription(updatedComplaint.getDescription());
                    complaint.setStatus(updatedComplaint.getStatus());
                    // You might want to handle RoomAllotment update here as well
                    return complaintRepository.save(complaint);
                })
                .orElseGet(() -> {
                    updatedComplaint.setId(id);
                    return complaintRepository.save(updatedComplaint);
                });
    }

    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }

    public List<Hostel> getcomplaintInTimePeriod(Date startTime, Date endTime) {
        return complaintRepository.findByCreateDateBetween(startTime, endTime);
    }
}

