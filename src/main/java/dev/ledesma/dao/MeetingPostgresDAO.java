package dev.ledesma.dao;

import dev.ledesma.entity.Meeting;
import dev.ledesma.utility.ConnectionUtility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingPostgresDAO implements MeetingDAO{

    static Logger logger = LogManager.getLogger(MeetingPostgresDAO.class.getName());

    @Override
    public Meeting createMeeting(Meeting meeting) {

        try(Connection conn = ConnectionUtility.createConnection()){
            String sql = "insert into meeting values (default, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, meeting.getDate());
            ps.setInt(2, meeting.getTime());
            ps.setString(3, meeting.getLocation());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("meetingid");
            meeting.setId(key);
            return meeting;

        }catch(SQLException e ){

            e.printStackTrace();
            logger.error("Could Not Create Meeting" + meeting, e);
            return null;

        }
    }

    @Override
    public List<Meeting> getAllMeetings() {

        try(Connection conn = ConnectionUtility.createConnection()){
            String sql = "select * from meeting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Meeting> meetings = new ArrayList<>();

            while(rs.next()){
                Meeting meeting = new Meeting();
                meeting.setId((rs.getInt("meetingid")));
                meeting.setDate(rs.getInt("meetingdate"));
                meeting.setTime(rs.getInt("meetingtime"));
                meeting.setLocation(rs.getString("meetinglocation"));
                meetings.add(meeting);
            }
            return meetings;

        }catch(SQLException e){
            e.printStackTrace();
            logger.error("Could Not Retrieve All Meetings", e);
            return null;
        }
    }
}
