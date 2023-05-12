package comparators;

import entities.personnel.Doctor;

import java.util.Comparator;

public class nrPacientsComparator implements Comparator<Doctor> {
    @Override
    public int compare(Doctor d1, Doctor d2){
        return d2.getNrPatients() - d1.getNrPatients();
    }
}
