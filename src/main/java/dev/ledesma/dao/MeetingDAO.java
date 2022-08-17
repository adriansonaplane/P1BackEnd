package dev.ledesma.dao;

import dev.ledesma.entity.Meeting;

import java.util.List;

public interface MeetingDAO {

    Meeting createMeeting(Meeting meeting);
    List<Meeting> getAllMeetings();


}
