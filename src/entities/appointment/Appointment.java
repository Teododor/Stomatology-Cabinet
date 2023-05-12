package entities.appointment;

import entities.personnel.Pacient;

import java.util.Calendar;

public class Appointment implements Comparable<Appointment> {
    private int appointment_id;
    private Calendar data;
    private String subject;
    private Pacient pacient;

    public Appointment() {

    }

    public Appointment(int day, int month, int year, int hour, int minute, Pacient pacient, String subject) {
        this.data = Calendar.getInstance();
        this.data.set(year, month - 1, day, hour, minute, 0);
        this.pacient = pacient;
        this.subject = subject;
    }

    public void setData(int day, int month, int year, int hour, int minute) {
        this.data = Calendar.getInstance();
        this.data.set(day, month - 1, day, hour, minute);
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public void setData(Calendar calendar) {
        this.data = (Calendar) calendar.clone();
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public String getSubject() {
        return this.subject;
    }

    public Calendar getData() {
        return (Calendar) this.data.clone();
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "The Pacient " + this.pacient.getFullName() + " has the appointment " + this.subject + " on " + this.getData().getTime();
    }

    @Override
    public int compareTo(Appointment appointment) {
        return this.data.compareTo(appointment.getData());
    }
}
