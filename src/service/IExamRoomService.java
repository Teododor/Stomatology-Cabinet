package service;

import entities.exam_room.ExamRoom;
import entities.personnel.Person;
import io.Audit;

public interface IExamRoomService {
    Audit audit = Audit.getInstance();
    void addPersonnel(ExamRoom examRoom, Person person);
    void deletePersonnel(ExamRoom examRoom, Person person);
    void displayDoctors(ExamRoom examRoom);
    void displayNurses(ExamRoom examRoom);
    void sortName(ExamRoom examRoom);
    void sortNrPatient(ExamRoom examRoom);
    void sortByMark(ExamRoom examRoom);
    void modifySalary(ExamRoom examRoom, Person person, int diff);
    void addMaterials(ExamRoom examRoom, String material, int quantity);
    void removeMaterials(ExamRoom examRoom, String material, int quantity);
    void displayStock(ExamRoom examRoom);
    void displayMaterial(ExamRoom examRoom, String material);
    void displaySalary(ExamRoom examRoom, Person person);
}
