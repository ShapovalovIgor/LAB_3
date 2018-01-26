package servlestDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by Пользователь on 26.03.2015.
 */
public class ConnectDB
{
    private static volatile ConnectDB instance;
    private Connection connection;

    public static ConnectDB instance()
    {
        ConnectDB localInstance = instance;
        if (localInstance == null)
        {
            synchronized (ConnectDB.class)
            {
                localInstance = instance;
                if (localInstance == null)
                {
                    instance = localInstance = new ConnectDB();
                }
            }
        }
        return localInstance;
    }

    public void init(String login, String password) throws SQLException
    {
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String urlDB = "jdbc:oracle:thin:@//localhost:1521/xe";
        Locale.setDefault(Locale.US);

        try
        {
            Class.forName(driverName);
            connection = DriverManager.getConnection(urlDB, login, password);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Group> allGroupRow()
    {
        String sql = "SELECT * FROM GROUP_STUDENTS";
        return answerGroup(sql);
    }

    public List<Student> allStudentRow()
    {
        String sql = "Select stud_id, fname, lname, st_group_id, group_name" +
                     " From STUDENTS, GROUP_STUDENTS Where group_id = st_group_id";
        return answerStudent(sql);
    }

    public List<Group> searchInGroup(String atribute, String value)
    {
        if(atribute.equals("Наименование группы"))
            atribute = "group_name";
        else if(atribute.equals("Курс"))
            atribute = "course";

        String sql = "Select * From GROUP_STUDENTS " +
                        "Where " + atribute + " = '" + value + "'";

        return answerGroup(sql);
    }

    public List<Group> searchInGroup(HashMap<String, String> parameters)
    {
        String sqlBegin = "Select * From GROUP_STUDENTS Where ";
        String sql = addConditions(sqlBegin, parameters);
        return answerGroup(sql);
    }

    public List<Student> searchInStudent(String atribute, String value)
    {
        if(atribute.equals("Имя"))
            atribute = "fname";
        else if(atribute.equals("Фамилия"))
            atribute = "lname";
        else if(atribute.equals("Группа"))
            atribute = "group_name";

        String sql = "Select stud_id, fname, lname, st_group_id, group_name" +
                " From STUDENTS, GROUP_STUDENTS " +
                "Where group_id = st_group_id AND " + atribute + " = '" + value + "'";

        return answerStudent(sql);
    }

    public List<Student> searchInStudent(HashMap<String, String> parameters)
    {
        String sqlBegin = "Select stud_id, fname, lname, st_group_id, group_name" +
                " From STUDENTS, GROUP_STUDENTS Where group_id = st_group_id AND ";
        String sql = addConditions(sqlBegin, parameters);
        return answerStudent(sql);
    }

    private String addConditions(String sqlBegin, HashMap<String, String> parameters)
    {
        StringBuilder sql = new StringBuilder(sqlBegin);
        int iterator = 0;

        for(HashMap.Entry<String, String> entry : parameters.entrySet())
        {
            if(iterator != 0)
                sql.append(" AND");
            iterator++;
            String parameter = entry.getKey();
            String value = entry.getValue();
            sql.append(" " + parameter + " = '" + value + "'");
        }

        return sql.toString();
    }

    private List<Group> answerGroup(String sql)
    {
        List<Group> groups = null;
        try
        {
            Statement statement = connection.createStatement();
            System.out.println("SQL: " + sql);

            ResultSet resultSet = statement.executeQuery(sql);
            groups = new ArrayList<Group>();

            while (resultSet.next())
            {
                int group_id = resultSet.getInt("group_id");
                String group_name = resultSet.getString("group_name");
                int course = resultSet.getInt("course");

                Group group = new Group(group_id,group_name,course);
                groups.add(group);

                System.out.println("Result DB: " + group_id + " " + group_name + " " + course);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return groups;
        }
    }

    private List<Student> answerStudent(String sql)
    {
       List<Student> students = null;

       try
       {
           Statement statement = connection.createStatement();
           System.out.println("SQL: " + sql);

           ResultSet resultSet = statement.executeQuery(sql);

           students = new ArrayList<Student>();

           while (resultSet.next())
           {
               int stud_id = resultSet.getInt("stud_id");
               String fname = resultSet.getString("fname");
               String lname = resultSet.getString("lname");
               int st_group_id = resultSet.getInt("st_group_id");
               String group_name = resultSet.getString("group_name");

               Student student = new Student(stud_id, fname, lname, st_group_id, group_name);
               students.add(student);

               System.out.println("Result DB: " + stud_id + " "+ fname +" "+ lname +" "+ st_group_id + " "+group_name);
           }
       }
       catch (SQLException e)
       {
           e.printStackTrace();
       }
       finally
       {
           return students;
       }
    }

    public void createGroup(String group_name, String course) throws SQLException
    {
        String sql = "INSERT INTO GROUP_STUDENTS(group_name, course) VALUES("
                + "'" + group_name + "', " + course + ")";

        System.out.println(sql);

        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    public void createStudent(String fname, String lname, String st_group_id) throws SQLException
    {
        String sql = "INSERT INTO STUDENTS(fname, lname, st_group_id) VALUES("
                + "'" + fname + "', " + "'" + lname + "', " + st_group_id + ")";

        System.out.println(sql);

        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    public void updateGroup(String group_id, String group_name, String course) throws SQLException
    {
            String sql = "Update GROUP_STUDENTS SET  group_name = " +"'" + group_name + "'"
                    + ", course = " + course
                    + " Where group_id = " + group_id;

            System.out.println("SQL: " + sql);

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
    }

    public void updateStudent(String stud_id, String fname, String lname, String st_group_id) throws SQLException
    {
        String sql = "Update STUDENTS SET  fname = '" + fname + "', lname = '" + lname +
                "', st_group_id = " + st_group_id +
                " Where stud_id = " + stud_id;

        System.out.println(sql);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

    }

    public void deleteGroup(String group_id) throws SQLException
    {
        String deleteStudentsSQL = "DELETE FROM STUDENTS " +
                                    "WHERE st_group_id = " + group_id;

        String deleteGroupSQL = "DELETE FROM GROUP_STUDENTS " +
                                "WHERE group_id = " + group_id;

        System.out.println("SQL: " + deleteStudentsSQL);
        System.out.println("SQL: " + deleteGroupSQL);

        Statement statement = connection.createStatement();
        statement.execute(deleteStudentsSQL);
        statement.execute(deleteGroupSQL);
    }

    public void deleteStudent(String stud_id) throws SQLException
    {
        String sql = "DELETE FROM STUDENTS" +
                " WHERE stud_id = " + stud_id;

        System.out.println("SQL: " + sql);

        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
}
