package service;

import comparators.markComparator;
import comparators.nrPacientsComparator;
import entities.exam_room.ExamRoom;
import entities.personnel.Doctor;
import entities.personnel.Nurse;
import entities.personnel.Person;

import java.util.List;
import java.util.Map;

public class ExamRoomService implements IExamRoomService {
    @Override
    public void addPersonnel(ExamRoom examRoom, Person person) {
        List<Doctor> doctors = examRoom.getDoctors();
        List<Nurse> nurses = examRoom.getNurses();

        if (person instanceof Doctor) {
            doctors.add((Doctor) person);
        } else if (person instanceof Nurse) {
            nurses.add((Nurse) person);
        }

        audit.writeAudit("Add Personnel");
    }

    @Override
    public void deletePersonnel(ExamRoom examRoom, Person person) {
        List<Doctor> doctors = examRoom.getDoctors();
        List<Nurse> nurses = examRoom.getNurses();
        if (person instanceof Doctor) {
            doctors.remove((Doctor) person);
        } else if (person instanceof Nurse) {
            nurses.remove((Nurse) person);
        }

        audit.writeAudit("Delete Personnel");
    }

    @Override
    public void displayDoctors(ExamRoom examRoom) {
        List<Doctor> doctors = examRoom.getDoctors();
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }

        audit.writeAudit("Display Doctors");
    }

    @Override
    public void displayNurses(ExamRoom examRoom) {
        List<Nurse> nurses = examRoom.getNurses();
        for (Nurse nurse : nurses) {
            System.out.println(nurse);
        }

        audit.writeAudit("Display Nurses");
    }

    @Override
    public void sortName(ExamRoom examRoom) {
        List<Doctor> doctors = examRoom.getDoctors();
        doctors.sort(null);
        audit.writeAudit("Sort Name");
    }

    @Override
    public void sortNrPatient(ExamRoom examRoom) {
        List<Doctor> doctors = examRoom.getDoctors();
        nrPacientsComparator comparator = new nrPacientsComparator();
        doctors.sort(comparator);
        audit.writeAudit("Sort Nr Patients");
    }

    @Override
    public void sortByMark(ExamRoom examRoom) {
        List<Doctor> doctors = examRoom.getDoctors();
        markComparator comparator = new markComparator();
        doctors.sort(comparator);
        audit.writeAudit("Sort Mark");
    }

    @Override
    public void modifySalary(ExamRoom examRoom, Person person, int diff) {
        if (person instanceof Doctor) {
            ((Doctor) person).setSalary(((Doctor) person).getSalary() + diff);
        } else if (person instanceof Nurse) {
            ((Nurse) person).setSalary(((Nurse) person).getSalary() + diff);
        }

        audit.writeAudit("Modify Salary");
    }

    @Override
    public void addMaterials(ExamRoom examRoom, String material, int quantity) {
        Map<String, Integer> stock = examRoom.getStock();
        if (stock.containsKey(material)) {
            int add = stock.get(material);
            stock.put(material, quantity + add);
        } else {
            stock.put(material, quantity);
        }

        audit.writeAudit("Add Materials");
    }

    @Override
    public void removeMaterials(ExamRoom examRoom, String material, int quantity) {
        Map<String, Integer> stock = examRoom.getStock();
        if (stock.containsKey(material)) {
            int rem = stock.get(material);
            rem -= quantity;
            if(rem <0){
                System.out.println("There is no " + material);
                stock.put(material, 0);
            }
            else {
                stock.put(material, rem);
            }
        }
        else {
            System.out.println("There is no more material!");
        }

        audit.writeAudit("Remove materials");
    }

    @Override
    public void displayStock(ExamRoom examRoom) {
        Map <String, Integer> stock = examRoom.getStock();
        stock.keySet().forEach((material) -> System.out.println(material + " " + stock.get(material)));
        audit.writeAudit("Display Stock");
    }

    @Override
    public void displayMaterial(ExamRoom examRoom, String material) {
        Map <String, Integer> stock = examRoom.getStock();
        if(stock.containsKey(material))
            System.out.println("There are " + stock.get(material) + " " + material);

        audit.writeAudit("Display Material");
    }

    @Override
    public void displaySalary(ExamRoom examRoom, Person person) {
        if(person instanceof Doctor){
            System.out.println("The Doctor " + person.getFullName() + " earn " + ((Doctor) person).getSalary());
        }
        else if(person instanceof Nurse){
            System.out.println("The Nurse " + person.getFullName() + " earns " +((Nurse) person).getSalary());
        }
        audit.writeAudit("Display Salary");
    }
}
