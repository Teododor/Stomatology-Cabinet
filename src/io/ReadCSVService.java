package io;

import entities.appointment.Diagnosis;
import entities.appointment.Treatment;
import entities.personnel.Doctor;
import entities.personnel.Pacient;
import exceptions.WrongObjectType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadCSVService {
    private static ReadCSVService instance;

    private ReadCSVService() {

    }

    public static ReadCSVService getInstance() {
        if (instance == null) {
            instance = new ReadCSVService();
        }
        return instance;
    }

    public <T> List<T> readCSV(String path, String objectName) {
        List<T> date = new ArrayList<>();
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] obj = line.split(",");
                for (int i = 0; i < obj.length; i++)
                    obj[i] = obj[i].trim();
                rows.add(obj);
            }
            if (objectName.equalsIgnoreCase("Doctor")) {
                for (var object : rows) {
                    Doctor doctor = new Doctor(object[0], object[1], object[2]);
                    date.add((T) doctor);
                }
            } else if (objectName.equalsIgnoreCase("Treatment")) {
                for (var object : rows) {
                    Treatment treatment = new Treatment(object[0], Integer.parseInt(object[1]), Integer.parseInt(object[2]), object[3]);
                    date.add((T) treatment);
                }
            } else if (objectName.equalsIgnoreCase("Pacient")) {
                for (var object : rows) {
                    Pacient p = new Pacient(object[0], object[1], object[2]);
                    date.add((T) p);
                }
            } else if (objectName.equalsIgnoreCase("Diagnosis")) {
                for (var object : rows) {
                    Diagnosis diagnosis = new Diagnosis(object[0]);
                    date.add((T) diagnosis);
                }
            } else throw new WrongObjectType("The type of object that must be read does not exist");


        } catch (WrongObjectType ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return date;
    }


}
