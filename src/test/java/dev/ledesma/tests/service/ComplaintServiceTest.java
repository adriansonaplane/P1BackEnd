package dev.ledesma.tests.service;

import dev.ledesma.dao.ComplaintDAO;
import dev.ledesma.dao.MeetingDAO;
import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.PriorityStatus;
import dev.ledesma.service.ComplaintServImp;
import dev.ledesma.service.ComplaintService;
import dev.ledesma.service.MeetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class ComplaintServiceTest {

    @Mock
    ComplaintDAO complaintDAO = null;
    ComplaintService complaintService = null;

    @BeforeEach
    void setComplaintDAO(){

        Complaint complaint1 = new Complaint(1, "category", "description", PriorityStatus.UNREVIEWED, 1);
        Complaint complaint2 = new Complaint(2, "category", "description", PriorityStatus.UNREVIEWED, 1);
        Complaint complaint3 = new Complaint(3, "category", "description", PriorityStatus.UNREVIEWED, 1);
        Complaint complaint4 = new Complaint(4, "category", "description", PriorityStatus.UNREVIEWED, 1);
        Complaint complaint5 = new Complaint(5, "category", "description", PriorityStatus.UNREVIEWED, 1);

        List<Complaint> allComplaints = new ArrayList<Complaint>();

        allComplaints.add(complaint1);
        allComplaints.add(complaint2);
        allComplaints.add(complaint3);
        allComplaints.add(complaint4);
        allComplaints.add(complaint5);

        Complaint complaint6 = new Complaint(6, "category", "description", PriorityStatus.UNREVIEWED, 0);
//        Mockito.when(complaintDAO.getAllComplaints()).thenReturn(allComplaints);
//        Mockito.when(complaintDAO.createComplaint(complaint6)).thenReturn(complaint6);
        complaint6.setStatus(PriorityStatus.HIGH);
        complaint6.setMeetingId(1);
        Mockito.when(complaintDAO.updateComplaint(complaint6)).thenReturn(complaint6);

        complaintService = new ComplaintServImp(complaintDAO);

    }
    @Test
    void createComplaint() {


        Complaint complaint = new Complaint(6, "category", "description", PriorityStatus.UNREVIEWED, 0);
        Complaint createdComplaint = this.complaintService.createComplaint(complaint);
        System.out.println(createdComplaint);
        Assertions.assertNotNull(createdComplaint);

    }

    @Test
    void updateComplaint() {

        Complaint complaint = new Complaint(6, "category", "description", PriorityStatus.HIGH, 1);
        Complaint updateComplaintee = this.complaintDAO.updateComplaint(complaint);
        System.out.println(updateComplaintee);
        Assertions.assertNotNull(updateComplaintee);


    }

    @Test
    void getAllComplaints() {

        List<Complaint> complaints = this.complaintService.getAllComplaints();
        System.out.println(complaints);
        Assertions.assertTrue(complaints.size() > 0);
    }
}