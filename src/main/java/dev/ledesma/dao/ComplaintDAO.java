package dev.ledesma.dao;

import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.PriorityStatus;

import java.util.List;

public interface ComplaintDAO {

    Complaint createComplaint(Complaint complaint);
    Complaint updateComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();

}
