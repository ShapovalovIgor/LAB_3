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
 * Created by Пользователь on 04.04.2015.
 */
public class StudentsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Student> students = ConnectDB.instance().allStudentRow();
        req.setAttribute("students", students);

        req.getRequestDispatcher("/entryPages/studentsPage.jsp").forward(req, resp);
    }
}
