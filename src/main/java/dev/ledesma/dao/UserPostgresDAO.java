package dev.ledesma.dao;

import dev.ledesma.entity.User;
import dev.ledesma.entity.UserTitle;
import dev.ledesma.utility.ConnectionUtility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;

public class UserPostgresDAO implements UserDAO{
    static Logger logger = LogManager.getLogger(UserPostgresDAO.class.getName());
    @Override
    public User createUser(User user) {
        try(Connection conn = ConnectionUtility.createConnection()){
            String sql = "insert into account values(default, ?, ?, ?, ?, 'PENDING')";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("id");
            user.setId(key);

            return user;
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("Could Not Create User" + user, e);
            return null;
        }
    }

    @Override
    public User modifyUser(User user) {

        try(Connection conn = ConnectionUtility.createConnection()){
            String sql ="update account set title = CAST(? AS userrank) where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getTitle().toString());
            ps.setInt(2, user.getId());
            ps.executeUpdate();

            return user;
        }catch(SQLException e){
            e.printStackTrace();
            logger.error("Could Not Update Account" + user, e );
            return null;
        }
    }

    public User getUser(String username){

        try(Connection conn = ConnectionUtility.createConnection()) {
            String sql = "select * from account where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            rs.next();

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("userpass"));
            user.setFirstname(rs.getString("fname"));
            user.setLastname(rs.getString("lname"));
            user.setTitle(UserTitle.valueOf(rs.getString("title")));

            return user;

        }catch (SQLException e){
            e.printStackTrace();
            logger.error("Could Not Retrieve User", e);
            return null;
        }
    }
}
