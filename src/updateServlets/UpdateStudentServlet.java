package updateServlets;

import servlestDB.ConnectDB;
import servlestDB.Group;
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
public class UpdateStudentServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String stud_id = req.getParameter("stud_id");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String st_group_id = req.getParameter("st_group_id");
        String group_name = req.getParameter("group_name");

        List<Group> groups = ConnectDB.instance().allGroupRow();
        req.setAttribute("groups", groups);
        req.setAttribute("stud_id", stud_id);
        req.setAttribute("fname", fname);
        req.setAttribute("lname", lname);
        req.setAttribute("st_group_id", st_group_id);
        req.setAttribute("group_name", group_name);

        req.getRequestDispatcher("/updatePages/updateStudentPage.jsp").forward(req, resp);
    }
}
