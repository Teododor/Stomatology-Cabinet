package service;

import entities.appointment.Appointment;
import entities.personnel.Doctor;
import entities.personnel.Pacient;

import java.util.Calendar;
import java.util.Queue;

public class DoctorService implements IDoctorService {
    @Override
    public void displayAppointment(Doctor doctor) {
        Queue<Appointment> appointments = doctor.getAppointments();
        if (appointments.isEmpty()) {
            System.out.println("There is no Appointment");
            return;
        }
        System.out.println(appointments.peek());
        audit.writeAudit("Display Appointment");
    }

    @Override
    public void displayAppointments(Doctor doctor) {
        Queue<Appointment> appointments = doctor.getAppointments();
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
        audit.writeAudit("Display Appointments");
    }

    @Override
    public void removeAppointment(Doctor doctor) {
        Queue<Appointment> appointments = doctor.getAppointments();
        appointments.remove();
        audit.writeAudit("Remove Appointment");
    }

    @Override
    public void displayTodayAppointment(Doctor doctor) {
        Calendar calendar = Calendar.getInstance();
        Queue<Appointment> appointments = doctor.getAppointments();
        for (Appointment appointment : appointments) {
            if (appointment.getData().get(Calendar.DAY_OF_MONTH) != calendar.get(Calendar.DAY_OF_MONTH))
                break;
            System.out.println(appointment);
        }
    }

    @Override
    public void addFirstAppointment(Doctor doctor, Pacient pacient, int day, int month, int year, int hour, int minute, String subject) {
        Appointment newAppointment = new Appointment(day, month, year, hour, minute, pacient, subject);
        Queue<Appointment> appointments = doctor.getAppointments();
        appointments.add(newAppointment);
        pacient.setAppointment(newAppointment);
        audit.writeAudit("Add First Appointment");
    }

    @Override
    public void addNextAppointment(Doctor doctor, String subject, int daysAfter) {
        Queue <Appointment> appointments = doctor.getAppointments();
        Appointment newAppointment = new Appointment();
        Appointment currentAppointment = appointments.peek();
        if(currentAppointment == null){
            return;
        }

        Pacient pacient = currentAppointment.getPacient();
        Calendar newDate = currentAppointment.getData();
        newDate.add(Calendar.DATE, daysAfter);
        newAppointment.setData(newDate);
        newAppointment.setSubject(subject);
        newAppointment.setPacient(pacient);
        pacient.setAppointment(newAppointment);
        appointments.add(newAppointment);
        audit.writeAudit("Add Next Appointment");

    }
}
