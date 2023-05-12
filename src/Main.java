import entities.appointment.Appointment;
import entities.appointment.Diagnosis;
import entities.appointment.Treatment;
import entities.exam_room.ExamRoom;
import entities.personnel.Doctor;
import entities.personnel.Pacient;
import io.ReadCSVService;
import service.DoctorService;
import service.ExamRoomService;
import service.PacientService;
import service_db.AppointmentDatabase;
import service_db.DoctorDatabase;
import service_db.PacientDatabase;
import service_db.TreatmentDatabase;

import java.util.List;


public class Main {
    public static void main(String[] args) {

 /*       ExamRoomService CService = new ExamRoomService();
        DoctorService DService = new DoctorService();
        PacientService PService = new PacientService();
        ReadCSVService in = ReadCSVService.getInstance();


        List<Diagnosis> diagnosis = in.readCSV("data/diagnosis.csv", "Diagnosis");
        Diagnosis Di1 = diagnosis.get(0), Di2 = diagnosis.get(1), Di3 = diagnosis.get(2);*/


/*        List<Diagnosis> diagnosis = in.readCSV("data/diagnosis.csv", "Diagnosis");
        if (diagnosis.size() >= 3) {
            Diagnosis Di1 = diagnosis.get(0), Di2 = diagnosis.get(1), Di3 = diagnosis.get(2);
            // rest of the code
        } else {
            System.out.println("Error: not enough elements in the diagnosis list");
        }*/


    /*    List<Doctor> doctors = in.readCSV("data/doctors.csv", "Doctors");
        Doctor D1 = doctors.get(0), D2 = doctors.get(1), D3 = doctors.get(2);
        DoctorDatabase DDB = new DoctorDatabase();
        DDB.createTable();

        D1 = DoctorDatabase.readAt(3);
        D2 = DoctorDatabase.readAt(5);
        D3 = DoctorDatabase.readAt(4);

        TreatmentDatabase TDB = new TreatmentDatabase();
        TDB.createTable();

        List<Treatment> treatments = in.readCSV("data/treatments.csv", "Treatment");
        Treatment T1 = treatments.get(0), T2 = treatments.get(1), T3 = treatments.get(2);
        T1 = TreatmentDatabase.readAt(3);
        T2 = TreatmentDatabase.readAt(4);

        List<Pacient> pacients = in.readCSV("data/pacients.csv", "Pacients");
        Pacient P1 = pacients.get(0), P2 = pacients.get(1), P3 = pacients.get(2), P4 = pacients.get(3);
        PService.addDoctor(P1, D1);
        PService.addDiagnosis(P1, Di1);
        PService.addTreatment(P1, T1);
        PService.addDoctor(P2, D2);
        PService.addDiagnosis(P2, Di2);
        PService.addTreatment(P2, T1);
        PService.addDoctor(P3, D2);
        PService.addDiagnosis(P3, Di2);
        PService.addTreatment(P3, T1);
        PacientDatabase PDB = new PacientDatabase();

        P2 = PacientDatabase.readAt(8);
        Appointment Pr1 = new Appointment(30, 5, 2022, 14, 5, P1, "extraction");
        Appointment Pr2 = new Appointment(31, 5, 2022, 15, 40, P2, "scaling");
        AppointmentDatabase PrDB = new AppointmentDatabase();
        PrDB.createTable();
        PrDB.create(Pr2);
        PrDB.delete(2);
        Pr1 = AppointmentDatabase.readAt(8);
        Pr1.setSubject("no subject");
        PrDB.update(Pr1);*/


    }
}
