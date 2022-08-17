package dev.ledesma.service;

import dev.ledesma.entity.Meeting;

import java.util.List;

public interface MeetingService {

    Meeting createMeeting(Meeting meeting);
    List<Meeting> getAllMeetings();
}
