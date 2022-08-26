package dev.ledesma.service;

import dev.ledesma.dao.ComplaintDAO;
import dev.ledesma.dao.ComplaintPostgresDAO;
import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.PriorityStatus;

import java.util.List;

public class ComplaintServImp implements ComplaintService{

    private ComplaintDAO complaintDAO;

    public ComplaintServImp(ComplaintPostgresDAO complaintPostgresDAO) {
        this.complaintDAO = complaintPostgresDAO;
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {

        Complaint createdComplaint = this.complaintDAO.createComplaint(complaint);

        if( createdComplaint == null){
            throw new RuntimeException("Could not create new complaint!");
        }else{
            return createdComplaint;
        }
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {

        Complaint updatedComplaint = this.complaintDAO.updateComplaint(complaint);

        if(updatedComplaint == null){
            throw new RuntimeException("Could not update complaint!");
        }else{
            return updatedComplaint;
        }
    }

    @Override
    public List<Complaint> getAllComplaints() {

        List<Complaint> complaints = this.complaintDAO.getAllComplaints();

        if(complaints.size() == 0){
            throw new RuntimeException("Could not retrieve all complaints!");
        }else{
            return complaints;
        }
    }
}
