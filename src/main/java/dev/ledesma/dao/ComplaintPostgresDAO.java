package dev.ledesma.dao;

import dev.ledesma.entity.Complaint;
import dev.ledesma.entity.PriorityStatus;
import dev.ledesma.utility.ConnectionUtility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintPostgresDAO implements ComplaintDAO{

    static Logger logger = LogManager.getLogger(ComplaintPostgresDAO.class.getName());
    @Override
    public Complaint createComplaint(Complaint complaint) {

        try(Connection conn = ConnectionUtility.createConnection()) {
            String sql = "insert into complaint values (default, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, complaint.getCategory());
            ps.setString(2, complaint.getDescription());
            ps.setString(3, complaint.getStatus().toString());
            ps.setInt(4, complaint.getMeetingId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("id");
            complaint.setId(key);
            return complaint;

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Could Not Create Employee: " + complaint, e);
            return null;
        }

    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {

        try(Connection conn = ConnectionUtility.createConnection()){
            String sql ="update complaint set status = ?, meetingid = ? where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, complaint.getStatus().toString());
            ps.setInt(2, complaint.getMeetingId());
            ps.setInt(3, complaint.getId());
            ps.executeUpdate();

            return complaint;
        }catch(SQLException e){
            e.printStackTrace();
            logger.error("Could Not Update Complaint" + complaint, e );
            return null;
        }
    }

    @Override
    public List<Complaint> getAllComplaints(PriorityStatus status) {

        try(Connection conn = ConnectionUtility.createConnection()) {
            String sql ="select * from complaint where status = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status.toString());
            ResultSet rs = ps.executeQuery();

            List<Complaint> complaints = new ArrayList<>();

            while(rs.next()){
                Complaint complaint = new Complaint();
                complaint.setId(rs.getInt("id"));
                complaint.setCategory(rs.getString("category"));
                complaint.setDescription(rs.getString("description"));
                complaint.setStatus(PriorityStatus.valueOf(rs.getString("status")));
                complaint.setMeetingId(rs.getInt("meetingid"));
                complaints.add(complaint);
            }return complaints;

        }catch(SQLException e ){
            e.printStackTrace();
            logger.error("Could Not Retrieve All Complaints" + status, e);
            return null;
        }
    }
}
