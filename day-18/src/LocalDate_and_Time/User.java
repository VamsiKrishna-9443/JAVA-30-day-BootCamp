package LocalDate_and_Time;

import java.time.LocalDate;

public class User
{
    private int id;
    private String name;
    private LocalDate planTakenDate;
    private int durationMonths;

    User(int id , String name,LocalDate planTakenDate,int durationMonths)
    {
        this.id = id;
        this.name = name;
        this.planTakenDate = planTakenDate;
        this.durationMonths = durationMonths;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public  LocalDate getPlanTakenDate()
    {
        return planTakenDate;
    }
    public int getDurationMonths()
    {
        return durationMonths;
    }
}
