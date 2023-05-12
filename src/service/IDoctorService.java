package service;

import entities.personnel.Doctor;
import entities.personnel.Pacient;
import io.Audit;

public interface IDoctorService {
    Audit audit = Audit.getInstance();
    void displayAppointment(Doctor doctor);
    void displayAppointments(Doctor doctor);
    void removeAppointment(Doctor doctor);
    void displayTodayAppointment(Doctor doctor);
    void addFirstAppointment(Doctor doctor, Pacient pacient, int day, int month, int year, int hour, int minute, String subject);
    void addNextAppointment(Doctor doctor, String subject, int daysAfter);
}
