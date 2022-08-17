package dev.ledesma.service;

import dev.ledesma.dao.ComplaintDAO;
import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.PriorityStatus;

import java.util.List;

public class ComplaintServImp implements ComplaintService{

    private ComplaintDAO complaintDAO;
    @Override
    public Complaint createComplaint(Complaint complaint) {

        if(complaint == null){
            throw new RuntimeException("Complaint cannot be empty");
        }else{
            Complaint savedComplaint = this.complaintDAO.createComplaint(complaint);
            return savedComplaint;
        }
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {

        if(complaint == null){
            throw new RuntimeException("Complaint cannot be updated");
        }else{
            Complaint savedComplaint = this.complaintDAO.updateComplaint(complaint);
            return savedComplaint;
        }
    }

    @Override
    public List<Complaint> getAllComplaints(PriorityStatus status) {

        if(status == null){
            throw new RuntimeException("Status cannot be empty");
        }else{
            List<Complaint> complaints = this.complaintDAO.getAllComplaints(status);
            return complaints;
        }
    }
}
