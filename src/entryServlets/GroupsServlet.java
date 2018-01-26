package entryServlets;

import servlestDB.ConnectDB;
import servlestDB.Group;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Пользователь on 04.04.2015.
 */
public class GroupsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Group> groups = ConnectDB.instance().allGroupRow();
        req.setAttribute("groups", groups);

        req.getRequestDispatcher("/entryPages/groupsPage.jsp").forward(req, resp);
    }
}
