package LocalDate_and_Time;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;
    private LocalDate joiningDate;

    public Employee(int id, String name, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }
}