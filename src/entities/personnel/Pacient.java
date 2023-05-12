package entities.personnel;

import entities.appointment.Appointment;
import entities.appointment.Diagnosis;
import entities.appointment.Treatment;

import java.util.Objects;

public class Pacient extends Person {
    private int pacient_id;
    private Diagnosis diagnosis;
    private Treatment treatment;
    private Appointment appointment;
    private Doctor doctor;
    private int totalPay;

    public Pacient() {

    }

    public Pacient(String first_name, String last_name, String PIN) {
        super(first_name, last_name, PIN);
    }

    public Pacient(String first_name, String last_name, String PIN, Doctor doctor, Diagnosis diagnosis, Treatment treatment) {
        super(first_name, last_name, PIN);
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.totalPay = treatment.getCost();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
        this.totalPay = treatment.getCost();
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public int getPacient_id() {
        return pacient_id;
    }

    public void setPacient_id(int pacient_id) {
        this.pacient_id = pacient_id;
    }

    @Override
    public String toString() {
        return "The Pacient " + this.getFullName() + " was diagnosed with " + this.diagnosis + " and follows the following treatment : " + this.treatment;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Pacient pacient = (Pacient) object;
        return pacient_id == pacient.pacient_id
                && totalPay == pacient.totalPay
                && Objects.equals(diagnosis, pacient.diagnosis)
                && Objects.equals(treatment, pacient.treatment)
                && Objects.equals(appointment, pacient.appointment)
                && Objects.equals(doctor, pacient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacient_id, diagnosis, treatment,
                appointment, doctor, totalPay);
    }

}
