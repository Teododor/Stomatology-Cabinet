package service_db;

import entities.appointment.Treatment;
import entities.personnel.Doctor;

import java.util.List;

public interface CRUD<T> {

    void createTable();
    void create(T o);
    List <T> read();
    void update(T o);
    void delete(int index);
}
