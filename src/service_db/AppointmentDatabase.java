package service_db;


import entities.appointment.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDatabase implements CRUD<Appointment>{
    public void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS appointments" +
                "(appointment_id int PRIMARY KEY AUTO_INCREMENT, day int , month int, year int, hour int, minute int, " +
                "subject varchar(50), pacient_id int, doctor_id int)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            Statement stm = connection.createStatement();
            stm.execute(createTable);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void create(Appointment p) {
        String query = "INSERT INTO appointments (day, month, year, hour, minute, subject, pacient_id, doctor_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, p.getData().DAY_OF_WEEK);
            pstm.setInt(2, p.getData().MONTH);
            pstm.setInt(3, p.getData().YEAR);
            pstm.setInt(4, p.getData().HOUR_OF_DAY);
            pstm.setInt(5, p.getData().MINUTE);
            pstm.setString(6, p.getSubject());
            pstm.setInt(7, p.getPacient().getPacient_id());
            pstm.setInt(8, p.getPacient().getDoctor().getDoctor_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> read() {
        String query = "SELECT * FROM appointments";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Appointment> lp = new ArrayList<>();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            stm.close();
            while(rs.next()){
                Appointment p = new Appointment();
                p.setAppointment_id(rs.getInt(1));
                p.setData(rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
                p.setSubject(rs.getString(7));
                p.setPacient(PacientDatabase.readAt(rs.getInt(8)));
                lp.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lp;
    }

    @Override
    public void update(Appointment p) {
        String query = "UPDATE appointments SET day = ?, month = ?, year = ?, hour = ?, minute = ?, subject = ?, pacient_id = ?," +
                " doctor_id = ? WHERE appointment_id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1, p.getData().DAY_OF_WEEK);
            pstm.setInt(2, p.getData().MONTH);
            pstm.setInt(3, p.getData().YEAR);
            pstm.setInt(4, p.getData().HOUR_OF_DAY);
            pstm.setInt(5, p.getData().MINUTE);
            pstm.setString(6, p.getSubject());
            pstm.setInt(7, p.getPacient().getPacient_id());
            pstm.setInt(8, p.getPacient().getDoctor().getDoctor_id());
            pstm.setInt(9, p.getAppointment_id());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Appointment readAt(int index) {
        String query = "SELECT * FROM appointments WHERE appointment_id = " + index;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Appointment p = new Appointment();
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            p.setAppointment_id(rs.getInt(1));
            p.setData(rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
            p.setSubject(rs.getString(7));
            p.setPacient(PacientDatabase.readAt(rs.getInt(8)));
            p.setAppointment_id(rs.getInt(9));
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    public void delete(int index) {
        String query = "DELETE FROM appointments WHERE appointment_id = " + index;
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
