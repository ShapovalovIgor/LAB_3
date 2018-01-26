package updateServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Пользователь on 05.04.2015.
 */
public class UpdateGroupServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String group_id = req.getParameter("group_id");
        String group_name = req.getParameter("group_name");
        String group_head_id = req.getParameter("course");
        req.setAttribute("group_id", group_id);
        req.setAttribute("group_name", group_name);
        req.setAttribute("course", group_head_id);
        req.getRequestDispatcher("/updatePages/updateGroupPage.jsp").forward(req, resp);
    }
}
