package entities.personnel;

public class Nurse extends Person {
    private static int id = 0;
    private double salary;
    private int nurse_id;

    public Nurse() {
        this.nurse_id = ++id;
    }

    public Nurse(String first_name, String last_name, String PIN) {
        super(first_name, last_name, PIN);
        this.nurse_id = ++id;
    }

    public int getNurseId() {
        return nurse_id;
    }

    public void setNurseId(int nurse_id) {
        this.nurse_id = nurse_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Assistent " + this.getFullName();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (this == null || getClass() != object.getClass())
            return false;
        Nurse nurse = (Nurse) object;
        return Double.compare(nurse.salary, salary) == 0 && nurse_id == nurse.nurse_id;
    }

/*    @Override
    public int hashCode(){
        return Object.hash(salary, nurse_id);
    }*/


}
