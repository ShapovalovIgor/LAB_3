package servlestDB;

/**
 * Created by Пользователь on 02.04.2015.
 */
public class Group
{
    private int group_id;
    private String group_name;
    private int course;

    public Group(int group_id, String group_name, int course)
    {
        this.group_id = group_id;
        this.group_name = group_name;
        this.course = course;
    }

    public Group()
    {
    }

    public int getGroup_id()
    {
        return group_id;
    }

    public void setGroup_id(int group_id)
    {
        this.group_id = group_id;
    }

    public String getGroup_name()
    {
        return group_name;
    }

    public void setGroup_name(String group_name)
    {
        this.group_name = group_name;
    }

    public int getCourse()
    {
        return course;
    }

    public void setCourse(int course)
    {
        this.course = course;
    }
}
