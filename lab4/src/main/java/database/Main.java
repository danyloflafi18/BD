package database;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/"
            + "my1?allowPublicKeyRetrieval=true&useSSL=false&useUnicode="
            + "true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
            + "=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";



    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static void main(String args[]) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement()){

            resultSet = statement.executeQuery("SELECT * FROM hospital");
            readTableHospital();
            resultSet = statement.executeQuery("SELECT * FROM the_victim");
            readTableVictim();
            //updateNameOfVictim();
            //insertHospital(DriverManager.getConnection(URL, USER, PASSWORD));
            //deleteHospital();

        }catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
        }

    }
    private static void readTableHospital() throws SQLException {
        System.out.format("%nTable hospital "
                + "-----------------------------"
                + "-------------------------------%n");
        System.out.format("%-12s %-23s %s%n", "id_hospital",
                "name_of_hospital", "id_injured_lifeguards");
        while (resultSet.next()) {
            int idHospital = resultSet.getInt("id_hospital");
            String nameOfHospital = resultSet.getString("name_of_hospital");
            int idInjuredLifeguards = resultSet.getInt("id_injured_lifeguards");

            System.out.format("%-12s %-24s %s%n", idHospital, nameOfHospital,
                    idInjuredLifeguards);
        }
    }
    private static void readTableVictim() throws SQLException {
        System.out.format("%nTable the_victim "
                + "-----------------------------"
                + "-------------------------------%n");
        System.out.format("%-11s %-15s %-15s %-28s %s%n", "id_the_victim",
                "phone_number", "name_of_victim", "address", "id_cities");
        while (resultSet.next()) {
            int idTheVictim = resultSet.getInt("id_the_victim");
            int phoneNumber = resultSet.getInt("phone_number");
            String nameOfVictim = resultSet.getString("name_of_victim");
            String address = resultSet.getString("address");
            int idCities1 = resultSet.getInt("id_cities");
            System.out.format("%-13s %-15s %-15s %-29s %s%n", idTheVictim,
                    phoneNumber, nameOfVictim, address, idCities1);
        }
    }

    private static void updateNameOfVictim() throws SQLException {
        Scanner input = new Scanner(System.in, "UTF-8");
        System.out.println("Input name of victim what you want to update: ");
        String oldNameVictim = input.next();
        System.out.println("Input new name of victim for: " + oldNameVictim);
        String newNameVictim = input.next();

        statement.execute("UPDATE the_victim SET name_of_victim='"
                + newNameVictim
                + "' WHERE name_of_victim='" + oldNameVictim + "';");

    }


    private static void insertHospital(Connection connection) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a new hospital: ");
        String newHospital = input.next();
        System.out.println("Input a new injured lifeguards id: ");
        String newIdInjuredLifeguards = input.next();

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("INSERT into hospital (name_of_hospital,id_injured_lifeguards) VALUES (?,?)");
        preparedStatement.setString(1, newHospital);
        preparedStatement.setString(2,newIdInjuredLifeguards);


    }


    private static void deleteHospital() throws SQLException {
        Scanner input = new Scanner(System.in, "UTF-8");
        System.out.println("Input a hospital name for delete: ");
        String hospital = input.next();

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("DELETE FROM hospital "
                + "WHERE name_of_hospital=?");
        preparedStatement.setString(1, hospital);
        int n = preparedStatement.executeUpdate();
        System.out.println("Count rows that deleted: " + n);
    }
}

