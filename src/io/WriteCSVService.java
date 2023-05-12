package io;

import entities.appointment.Treatment;
import entities.personnel.Doctor;
import entities.personnel.Nurse;
import entities.personnel.Pacient;
import exceptions.WrongObjectType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVService {

    private static WriteCSVService instance;

    private WriteCSVService() {}

    public static WriteCSVService getInstance() {
        if(instance == null) {
            instance = new WriteCSVService();
        }
        return instance;
    }

    public <T> void writeCSV(T object, String path) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            String line = "";
            if(object instanceof Doctor) {
                Doctor doctor = (Doctor) object;
                line += doctor.getFirstName() + ", " + doctor.getLastName() + ", " + doctor.getPIN() + ", " + doctor.getNrPatients() + "\n"; /*+ ", " +doctor.getSalary() + '\n';*/
                out.write(line);
            }
            else if(object instanceof Nurse) {
                Nurse nurse = (Nurse) object;
                line += nurse.getFirstName() + ", " + nurse.getLastName() + ", " + nurse.getPIN() + "\n";
                out.write(line);
            }
            else if(object instanceof Pacient) {
                Pacient pacient = (Pacient) object;
                line += pacient.getFirstName() + ", " + pacient.getLastName() + ", " + pacient.getPIN() + ", " + pacient.getTotalPay() + '\n';
                out.write(line);
            }
            else if(object instanceof Treatment) {
                Treatment treatment = (Treatment) object;
                line += treatment.getName() + ", " + treatment.getDuration() + ", " + treatment.getCost() + ", " + treatment.getRecommendations() + '\n';
                out.write(line);
            }
            else throw new WrongObjectType("Obiectul dat nu poate fi scris in fisier.");
        } catch (IOException | WrongObjectType e) {
            e.printStackTrace();
        }
    }
}