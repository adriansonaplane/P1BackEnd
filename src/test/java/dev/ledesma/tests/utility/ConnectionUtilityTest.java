package dev.ledesma.tests.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionUtilityTest {

    @Test
    void createConnection() {

        try{
            Connection conn = DriverManager.getConnection(System.getenv("AZURE_DB"));
            System.out.println(conn);
            Assertions.assertNotNull(conn);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}