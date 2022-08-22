package dev.ledesma.tests.dao;

import dev.ledesma.dao.ComplaintDAO;
import dev.ledesma.dao.ComplaintPostgresDAO;
import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.PriorityStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class ComplaintDAOTest {

    static Logger logger = LogManager.getLogger(ComplaintDAOTest.class.getName());
    private static ComplaintDAO complaintDAO = new ComplaintPostgresDAO();

    @Test
    void createComplaint() {

        Complaint complaint = new Complaint(0, "category", "description", PriorityStatus.UNREVIEWED, 0);
        Assertions.assertNotNull(complaintDAO.createComplaint(complaint));

    }

    @Test
    void updateComplaint() {

        Complaint complaint = new Complaint(1, "update", "update", PriorityStatus.IGNORED, 1);
        Assertions.assertNotNull(complaintDAO.updateComplaint(complaint));

    }

    @Test
    void getAllComplaints() {

        List<Complaint> complaintList = complaintDAO.getAllComplaints(PriorityStatus.UNREVIEWED);
        System.out.println(complaintList);
        Assertions.assertNotNull(complaintList);

    }
}