package service;

import entities.appointment.Diagnosis;
import entities.appointment.Treatment;
import entities.personnel.Doctor;
import entities.personnel.Pacient;
import io.Audit;

public interface IPacientService {
    Audit audit = Audit.getInstance();
    void displayTotalPay(Pacient pacient);
    void displayAppointment(Pacient pacient);
    void displayRecommendations(Pacient pacient);
    void giveMark(Pacient pacient, double mark);
    void addDoctor(Pacient pacient, Doctor doctor);
    void addDiagnosis(Pacient pacient, Diagnosis diagnosis);
    void addTreatment(Pacient pacient, Treatment treatment);
}
