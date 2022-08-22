package dev.ledesma.tests.dao;

import dev.ledesma.dao.MeetingDAO;
import dev.ledesma.dao.MeetingPostgresDAO;
import dev.ledesma.entity.Meeting;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingDAOTest {

    static Logger logger = LogManager.getLogger(ComplaintDAOTest.class.getName());
    private static MeetingDAO meetingDAO = new MeetingPostgresDAO();

    @Test
    void createMeeting() {
        Meeting meeting = new Meeting(0, 1, 1, "town hall");
        Assertions.assertNotNull(meetingDAO.createMeeting(meeting));
    }

    @Test
    void getAllMeetings() {

        List<Meeting> meetingList = meetingDAO.getAllMeetings();
        System.out.println(meetingList);
        Assertions.assertNotNull(meetingList);
    }
}