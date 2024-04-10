package StudentInformation;

import java.io.*;
import java.sql.*;

public class StudentInformation {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb", "<USERNAME>", "<PASSWORD>");
            System.out.println("Connected to the database successfully.");

            // Read student records from the file and add them to the database
            addStudentsFromFile(connection, "<TEXT FILE PATH>");

            System.out.println("All student records added to the database.");

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }

    // Method to add student records from a file to the database
    private static void addStudentsFromFile(Connection connection, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student VALUES (?, ?, ?)");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    String major = parts[2];
                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, major);
                    preparedStatement.addBatch();
                } else {
                    System.out.println("Invalid student record: " + line);
                }
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error reading student records from file: " + e.getMessage());
        }
    }
}