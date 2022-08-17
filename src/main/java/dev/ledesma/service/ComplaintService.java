package dev.ledesma.service;

import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.PriorityStatus;

import java.util.List;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);
    Complaint updateComplaint(Complaint complaint);
    List<Complaint> getAllComplaints(PriorityStatus status);
}
