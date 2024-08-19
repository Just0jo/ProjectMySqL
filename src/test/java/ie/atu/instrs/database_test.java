package ie.atu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class database_test {

    private static Connection connection;

    @BeforeAll
    public static void setUp() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            fail("Failed to establish connection in setup: " + e.getMessage());
        }
    }

    @Test
    public void testConnectionNotNull() {
        assertNotNull(connection, "Connection should not be null");
    }

    @Test
    public void testConnectionValid() {
        try {
            assertTrue(connection.isValid(2), "Connection should be valid");
        } catch (SQLException e) {
            fail("SQLException occurred while checking if connection is valid: " + e.getMessage());
        }
    }

    @Test
    public void testConnectionClosed() {
        try {
            connection.close();
            assertTrue(connection.isClosed(), "Connection should be closed");
        } catch (SQLException e) {
            fail("SQLException occurred while closing the connection: " + e.getMessage());
        }
    }

    @AfterAll
    public static void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
