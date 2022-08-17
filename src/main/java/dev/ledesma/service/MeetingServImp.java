package dev.ledesma.service;

import dev.ledesma.dao.MeetingDAO;
import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.Meeting;

import java.util.List;

public class MeetingServImp implements MeetingService {
    private MeetingDAO meetingDAO;
    @Override
    public Meeting createMeeting(Meeting meeting) {

        if(this.meetingDAO.createMeeting(meeting) == null){
            throw new RuntimeException("Could not create new meeting!");
        }else{
            return this.meetingDAO.createMeeting(meeting);
        }
    }

    @Override
    public List<Meeting> getAllMeetings() {

        if(this.meetingDAO.getAllMeetings().size() == 0){
            throw new RuntimeException("Could not retrieve all meetings!");
        }else{
            return this.meetingDAO.getAllMeetings();
        }
    }
}
