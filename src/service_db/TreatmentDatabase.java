package service_db;

import entities.appointment.Treatment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatmentDatabase implements CRUD<Treatment>{

    @Override
    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS treatments" +
                "(treatment_id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), duration int, cost int, " +
                "recommendations varchar(70))";
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
    public void create(Treatment t) {
        String query = "INSERT INTO treatments (name, duration, cost, recommendations) " +
                "VALUES (?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, t.getName());
            pstm.setInt(2, t.getDuration());
            pstm.setInt(3, t.getCost());
            pstm.setString(4, t.getRecommendations());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Treatment> read() {
        String query = "SELECT * FROM treatments";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Treatment> lt = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Treatment t = new Treatment();
                t.setTreatment_id(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setDuration(rs.getInt(3));
                t.setCost(rs.getInt(4));
                t.setRecommendations(rs.getString(5));
                lt.add(t);
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lt;
    }

    public static Treatment readAt(int index) {
        String query = "SELECT * FROM treatments WHERE treatment_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Treatment t = new Treatment();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            t.setTreatment_id(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setDuration(rs.getInt(3));
            t.setCost(rs.getInt(4));
            t.setRecommendations(rs.getString(5));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public void update(Treatment t) {
        String query = "UPDATE treatments SET name = ?, duration = ?, cost = ?, recommendations = ? WHERE treatment_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, t.getName());
            pstm.setInt(2, t.getDuration());
            pstm.setInt(3, t.getCost());
            pstm.setString(4, t.getRecommendations());
            pstm.setInt(5, t.getTreatment_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM treatments WHERE treatment_id = " + index;
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
