package entities.appointment;

public class Diagnosis {
    private String name;

    public Diagnosis() {

    }

    public Diagnosis(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
