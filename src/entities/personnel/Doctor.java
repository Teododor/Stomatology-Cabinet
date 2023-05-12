package entities.personnel;

import entities.appointment.Appointment;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Doctor extends Person {
    private double salary;
    private double mark;
    private int nrPatients;
    private int doctor_id;
    private Nurse nurse;
    private Queue<Appointment> appointments;


    public Doctor() {

    }

    public Doctor(String first_name, String second_name, String PIN) {
        super(first_name, second_name, PIN);
        this.appointments = new PriorityQueue<>();
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setnurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getNrPatients() {
        return nrPatients;
    }

    public void setNrPatients(int nrPatients) {
        this.nrPatients = nrPatients;
    }

    public Queue<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Queue<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return this.getFullName() + "has " + this.getMark() + " rating";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Doctor doctor = (Doctor) object;
        return Double.compare(doctor.salary, salary) == 0 && Double.compare(doctor.mark, mark) == 0 && nrPatients == doctor.nrPatients
                && doctor_id == doctor.doctor_id
                && Objects.equals(nurse, doctor.nurse) && Objects.equals(appointments, doctor.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, mark, nrPatients, doctor_id, nurse, appointments);
    }

}
