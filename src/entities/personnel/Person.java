package entities.personnel;

public class Person {
    protected String first_name;
    protected String last_name;
    protected String PIN;


    public Person() {

    }

    public Person(String first_name, String last_name, String PIN) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.PIN = PIN;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getPIN() {
        return this.PIN;
    }

    public void setFirstName(String name) {
        this.first_name = name;
    }

    public void setLastName(String name) {
        this.last_name = name;
    }

    public void setPIN(String pin) {
        this.PIN = pin;
    }

    public String getFullName() {
        return this.first_name + " " + this.last_name;
    }

    /* @Override*/
    public int compareTo(Person person) {
        String firstPerson = this.first_name + this.last_name;
        String secondPerson = this.first_name + this.last_name;
        return firstPerson.compareTo(secondPerson);
    }

    /*@Override*/
    public String toString() {
        return this.getFullName();
    }

}
