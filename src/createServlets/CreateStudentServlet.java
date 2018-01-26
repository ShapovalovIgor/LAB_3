package createServlets;

import servlestDB.ConnectDB;
import servlestDB.Group;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Пользователь on 15.04.2015.
 */
public class CreateStudentServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Group> groups = ConnectDB.instance().allGroupRow();
        req.setAttribute("groups",groups);
        req.getRequestDispatcher("/createPages/createStudentPage.jsp").forward(req, resp);
    }
}
