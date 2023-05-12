package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Audit {
    private static Audit instance;
    private Audit(){}
    public static Audit getInstance() {
        if(instance == null){
            instance = new Audit();
        }
        return instance;
    }
    public void writeAudit(String action) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("data/audit.csv", true))){
            String line = '\n' + action + ", " + Calendar.getInstance().getTime();
            out.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
