package entryServlets;

import servlestDB.ConnectDB;
import servlestDB.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Пользователь on 05.04.2015.
 */
public class StudentsInGroupServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String group_id = req.getParameter("group_id");
        String group_name = req.getParameter("group_name");
        List<Student> students = ConnectDB.instance().searchInStudent("st_group_id", group_id);
        req.setAttribute("students", students);
        req.setAttribute("group_name", group_name);

        System.out.println(group_id + " " + group_name);
        req.getRequestDispatcher("/entryPages/studentsInGroupPage.jsp").forward(req, resp);
    }
}
