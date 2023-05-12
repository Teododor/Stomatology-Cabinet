package service;

import entities.appointment.Appointment;
import entities.appointment.Diagnosis;
import entities.appointment.Treatment;
import entities.personnel.Doctor;
import entities.personnel.Pacient;

public class PacientService implements IPacientService {
    @Override
    public void displayTotalPay(Pacient pacient) {
        int totalPay = pacient.getTotalPay();
        if(totalPay ==0){
            System.out.println("The pacient " + pacient.getFullName() + "has nothing to pay");
            return;
        }
        System.out.println("The Pacient " + pacient.getFullName() + " has to pay " + totalPay);
        audit.writeAudit("Display Total Pay");
    }

    @Override
    public void displayAppointment(Pacient pacient) {
        Appointment appointment = pacient.getAppointment();
        if(appointment == null){
            System.out.println("The Pacient has no appointments");
            return;
        }
        System.out.println(appointment);
        audit.writeAudit("Display Appointment");
    }

    @Override
    public void displayRecommendations(Pacient pacient) {
        Treatment treatment = pacient.getTreatment();
        if(treatment == null || treatment.getRecommendations().equals("")){
            System.out.println("The Pacient has no recommendations");
            return;
        }
        System.out.println("The Pacient " + pacient.getFullName() +" has the following recommendation: " + treatment.getRecommendations());
    }

    @Override
    public void giveMark(Pacient pacient, double mark) {
        Doctor doctor = pacient.getDoctor();
        int nrPacients = doctor.getNrPatients() + 1;
        doctor.setNrPatients(nrPacients);
        double doctorMark = doctor.getMark();
        doctorMark = (doctorMark + mark) / nrPacients;
        doctor.setMark(doctorMark);
        audit.writeAudit("Give Mark");

    }

    @Override
    public void addDoctor(Pacient pacient, Doctor doctor) {
        pacient.setDoctor(doctor);
        audit.writeAudit("Add Doctor");
    }

    @Override
    public void addDiagnosis(Pacient pacient, Diagnosis diagnosis) {
        pacient.setDiagnosis(diagnosis);
        audit.writeAudit("Add Diagnosis");
    }

    @Override
    public void addTreatment(Pacient pacient, Treatment treatment) {
        pacient.setTreatment(treatment);
        audit.writeAudit("Add Treatment");
    }
}
