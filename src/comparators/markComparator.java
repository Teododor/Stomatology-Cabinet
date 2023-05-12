package comparators;

import entities.personnel.Doctor;

import java.util.Comparator;

public class markComparator implements Comparator<Doctor> {
    @Override
    public int compare(Doctor d1, Doctor d2){
        return -Double.compare(d1.getMark(), d2.getMark());
    }

}
