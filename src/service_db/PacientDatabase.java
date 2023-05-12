package service_db;

import entities.personnel.Pacient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientDatabase implements CRUD<Pacient>{

    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS patients" +
                "(pacient_id int PRIMARY KEY AUTO_INCREMENT, first_name varchar(30), last_name varchar(30), PIN varchar(15), " +
                "doctor_id int, treatment_id int, totalPay int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stm = connection.createStatement();
            stm.execute(createTable);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void create(Pacient p) {
        String query = "INSERT INTO pacienti (first_name, last_name, PIN, doctor_id, treatment_id, totalPay) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, p.getFirstName());
            pstm.setString(2, p.getLastName());
            pstm.setString(3, p.getPIN());
            pstm.setInt(4, p.getDoctor().getDoctor_id());
            pstm.setInt(5, p.getTreatment().getTreatment_id());
            pstm.setInt(6, p.getTotalPay());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pacient> read(){
        String query = "SELECT * FROM patients";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Pacient> lp = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pacient p = new Pacient();
                p.setPacient_id(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setPIN(rs.getString(4));
                p.setTreatment(TreatmentDatabase.readAt(rs.getInt(5)));
                p.setDoctor(DoctorDatabase.readAt(rs.getInt(6)));
                p.setTotalPay(rs.getInt(7));
                lp.add(p);
            }
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lp;
    }

    public static Pacient readAt(int index) {
        String query = "SELECT * FROM pacienti WHERE pacient_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Pacient p = new Pacient();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            p.setPacient_id(rs.getInt(1));
            p.setFirstName(rs.getString(2));
            p.setLastName(rs.getString(3));
            p.setPIN(rs.getString(4));
            p.setTreatment(TreatmentDatabase.readAt(rs.getInt(5)));
            p.setDoctor(DoctorDatabase.readAt(rs.getInt(6)));
            p.setTotalPay(rs.getInt(7));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void update(Pacient p) {
        String query = "UPDATE pacienti SET nume = ?, prenume = ?, cnp = ?, doctor_id = ?, tratament_id = ?, " +
                "totalPlata = ? WHERE pacient_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, p.getFirstName());
            pstm.setString(2, p.getLastName());
            pstm.setString(3, p.getPIN());
            pstm.setInt(4, p.getDoctor().getDoctor_id());
            pstm.setInt(5, p.getTreatment().getTreatment_id());
            pstm.setInt(6, p.getTotalPay());
            pstm.setInt(7, p.getPacient_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM pacienti WHERE pacient_id = " + index;
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
