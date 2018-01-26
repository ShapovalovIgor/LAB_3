package searchServlets;

import servlestDB.ConnectDB;
import servlestDB.Group;
import servlestDB.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Пользователь on 02.04.2015.
 */
public class ThreeSearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String buttonOne = req.getParameter("sub_one");
        String buttonAllGroup = req.getParameter("sub_all_group");
        String buttonAllStudent = req.getParameter("sub_all_student");

        if (buttonOne != null)
            butOneClick(req, resp);

        else if(buttonAllGroup != null)
            butAllGroupClick(req, resp);

        else if(buttonAllStudent != null)
            butAllStudentClick(req, resp);
    }

    private void butOneClick(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        String table = (String) session.getAttribute("table");

        if(table.equals("Группа"))
        {
            String atribute = (String) session.getAttribute("atribute");
            String atributeValue = req.getParameter("text");

            List<Group> groups = ConnectDB.instance().searchInGroup(atribute, atributeValue);
            req.setAttribute("table", "Группа");
            req.setAttribute("groups", groups);

            req.getRequestDispatcher("/searchPages/resultSearchPage.jsp").forward(req, resp);
        }
        else if(table.equals("Студент"))
        {
            String atribute = (String) session.getAttribute("atribute");
            String atributeValue = req.getParameter("text");

            List<Student> students = ConnectDB.instance().searchInStudent(atribute,atributeValue);
            req.setAttribute("table", "Студент");
            req.setAttribute("students", students);

            req.getRequestDispatcher("/searchPages/resultSearchPage.jsp").forward(req,resp);
        }
    }

    private void butAllGroupClick(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HashMap<String, String> parameters = parametersGroup(req);
        List<Group> groups = ConnectDB.instance().searchInGroup(parameters);
        req.setAttribute("table", "Группа");
        req.setAttribute("groups", groups);

        req.getRequestDispatcher("/searchPages/resultSearchPage.jsp").forward(req, resp);
    }

    private void butAllStudentClick(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HashMap<String, String> parameters = parametersStudent(req);
        List<Student> students = ConnectDB.instance().searchInStudent(parameters);
        req.setAttribute("table", "Студент");
        req.setAttribute("students", students);

        req.getRequestDispatcher("/searchPages/resultSearchPage.jsp").forward(req,resp);
    }

    private HashMap<String, String> parametersGroup(HttpServletRequest req)
    {
        String group_name = req.getParameter("group_name");
        String course = req.getParameter("course");
        HashMap<String, String> hashMap = new HashMap<String, String>();

        if(group_name != "")
            hashMap.put("group_name", group_name);
        if(course != "")
            hashMap.put("course", course);

        return hashMap;
    }

    private HashMap<String, String> parametersStudent(HttpServletRequest req)
    {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String group_name = req.getParameter("group_name");
        HashMap<String, String> hashMap = new HashMap<String, String>();

        if(fname != "")
            hashMap.put("fname", fname);
        if(lname != "")
            hashMap.put("lname", lname);
        if(group_name != "")
            hashMap.put("group_name", group_name);

        return hashMap;
    }
}
