package servlestDB;

/**
 * Created by Пользователь on 02.04.2015.
 */
public class Student
{
    private int stud_id;
    private String fname;
    private String lname;
    private int st_group_id;
    private String group_name;

    public Student()
    {
    }

    public Student(int stud_id, String fname, String lname, int st_group_id, String group_name)
    {
        this.stud_id = stud_id;
        this.fname = fname;
        this.lname = lname;
        this.st_group_id = st_group_id;
        this.group_name = group_name;
    }

    public int getStud_id()
    {
        return stud_id;
    }

    public void setStud_id(int stud_id)
    {
        this.stud_id = stud_id;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public int getSt_group_id()
    {
        return st_group_id;
    }

    public void setSt_group_id(int st_group_id)
    {
        this.st_group_id = st_group_id;
    }

    public String getGroup_name()
    {
        return group_name;
    }

    public void setGroup_name(String group_name)
    {
        this.group_name = group_name;
    }
}
