package service_db;

import entities.personnel.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDatabase implements CRUD <Doctor>{

    @Override
    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS doctors" +
                "(doctor_id int PRIMARY KEY AUTO_INCREMENT, first_name varchar(30), last_name varchar(30), pin varchar(15), " +
                "salary double, mark double, nrPacients int)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stm = connection.createStatement();
            stm.execute(createTable);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void create(Doctor d) {
        String query = "INSERT INTO doctors (first_name, last_name, pin, salary, mark, nrPatients) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, d.getFirstName());
            pstm.setString(2, d.getLastName());
            pstm.setString(3, d.getPIN());
            pstm.setDouble(4, d.getSalary());
            pstm.setDouble(5, d.getMark());
            pstm.setInt(6, d.getNrPatients());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Doctor> read() {
        String query = "SELECT * FROM doctors";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Doctor> ld = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Doctor d = new Doctor();
                d.setDoctor_id(rs.getInt(1));
                d.setFirstName(rs.getString(2));
                d.setLastName(rs.getString(3));
                d.setPIN(rs.getString(4));
                d.setSalary(rs.getDouble(5));
                d.setMark(rs.getDouble(6));
                d.setNrPatients(rs.getInt(7));
                ld.add(d);
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ld;
    }

    public static Doctor readAt(int index) {
        String query = "SELECT * FROM doctori WHERE doctor_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Doctor d = new Doctor();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            d.setDoctor_id(rs.getInt(1));
            d.setFirstName(rs.getString(2));
            d.setLastName(rs.getString(3));
            d.setPIN(rs.getString(4));
            d.setSalary(rs.getDouble(5));
            d.setMark(rs.getDouble(6));
            d.setNrPatients(rs.getInt(7));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }


    public void update(Doctor d) {
        String query = "UPDATE doctors SET first_name = ?, last_name = ?, PIN = ?, salary = ?, mark = ?, nrPatients = ? WHERE doctor_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, d.getFirstName());
            pstm.setString(2, d.getLastName());
            pstm.setString(3, d.getPIN());
            pstm.setDouble(4, d.getSalary());
            pstm.setDouble(5, d.getMark());
            pstm.setInt(6, d.getNrPatients());
            pstm.setInt(7, d.getDoctor_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int index) {
        String query = "DELETE FROM doctors WHERE doctor_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stm = connection.createStatement();
            stm.execute(query);
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
