package entities.exam_room;

import entities.personnel.Doctor;
import entities.personnel.Nurse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamRoom {
    private List<Doctor> doctors;
    private List<Nurse> nurses;
    private Map<String, Integer> stock;

    public ExamRoom() {
        this.stock = new HashMap<>();
        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
    }

    public ExamRoom(ArrayList<Doctor> doctors,
                    ArrayList<Nurse> nurses) {
        this.doctors = doctors;
        this.nurses = nurses;
        this.stock = new HashMap<>();
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<String, Integer> stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        ExamRoom exr = (ExamRoom) object;
        return doctors.equals(exr.doctors) && nurses.equals(exr.nurses) && stock.equals(exr.stock);
    }

/*    @Override
    public int hashCode(){
        return Object.hash(doctors, nurses, stock);
    }*/
}
