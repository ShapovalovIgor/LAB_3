package createServlets;

import servlestDB.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Пользователь on 04.04.2015.
 */
public class CreateGroupServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String group_name = req.getParameter("name");
        String course = req.getParameter("course");

        try
        {
            ConnectDB.instance().createGroup(group_name, course);
            createPage("Группа создалась!", resp);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            createPage("Не удалось создать группу", resp);
        }
    }

    private void createPage(String text, HttpServletResponse resp)
    {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;

        try
        {
            pw = new PrintWriter(resp.getWriter());
            pw.println(text);
            pw.println("<br>");
            pw.println("<a href=\"/top.jsp\">Назад</a>");
            pw.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(pw != null)
            pw.close();
    }
}
