package dev.ledesma.service;

import dev.ledesma.dao.MeetingDAO;
import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.Meeting;

import java.util.List;

public class MeetingServImp implements MeetingService {
    private MeetingDAO meetingDAO;

    public MeetingServImp(MeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    @Override
    public Meeting createMeeting(Meeting meeting) {

        Meeting createdMeeting = this.meetingDAO.createMeeting(meeting);

        if(createdMeeting == null){
            throw new RuntimeException("Could not create new meeting!");
        }else{
            return createdMeeting;
        }
    }

    @Override
    public List<Meeting> getAllMeetings() {

        List<Meeting> meetings = this.meetingDAO.getAllMeetings();
        if(meetings.size() == 0){
            throw new RuntimeException("Could not retrieve all meetings!");
        }else{
            return meetings;
        }
    }
}
