package practice;

public class Worker
{
    int id;
    String name;

    Worker(int id ,String name)
    {
        this.id = id;
        this.name = name;
    }

    public String toString()
    {
        return  "Worker id :" + id + " name :" + name ;
    }
}
